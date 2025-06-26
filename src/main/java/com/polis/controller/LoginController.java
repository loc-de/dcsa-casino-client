package com.polis.controller;

import com.polis.AppContext;
import com.polis.dto.LoginRequest;
import com.polis.dto.RegisterRequest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private void handleLogin() {
        String login = loginField.getText();
        String password = passwordField.getText();

        LoginRequest request = new LoginRequest(login, password);

        if (AppContext.getAuthService().login(request)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main_page.fxml"));
                Parent mainPageRoot = loader.load();

                Scene scene = loginField.getScene();
                scene.setRoot(mainPageRoot);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}