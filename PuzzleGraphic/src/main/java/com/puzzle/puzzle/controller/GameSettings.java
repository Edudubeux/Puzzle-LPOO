package com.puzzle.puzzle.controller;

import com.puzzle.puzzle.exceptions.NomeExtensoException;
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

    public User user;

    public GameSettings () {
        this.user = new User();
    }

    public void voltarMenu (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/menu.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void preencherNome () {
        if (user.getNome().length() != 0) {
            this.nameField.setText(user.getNome());
        }
    }

    public void setNome (ActionEvent event) throws IOException, NomeExtensoException {
        if (nameField.getText().length() <= 20 && nameField.getText().length() >= 3) {
            this.user.setNome(nameField.getText());
            new Puzzle(this.user);
            root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/puzzle.fxml"));
            scene = new Scene(root); 
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
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

