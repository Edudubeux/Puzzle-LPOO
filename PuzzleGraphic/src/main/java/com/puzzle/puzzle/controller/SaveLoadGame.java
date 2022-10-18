package com.puzzle.puzzle.controller;

import java.io.*;

public class SaveLoadGame {

    private User user;

    public SaveLoadGame(User user){
        this.user = user;
    }

    public void saveGame() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt"));

            bw.write(user.getNome());
            bw.newLine();
            bw.write(user.getTipo());
            bw.newLine();
            bw.write(user.getMode());
            bw.newLine();
            bw.write(user.getNivel());
            bw.newLine();

        }
        catch (Exception e) {
        }
    }

    public void loadGame() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("saveFile.txt"));

//            user.getNome() = br.readLine();
//            user.getTipo() = Integer.parseInt(br.readLine());
//            user.getMode() = Integer.parseInt(br.readLine());
//            user.getNivel() = Integer.parseInt(br.readLine());

        } catch (Exception e) {
        }

        if (new File("C:/Puzzle-LPOO/PuzzleGraphic/src/main/resources/com/puzzle/puzzle/save").isFile()){
            new File("C:/Puzzle-LPOO/PuzzleGraphic/src/main/resources/com/puzzle/puzzles/ave").delete();
    }

}





}


