package com.puzzle.puzzle.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private Button normal;

    @FXML
    private Button maluco;

    @FXML
    private Button numeros;

    @FXML
    private Button letras;

    @FXML
    private Button imagem;

    @FXML
    private Button facil;

    @FXML
    private Button medio;

    @FXML
    private Button dificil;

    private User user = new User();

    public void voltarMenu (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void voltarNome (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/gameSettings.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getNome (ActionEvent event) throws IOException {
        user.setNome(nameField.getText());
        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/gameSettings2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getMode (ActionEvent event) throws IOException {
        if(event.getSource().toString().equals(normal.toString())){
            user.setMode(1);
        } else if (event.getSource().toString().equals(maluco.toString())){
            user.setMode(2);
        }

        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/gameSettings3.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getTipo (ActionEvent event) throws IOException {
        if(event.getSource().toString().equals(numeros.toString())){
            user.setTipo("numeros");
        } else if(event.getSource().toString().equals(letras.toString())){
            user.setTipo("letras");
        } else if(event.getSource().toString().equals(imagem.toString())){
            user.setTipo("imagem");
        }

        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/gameSettings4.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getDificuldade (ActionEvent event) throws IOException {
        if(event.getSource().toString().equals(facil.toString())){
            user.setNivel(2);
        } else if(event.getSource().toString().equals(medio.toString())){
            user.setNivel(3);
        } else if(event.getSource().toString().equals(dificil.toString())){
            user.setNivel(4);
        }

//        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/gameSettings4.fxml")); Criar tabuleiro
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

    public void voltarModo (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/gameSettings2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void voltarTipo (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/puzzle/puzzle/views/gameSettings3.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

