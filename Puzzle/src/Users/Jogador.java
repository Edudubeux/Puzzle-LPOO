package Users;

public class Jogador {
    private String jogadorNome;
    private double pontuacao;
    private int jogadas;
    private int rank;
    private int id;

    public Jogador(String nome) {
        this.jogadorNome = nome;
    }

    public String getNomeJogador(int id) {
        return this.jogadorNome;
    }

    public void setNomeJogador(String nome) {
        this.jogadorNome = nome;
    }
}