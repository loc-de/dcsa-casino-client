package com.polis.storage;

import lombok.Getter;
import lombok.Setter;

public class SessionStorage {

    @Getter
    @Setter
    private static String token;

    @Getter
    @Setter
    private static Integer userId;

}
