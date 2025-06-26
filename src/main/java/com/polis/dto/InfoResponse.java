package com.polis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InfoResponse {

    private int userId;
    private String username;
    private BigDecimal balance;

}
