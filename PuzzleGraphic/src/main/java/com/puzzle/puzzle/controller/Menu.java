package com.puzzle.puzzle.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private AnchorPane menu;

    public void iniciarGame (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/gameSettings.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void fecharGame (ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Tem certeza que deseja fechar o jogo?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) menu.getScene().getWindow();
            stage.close();
        }
    }

    public void openRanking (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/ranking.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
