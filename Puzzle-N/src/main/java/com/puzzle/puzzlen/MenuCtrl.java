package com.puzzle.puzzlen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuCtrl implements Initializable {
    public void teste () {
        System.out.println("oi");
    }

    @FXML
    private Button teste;

    @FXML
    void teste(ActionEvent event) {

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
