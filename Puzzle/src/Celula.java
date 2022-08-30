public class Celula {
    private int numero;

    private Celula up;
    private Celula down;
    private Celula left;
    private Celula right;
    private Tabuleiro tabuleiro;

    public Celula(int numero, Tabuleiro tabuleiro) {
        this.setNumero(numero);
        this.tabuleiro = tabuleiro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void trocaNumero(Celula origem, Celula destino) {
        int temporario = origem.getNumero();
        origem.setNumero(destino.getNumero());
        destino.setNumero(temporario);
    }

    public Celula getSetaUp() {
        return up;
    }

    public void setSetaUp(Celula up) {
        this.up = up;
    }

    public Celula getSetaDown() {
        return down;
    }

    public void setSetaDown(Celula down) {
        this.down = down;
    }

    public Celula getSetaLeft() {
        return left;
    }

    public void setSetaLeft(Celula left) {
        this.left = left;
    }

    public Celula getSetaRight() {
        return right;
    }

    public void setSetaRight(Celula right) {
        this.right = right;
    }

    public void moverParaCima() {
        trocaNumero(this, up);
    }

    public void moverParaBaixo() {
        trocaNumero(this, down);
    }

    public void moverParaEsquerda() {
        trocaNumero(this, left);
    }

    public void moverParaDireita() {
        trocaNumero(this, right);
    }
}