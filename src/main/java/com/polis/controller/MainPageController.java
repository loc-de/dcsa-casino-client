package com.polis.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private void initialize() {
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