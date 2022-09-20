package com.puzzle.puzzle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JogoMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader menu = new FXMLLoader(JogoMain.class.getResource("views/menu.fxml"));
        FXMLLoader gameSettings = new FXMLLoader(JogoMain.class.getResource("views/gameSettings.fxml"));
        FXMLLoader gameSettings2 = new FXMLLoader(JogoMain.class.getResource("views/gameSettings2.fxml"));
        FXMLLoader gameSettings3 = new FXMLLoader(JogoMain.class.getResource("views/gameSettings3.fxml"));
        FXMLLoader gameSettings4 = new FXMLLoader(JogoMain.class.getResource("views/gameSettings4.fxml"));

        Scene scene = new Scene(menu.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}