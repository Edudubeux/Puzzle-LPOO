package com.puzzle.puzzle.controller;

import javafx.application.Application;

import static jdk.internal.org.jline.terminal.Terminal.MouseTracking.Button;

public class Aplicar {

    private Parent createContent() {
        TextField fieldNome = new TextField();
        Button btnSave = new Button("SALVAR");
        btnSave.setOnAction(event -> {
            SaveJogo data = new SaveJogo();
            try {
                Gerenciamento.Salvar(data, "1.save");
            }
            catch(Exception e) {
                System.out.println("Nao salvou "+ e.getMessage());
            }
        });
        Button btnLoad = new Button("CONSULTAR");
        btnLoad.setOnAction(event -> {
            try {

                SaveJogo data = (SaveJogo) Gerenciamento.Consultar("1.save");
                fieldNome.setText(data.nome);
            }catch(Exception e) {
                System.out.println("Nao salvou " + e.getMessage());
            }
        });
        return null;
    }
}