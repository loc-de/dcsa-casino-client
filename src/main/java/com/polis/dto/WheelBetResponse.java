package com.polis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WheelBetResponse {

    private String resultColor;
    private String resultVideo;
    private BigDecimal resultMoney;

}
