package com.puzzle.puzzle.controller;
import java.util.*;

public class Ranking {

    private TreeMap<Double, List<String>> ranking;

    public Ranking() {
        ranking = new TreeMap<Double, List<String>>();


        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int n = r.nextInt(10);
            add("Objeto " + n, n);
        }

        int i = 0;
        for (Map.Entry<Double, List<String>> entry : ranking.descendingMap().entrySet())
            System.out.println(++i + "º " + entry.getValue());

    }

    public void add(String obj, double nota) {
        List<String> list = ranking.get(nota);

        if (list == null) {
            ranking.put(nota, new ArrayList<String>());

            ranking.get(nota).add(obj);
        }


    }
}
