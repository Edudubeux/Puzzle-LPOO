package com.puzzle.puzzle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class JogoMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader menu = new FXMLLoader(JogoMain.class.getResource("views/menu.fxml"));
        Scene scene = new Scene(menu.load());
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            try {
                event.consume();
                fecharGame(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void fecharGame (Stage stage) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Tem certeza que deseja fechar o jogo?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}