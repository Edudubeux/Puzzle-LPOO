import Settings.Menu;

public class Tabuleiro extends Settings.Menu {
    private int celulaVazia;
    private int quantCelulas;
    private int tabuleiro[];

    public Tabuleiro(int dificuldade) {
        super(dificuldade);

        if (dificuldade == 1) {
            this.quantCelulas = 4;
        } else if (dificuldade == 2) {
            this.quantCelulas = 8;
        } else {
            this.quantCelulas = 12;
        }
    }

    public void createTabuleiro (){
        for (int i = 0; i < this.quantCelulas; i++) {
            tabuleiro[i] = i + 1;
        }
    }
}
