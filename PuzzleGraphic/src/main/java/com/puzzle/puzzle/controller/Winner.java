package com.puzzle.puzzle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Winner {
    @FXML
    private Label winnerMsg;

    public void setWinnerMsg (String userName, int userNivel) {
        winnerMsg.setText("Parabéns " + userName + " \nvocê venceu o puzzle " + userNivel + "X" + userNivel + "!");
    }
}
