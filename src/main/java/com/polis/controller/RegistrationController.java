package com.polis.controller;

import com.polis.AppContext;
import com.polis.dto.RegisterRequest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    private void handleLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml")); // шлях до login.fxml
            Parent loginRoot = loader.load();

            Scene scene = loginField.getScene();
            scene.setRoot(loginRoot);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleRegister() {
        String login = loginField.getText();
        String password = passwordField.getText();

        RegisterRequest request = new RegisterRequest(login, password);

        if (AppContext.getAuthService().register(request)) {
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
