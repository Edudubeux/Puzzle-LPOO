package com.puzzle.puzzle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuCtrl implements Initializable {
    public void test () {
        System.out.println("oi");
    }

    public void iniciarGame (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/gameSettings.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        PauseTransition pause = new PauseTransition(Duration.millis(100));
        pause.setOnFinished(e -> {
            stage.setScene(scene);
            stage.show();
        });
    }
    @FXML
    private Button iniciar;

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
