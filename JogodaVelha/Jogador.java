
public class Jogador {
	private String nome;
    private int pontos;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontos = 0;
    }
    
    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void aumentaPontos() {
        pontos++;
    }

    public String toString() {
        return "Jogador: " + nome + " - Pontos: " + pontos;
    }
}
