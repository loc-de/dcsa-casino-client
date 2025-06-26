package com.polis.controller;

import com.polis.ApiClient;
import com.polis.AppContext;
import com.polis.dto.*;
import com.polis.storage.SessionStorage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.math.BigDecimal;

public class MainPageController {

    public ImageView slot1;
    public ImageView slot2;
    public ImageView slot3;

    private String selectedColor = "WHITE";

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
    private TextField codeField;

    @FXML
    private Label labelTop1;

    @FXML
    private Label labelTop2;

    @FXML
    private Button SecretButton;


    @FXML
    private void handleSecretButton() {
        String code = codeField.getText();

        CodeRequest request = new CodeRequest(SessionStorage.getUserId(), code);

        AppContext.getUserService().code(request);
        updateInfo();
    }

    @FXML
    private void handleBetButtonLeft() {
        BigDecimal betAmount = parseBetAmount(betAmountInputLeft);

        WheelBetRequest request = new WheelBetRequest(SessionStorage.getUserId(), selectedColor, betAmount);
        WheelBetResponse response = AppContext.getGameService().wheelBet(request);

        // вмикати анімацію

        updateInfo();
    }

    @FXML
    private void handleBetButtonCenter() {
        BigDecimal betAmount = parseBetAmount(betAmountInputCenter);

        SlotsBetRequest request = new SlotsBetRequest(SessionStorage.getUserId(), betAmount);
        SlotsBetResponse response = AppContext.getGameService().slotsBet(request);

        updateSlotImage(slot1, response.getResultCombination()[1]);
        updateSlotImage(slot2, response.getResultCombination()[2]);
        updateSlotImage(slot3, response.getResultCombination()[3]);

        updateInfo();
    }

    private BigDecimal parseBetAmount(TextField field) {
        String betAmountString = field.getText();

        try {
            return new BigDecimal(Integer.parseInt(betAmountString));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void updateInfo() {
//        InfoResponse response = AppContext.getUserService().info();
//
//        if (response == null) {
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registration.fxml"));
//                Parent mainPageRoot = loader.load();
//
//                Scene scene = betButtonLeft.getScene();
//                scene.setRoot(mainPageRoot);
//                return;
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        labelTop1.setText(response.getUsername());
//        labelTop2.setText(response.getBalance().toString());
//
//        if (SessionStorage.getUserId() == null) {
//            SessionStorage.setUserId(response.getUserId());
//        }
    }

    @FXML
    private void initialize() {
        updateInfo();

        // бет
        betButtonLeft.setOnAction(event -> {
            String amount = betAmountInputLeft.getText();
            System.out.println("left BET. bet: " + amount);
        });

        betButtonCenter.setOnAction(event -> {
            String amount = betAmountInputCenter.getText();
            System.out.println("center BET. bet: " + amount);
        });

        // колір
        mark1Left.setOnAction(e -> selectOnlyMark(1));
        mark2Left.setOnAction(e -> selectOnlyMark(2));
        mark3Left.setOnAction(e -> selectOnlyMark(3));
        selectOnlyMark(1);
    }

    private void selectOnlyMark(int markNumber) {
        mark1Left.setOpacity(markNumber == 1 ? 1.0 : 0);
        mark2Left.setOpacity(markNumber == 2 ? 1.0 : 0);
        mark3Left.setOpacity(markNumber == 3 ? 1.0 : 0);

        switch (markNumber) {
            case 1 -> selectedColor = "WHITE";
            case 2 -> selectedColor = "RED";
            case 3 -> selectedColor = "GREEN";
        }

        System.out.println("Selected color: " + selectedColor);
    }

    private void updateSlotImage(ImageView slot, String symbolName) {
        String path = "/img/" + symbolName + ".png";
        Image image = new Image(getClass().getResource(path).toExternalForm());
        slot.setImage(image);
    }
}