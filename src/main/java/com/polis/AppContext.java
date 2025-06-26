package com.polis;

import com.polis.service.AuthService;
import com.polis.service.UserService;
import lombok.Getter;

public class AppContext {

    @Getter
    private static final AuthService authService = new AuthService();

    @Getter
    private static final UserService userService = new UserService();

}
