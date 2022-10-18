package com.puzzle.puzzle.controller;

import com.puzzle.puzzle.movimentos.MovimentosChar;
import com.puzzle.puzzle.movimentos.MovimentosNum;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Puzzle {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private User user;

    private int[][] gabaritoNum;
    private char[][] gabaritoChar;

    public Puzzle(User user) {
        this.user = user;
    }

    @FXML
    private GridPane gridTab;
    @FXML
    private Label nameLabel;

    public void setNameOnBoard() {
        nameLabel.setText("Nome:  " + this.user.getNome());
    }

    private Button[][] buttons;

    public int[] randomizarNum (int[] numbers) {
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            int rand = random.nextInt((this.user.getNivel() * this.user.getNivel()));
            int p = numbers[i];
            numbers[i] = numbers[rand];
            numbers[rand] = p;
        }

        return numbers;
    }

    public char[] randomizarChar (char[] chars) {
        Random random = new Random();
        chars[chars.length - 1] = '0';

        for (int i = 0; i < chars.length - 1; i++) {
            int rand = random.nextInt((this.user.getNivel() * this.user.getNivel()));
            char p = chars[i];
            chars[i] = chars[rand];
            chars[rand] = p;
        }

        return chars;
    }

    public Character changeToChar (int i) {
        return i > 0 && i < 27 ? Character.valueOf((char)(i + 'A' - 1)) : null;
    }

    public void voltarMenu (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/menu.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void restart () {
        if (this.user.getTipo() == 1){
            createNumTab();
        } else if (this.user.getTipo() == 2) {
            createCharTab();
        }
    }

    public void createNumTab() {
        int numbers[] = new int[this.user.getNivel() * this.user.getNivel()];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        numbers[(this.user.getNivel() * this.user.getNivel()) - 1] = 0;

        randomizarNum(numbers);

        int k = 0;
        buttons = new Button[user.getNivel()][user.getNivel()];

        MovimentosNum movNum = new MovimentosNum(buttons, user);

        for (int i = 0; i < user.getNivel(); i++) {
            for (int j = 0; j < user.getNivel(); j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setText(String.valueOf(numbers[k]));
                buttons[i][j].setStyle("-fx-background-color:  RGB(253,185,39)");
                buttons[i][j].setPrefSize(200, 200);

                if (buttons[i][j].getText().equals("0")) {
                    buttons[i][j].setStyle("-fx-text-fill: TRANSPARENT");
                    movNum.setPosI(i);
                    movNum.setPosJ(j);
                }

                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        movNum.ActionPerformed(event);
                        try {
                            if(checkWinNum()) {
                                Winner winner = new Winner();
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("/com/puzzle/puzzle/views/winner.fxml"));
                                loader.setController(winner);
                                root = loader.load();
                                scene = new Scene(root);
                                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                winner.setWinnerMsg(user.getNome(), user.getNivel());
                                stage.setScene(scene);
                                stage.show();
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                gridTab.add(buttons[i][j], j, i);
                k++;
            }
        }
    }

    public void createCharTab() {
        char chars[] = new char[this.user.getNivel() * this.user.getNivel()];

        for (int i = 0; i < chars.length; i++) {
            Character letter = changeToChar(i + 1);
            chars[i] = letter;
        }

        chars[(this.user.getNivel() * this.user.getNivel()) - 1] = 0;

        randomizarChar(chars);

        int k = 0;
        buttons = new Button[user.getNivel()][user.getNivel()];

        MovimentosChar movChar = new MovimentosChar(buttons, user);

        for (int i = 0; i < user.getNivel(); i++) {
            for (int j = 0; j < user.getNivel(); j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setText(String.valueOf(chars[k]));
                buttons[i][j].setStyle("-fx-background-color:  RGB(253,185,39)");
                buttons[i][j].setPrefSize(200, 200);

                System.out.println(buttons[i][j].getText());

                if (buttons[i][j].getText().equals("0")) {
                    System.out.println("olarr");
                    buttons[i][j].setStyle("-fx-text-fill: TRANSPARENT");
                    movChar.setPosI(i);
                    movChar.setPosJ(j);
                }

                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        movChar.ActionPerformed(event);
                        try {
                            if(checkWinChar()) {
                                Winner winner = new Winner();
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("/com/puzzle/puzzle/views/winner.fxml"));
                                loader.setController(winner);
                                root = loader.load();
                                scene = new Scene(root);
                                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                winner.setWinnerMsg(user.getNome(), user.getNivel());
                                stage.setScene(scene);
                                stage.show();
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                gridTab.add(buttons[i][j], j, i);
                k++;
            }
        }
    }


    public void createGabaNum() {
        int[][] gabarito = new int[this.user.getNivel()][this.user.getNivel()];

        for (int i = 0; i < user.getNivel(); i++) {
            for (int j = 0; j < user.getNivel(); j++) {
                gabarito[i][j] = j + 1 + (i * this.user.getNivel());
            }
        }

        gabarito[(this.user.getNivel() - 1)][(this.user.getNivel() - 1)] = 0;

        this.gabaritoNum = gabarito;
    }

    public void createGabaChar() {
        char[][] gabarito = new char[this.user.getNivel()][this.user.getNivel()];

        for (int i = 0; i < user.getNivel(); i++) {
            for (int j = 0; j < user.getNivel(); j++) {
                char novo = changeToChar(j + 1 + (i * this.user.getNivel()));
                gabarito[i][j] = novo;
            }
        }

        gabarito[(this.user.getNivel() - 1)][(this.user.getNivel() - 1)] = 0;

        this.gabaritoChar = gabarito;
    }

    public boolean checkWinNum() throws IOException {
        for (int i = 0; i < user.getNivel(); i++) {
            for (int j = 0; j < user.getNivel(); j++) {
                if(!buttons[i][j].getText().equals(String.valueOf(gabaritoNum[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWinChar() throws IOException {
        for (int i = 0; i < user.getNivel(); i++) {
            for (int j = 0; j < user.getNivel(); j++) {
                if(!buttons[i][j].getText().equals(gabaritoChar[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
