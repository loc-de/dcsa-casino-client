package com.polis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.polis.ApiClient;
import com.polis.dto.CodeRequest;
import com.polis.dto.InfoResponse;
import com.polis.security.CryptoService;
import lombok.SneakyThrows;

import java.net.http.HttpResponse;

public class UserService {

    private static final String BASE_URL = "http://localhost:18842/api/user";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public InfoResponse info() {
        HttpResponse<byte[]> response = ApiClient.post(BASE_URL + "/info");

        if (response.statusCode() != 200) {
            return null;
        }

        return objectMapper.readValue(
                CryptoService.decrypt(response.body()),
                InfoResponse.class
        );
    }

    public void code(CodeRequest request) {
        ApiClient.post(BASE_URL + "/code", request);
    }

}
