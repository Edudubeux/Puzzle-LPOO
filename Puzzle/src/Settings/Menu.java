package Settings;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame{
    private Boolean iniciar;
    private Boolean sair;
    private int dificuldade;
    private JPanel Menu;
    private JButton iniciarButton;

    public Menu(int dificuldade) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Menu);
        this.dificuldade = dificuldade;
    }

    public void setIniciar(Boolean iniciar) {
        this.iniciar = iniciar;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void setSair(Boolean sair) {
        this.sair = sair;
    }

    public static void main(String[] args) {
        JFrame frame = new Menu(1);
        frame.setSize(new Dimension(700, 700));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


        frame.setVisible(true);
    }
}