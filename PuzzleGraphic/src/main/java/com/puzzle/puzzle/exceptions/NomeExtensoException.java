package com.puzzle.puzzle.exceptions;

public class NomeExtensoException extends Exception{
    public NomeExtensoException () {
        super("Por favor insira um nome entre 3 e 20 caracteres.");
    }
}
