package com.puzzle.puzzle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Puzzle {
    private User usuario = new User();

    private Button buttons[][] = new Button[usuario.getNivel()][usuario.getNivel()];

    public Button[][] tabuleiro () {
        for (int i = 1; i <= usuario.getNivel(); i++) {
            for (int j = 1; j <= usuario.getNivel(); j++) {

            }
        }

        return buttons;
    }
}
