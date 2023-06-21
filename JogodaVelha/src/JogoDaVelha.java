
public class JogoDaVelha {
	private char[][] tabuleiro;

    public JogoDaVelha(int tamanho) {
        this.tabuleiro = new char[tamanho][tamanho];
    }

    public boolean realizaJogada(int linha, int coluna, char jogador) {
        if (tabuleiro[linha][coluna] == 0) {
            tabuleiro[linha][coluna] = jogador;
            return true;
        } else {
            return false;
        }
    }

    public boolean verificaGanhador() {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][0] != 0 && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return true;
            }
            if (tabuleiro[0][i] != 0 && tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                return true;
            }
        }
        if (tabuleiro[0][0] != 0 && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return true;
        }
        if (tabuleiro[0][2] != 0 && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return true;
        }
        return false;
    }

    public String toString() {
        String resultado = "";
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                resultado += tabuleiro[i][j] + " ";
            }
            resultado += "\n";
        }
        return resultado;
    }
}
