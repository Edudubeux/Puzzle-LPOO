package com.puzzle.puzzle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.Random;

public class Puzzle{
    private User user;

    public Puzzle (User user) {
        this.user = user;
    }

    @FXML
    private GridPane gridTab;

    @FXML
    private Label nameLabel;

    public void setNameOnBoard () {
        nameLabel.setText("Nome: " + this.user.getNome());
    }

    private Button[][] buttons;

    public int[] randomizar (int[] numbers) {
        Random random = new Random();

        for (int i=0; i<numbers.length; i++) {
            int rand = random.nextInt((this.user.getNivel()*this.user.getNivel()));
            int p = numbers[i];
            numbers[i] = numbers[rand];
            numbers[rand] = p;
        }

        return numbers;
    }

    public void createTab () {
        int numbers[] = new int[this.user.getNivel()*this.user.getNivel()];

        for (int i=0; i<numbers.length; i++) {
            numbers[i] = i + 1;
        }

        numbers[(this.user.getNivel()*this.user.getNivel()) - 1] = 0;

        randomizar(numbers);

        int k = 0;
        buttons = new Button[user.getNivel()][user.getNivel()];
        for (int i = 0; i < user.getNivel(); i++) {
            for (int j = 0; j < user.getNivel(); j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setText(String.valueOf(numbers[k]));
                buttons[i][j].setStyle("-fx-background-color:  RGB(253,185,39)");

                if(buttons[i][j].getText().equals("0")) {
                    buttons[i][j].setStyle("-fx-text-fill: TRANSPARENT");
                    buttons[i][j].setPrefSize(200,200);
                } else {
                    buttons[i][j].setPrefSize(200,200);
                }

                gridTab.add(buttons[i][j], j, i);
                k++;
            }
        }
    }
}
