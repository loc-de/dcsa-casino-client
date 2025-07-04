package com.polis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.polis.ApiClient;
import com.polis.dto.*;
import com.polis.security.CryptoService;
import lombok.SneakyThrows;

import java.net.http.HttpResponse;

public class GameService {

    private static final String BASE_URL = "http://localhost:18842/api/game";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public SlotsBetResponse slotsBet(SlotsBetRequest request) {
        HttpResponse<byte[]> response = ApiClient.post(BASE_URL + "/slots", request);

        System.out.println(response);

        if (response.statusCode() != 200) {
            return null;
        }

        return objectMapper.readValue(
                CryptoService.decrypt(response.body()),
                SlotsBetResponse.class
        );
    }

    @SneakyThrows
    public WheelBetResponse wheelBet(WheelBetRequest request) {
        HttpResponse<byte[]> response = ApiClient.post(BASE_URL + "/wheel", request);
        System.out.println(response);
        if (response.statusCode() != 200) {
            return null;
        }

        return objectMapper.readValue(
                CryptoService.decrypt(response.body()),
                WheelBetResponse.class
        );
    }

}
