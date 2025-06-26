package com.polis.service;

import com.polis.ApiClient;
import com.polis.dto.LoginRequest;
import com.polis.dto.RegisterRequest;
import com.polis.storage.SessionStorage;

import java.net.http.HttpResponse;

public class AuthService {

    private static final String BASE_URL = "http://localhost:18840/api/auth";

    public boolean login(LoginRequest request) {
        HttpResponse<String> response = ApiClient.post(BASE_URL + "/login", request);

        if (response.statusCode() == 200) {
            String token = response.headers().firstValue("x-token").orElse(null);
            if (token != null) {
                SessionStorage.setToken(token);
                return true;
            }
        }
        return false;
    }

    public boolean register(RegisterRequest request) {
        HttpResponse<String> response = ApiClient.post(BASE_URL + "/register", request);

        if (response.statusCode() == 200) {
            String token = response.headers().firstValue("x-token").orElse(null);
            if (token != null) {
                SessionStorage.setToken(token);
                return true;
            }
        }
        return false;
    }

}
