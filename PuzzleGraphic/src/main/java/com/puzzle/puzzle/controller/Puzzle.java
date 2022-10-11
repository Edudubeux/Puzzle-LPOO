package com.puzzle.puzzle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class Puzzle{
    private User user;

    public Puzzle (User user) {
        this.user = user;
        this.createTab();
        this.setNameOnBoard();
    }

    @FXML
    private GridPane gridTab;

    @FXML
    private Label nameLabel;

    public void setNameOnBoard () {
        nameLabel.setText(this.user.getNome());
    }

    private Button[][] buttons = new Button[user.getNivel()][user.getNivel()];

    public int[] randomizar () {
        Random random = new Random(0);
        int numbers[] = new int[this.user.getNivel()*this.user.getNivel()];

        for (int i=0; i<numbers.length; i++) {
            numbers[i] = random.nextInt((this.user.getNivel()*this.user.getNivel()) + 1);
        }

        numbers[(this.user.getNivel()*this.user.getNivel()) + 1] = 0;

        return numbers;
    }

    public void createTab () {
        int k = 0;
        for (int i = 1; i <= user.getNivel(); i++) {
            for (int j = 1; j <= user.getNivel(); j++) {
                if(this.randomizar()[k] == 0) {
                    buttons[i][j] = new Button();
                    buttons[i][j].setStyle("-fx-background-color:  RGB(85,37,155)");
                    buttons[i][j].setStyle("-fx-font-size: 0px");
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
