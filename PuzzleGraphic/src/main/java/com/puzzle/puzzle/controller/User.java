package com.puzzle.puzzle.controller;

public class User {
    private String nome;
    private int nivel;
    private int mode;

    private int tipo;

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getNome () {
        return this.nome;
    }

    public int getTipo () {
        return this.tipo;
    }

    public void setTipo (int tipo) {
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
