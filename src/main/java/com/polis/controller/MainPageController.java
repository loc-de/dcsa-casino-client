package com.polis.controller;

import com.polis.ApiClient;
import com.polis.AppContext;
import com.polis.dto.InfoResponse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainPageController {

    @FXML
    private Button betButtonLeft;

    @FXML
    private Button betButtonCenter;

    @FXML
    private Button mark1Left;

    @FXML
    private Button mark2Left;

    @FXML
    private Button mark3Left;

    @FXML
    private TextField betAmountInputLeft;

    @FXML
    private TextField betAmountInputCenter;

    @FXML
    private Label labelTop1;

    @FXML
    private Label labelTop2;

    @FXML
    private void initialize() {
        InfoResponse response = AppContext.getUserService().info();

        if (response == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registration.fxml"));
                Parent mainPageRoot = loader.load();

                Scene scene = betButtonLeft.getScene();
                scene.setRoot(mainPageRoot);
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        labelTop1.setText(response.getUsername());
        labelTop2.setText(response.getBalance().toString());

        // BET кнопки
        betButtonLeft.setOnAction(event -> {
            String amount = betAmountInputLeft.getText();
            System.out.println("left BET. bet: " + amount);
        });

        betButtonCenter.setOnAction(event -> {
            String amount = betAmountInputCenter.getText();
            System.out.println("center BET. bet: " + amount);
        });

        // MARK кнопки
        mark1Left.setOnAction(e -> System.out.println("mark 1 clicked"));
        mark2Left.setOnAction(e -> System.out.println("mark 2 clicked"));
        mark3Left.setOnAction(e -> System.out.println("mark 3 clicked"));
    }
}