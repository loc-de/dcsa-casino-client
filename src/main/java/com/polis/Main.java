package com.polis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/base_layout.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
//        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/fxml/style.css")).toExternalForm());

        primaryStage.setTitle("Casino Client");
        primaryStage.setWidth(1100);
        primaryStage.setHeight(600);
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}