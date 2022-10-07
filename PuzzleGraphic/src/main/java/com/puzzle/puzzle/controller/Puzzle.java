package com.puzzle.puzzle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.Random;

import static jdk.internal.org.jline.terminal.Terminal.MouseTracking.Button;

public abstract class Puzzle {
    private User user = new User();

    @FXML
    private GridPane gridTab;

    private Button[][] buttons = new Button[user.getNivel()][user.getNivel()];

    public int[] randomizar () {
        Random random = new Random();
        int numbers[] = new int[this.user.getNivel()];

        for (int i=0; i<numbers.length; i++) {
            numbers[i] = random.nextInt(this.user.getNivel()*this.user.getNivel());
        }

        return numbers;
    }

    public void createTab () {
        int k = 0;
        for (int i = 1; i <= user.getNivel(); i++) {
            for (int j = 1; j <= user.getNivel(); j++) {
                if(this.randomizar()[k] == 0) {
                    buttons[i][j] = new Button();
                    buttons[i][j].setStyle("-fx-background-color:  RGB(85,37,155)");
                } else {
                    buttons[i][j] = new Button();
                    buttons[i][j].setStyle("-fx-background-color: RGB(253,185,39)");
                    buttons[i][j].setText(String.valueOf(randomizar()[k]));
                }

                gridTab.add(buttons[i][j], i, j);
                k++;
            }
        }
    }
}
