package com.polis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SlotsBetResponse {

    private String[] resultCombination;
    private BigDecimal resultMoney;

}
