package com.polis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CodeRequest {

    private int userId;
    private String code;

}
