package com.puzzle.puzzle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class User {
    private String nome;
    private int nivel;
    private int mode;

    private String tipo;

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getNome () {
        return this.nome;
    }

    public String getTipo () {
        return this.tipo;
    }

    public void setTipo (String tipo) {
        this.tipo = tipo;
    }

    public void setMode (int mode) {
        this.mode = mode;
    }

    public int getMode () {
        return this.mode;
    }

    public void setNivel (int nivel) {
        this.nivel = nivel;
    }

    public int getNivel () {
        return this.nivel;
    }
}
