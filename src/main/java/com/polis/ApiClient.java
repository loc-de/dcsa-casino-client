package com.polis;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.polis.security.CryptoService;
import com.polis.storage.SessionStorage;
import lombok.SneakyThrows;

public class ApiClient {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static <T> HttpResponse<byte[]> post(String url, Object body) {
        String json = objectMapper.writeValueAsString(body);
        byte[] encrypted = CryptoService.encrypt(json.getBytes(StandardCharsets.UTF_8));

        HttpRequest request = baseBuilder(url)
                .POST(HttpRequest.BodyPublishers.ofByteArray(encrypted))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofByteArray());
    }

    public static HttpResponse<byte[]> post(String url) {
        try {
            HttpRequest.Builder builder = baseBuilder(url);
            HttpRequest request = builder
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpRequest.Builder baseBuilder(String url) {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/octet-stream");

        String token = SessionStorage.getToken();
        if (token != null) {
            builder.header("Authorization", "Bearer " + token);
        }

        return builder;
    }

}
