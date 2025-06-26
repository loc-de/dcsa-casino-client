package com.polis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class SlotsBetRequest {

    private int userId;
    private BigDecimal betAmount;

}
