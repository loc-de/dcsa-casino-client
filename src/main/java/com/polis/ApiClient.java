package com.polis;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.polis.storage.SessionStorage;
import lombok.SneakyThrows;

public class ApiClient {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static <T> HttpResponse<String> post(String url, Object body) {
        String json = objectMapper.writeValueAsString(body);

        HttpRequest.Builder builder = baseBuilder(url);
        HttpRequest request = builder
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static HttpResponse<String> post(String url) {
        try {
            HttpRequest.Builder builder = baseBuilder(url);
            HttpRequest request = builder
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpRequest.Builder baseBuilder(String url) {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json");

        String token = SessionStorage.getToken();
        if (token != null) {
            builder.header("Authorization", "Bearer " + token);
        }

        return builder;
    }

}
