package com.puzzle.puzzle.movimentos;

import com.puzzle.puzzle.controller.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MovimentosNum{
    private Button buttons[][];
    private User user;

    private int posI;
    private int posJ;

    public MovimentosNum (Button[][] buttons, User user) {
        this.buttons = buttons;
        this.user = user;
    }

    public void setPosI (int i) {
        posI = i;
    }

    public void setPosJ (int j) {
        posJ = j;
    }

    public void ActionPerformed (ActionEvent event) {
        for (int i = 0; i< buttons.length; i++) {
            for (int j = 0; j < user.getNivel(); j++) {
                if(event.getSource() == buttons[i][j]) {
                    if (((i + 1 == posI && j == posJ) || (i - 1 == posI && j == posJ) || (i == posI && j + 1 == posJ || (i == posI && j - 1 == posJ)))) {
                        buttons[posI][posJ].setText(buttons[i][j].getText());
                        buttons[posI][posJ].setStyle("-fx-background-color:  RGB(253,185,39)");
                        buttons[i][j].setStyle("-fx-text-fill: TRANSPARENT");
                        buttons[i][j].setText("0");

                        setPosJ(j);
                        setPosI(i);
                    }
                }
            }
        }
    }
}
