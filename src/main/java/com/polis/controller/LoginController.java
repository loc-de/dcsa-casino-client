package com.polis.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        System.out.println("Registration:\nLogin: " + login + "\nPassword: " + password);
    }
}