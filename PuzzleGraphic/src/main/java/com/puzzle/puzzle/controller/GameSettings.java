package com.puzzle.puzzle.controller;

import com.puzzle.puzzle.exceptions.NomeExtensoException;
import com.puzzle.puzzle.exceptions.OpcoesException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameSettings implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField nameField;

    @FXML
    private RadioButton normal;

    @FXML
    private RadioButton maluco;

    @FXML
    private RadioButton numeros;

    @FXML
    private RadioButton letras;

    @FXML
    private RadioButton imagem;

    @FXML
    private RadioButton facil;

    @FXML
    private RadioButton medio;

    @FXML
    private RadioButton dificil;

    @FXML
    private Label erro;

    private User user = new User();

    public void voltarMenu (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/menu.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setNome (ActionEvent event) throws IOException, NomeExtensoException, OpcoesException {
        if (nameField.getText().length() <= 20 && nameField.getText().length() >= 3) {
            this.user.setNome(nameField.getText());
            if((normal.isSelected() || maluco.isSelected()) && (numeros.isSelected() || letras.isSelected() || imagem.isSelected()) && (facil.isSelected() || medio.isSelected() || dificil.isSelected())) {
                Puzzle puzzle = new Puzzle(this.user);
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/puzzle/puzzle/views/puzzle.fxml"));
                loader.setController(puzzle);
                root = loader.load();
                scene = new Scene(root);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                if (this.user.getTipo() == 1) {
                    System.out.println("numero");
                    puzzle.createNumTab();
                    puzzle.createGabaNum();
                } else if (this.user.getTipo() == 2){
                    System.out.println("letra");
                    puzzle.createCharTab();
                    puzzle.createGabaChar();
                }
                puzzle.setNameOnBoard();
                stage.setScene(scene);
                stage.show();
            } else {
                OpcoesException err = new OpcoesException();
                erro.setText(err.getMessage());
            }
        } else {
            NomeExtensoException err = new NomeExtensoException();
            erro.setText(err.getMessage());
        }
    }

    public void setMode (ActionEvent event) throws IOException {
        if(normal.isSelected()){
            user.setMode(1);
        } else if (maluco.isSelected()){
            user.setMode(2);
        }
    }

    public void setTipo (ActionEvent event) throws IOException {
        if(numeros.isSelected()){
            user.setTipo(1);
        } else if(letras.isSelected()){
            user.setTipo(2);
        } else if(imagem.isSelected()){
            user.setTipo(3);
        }
    }

    public void setDificuldade (ActionEvent event) throws IOException{
        if(facil.isSelected()){
            user.setNivel(2);
        } else if(medio.isSelected()){
            user.setNivel(3);
        } else if(dificil.isSelected()){
            user.setNivel(4);
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

