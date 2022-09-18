package com.puzzle.puzzlen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JogoMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader menu = new FXMLLoader(JogoMain.class.getResource("views/menu.fxml"));
        Scene scene = new Scene(menu.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}