import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Nome do primeiro jogador: ");
	        Jogador jogador1 = new Jogador(scanner.nextLine());

	        System.out.print("Nome do segundo jogador: ");
	        Jogador jogador2 = new Jogador(scanner.nextLine());

	        System.out.print("Tamanho desejado do tabuleiro: ");
	        int tamanhoTabuleiro = scanner.nextInt();
	        scanner.nextLine();

	        JogoDaVelha jogo = new JogoDaVelha(tamanhoTabuleiro);

	        Jogador jogadorAtual = jogador1;

	        boolean jogarNovamente = true;
	        while (jogarNovamente) {
	            boolean jogoAcabou = false;
	            while (!jogoAcabou) {
	                System.out.println(jogo);

	                System.out.print(jogadorAtual.getNome() + ", informe a linha da jogada: ");
	                int linha = scanner.nextInt();

	                System.out.print(jogadorAtual.getNome() + ", informe a coluna da jogada: ");
	                int coluna = scanner.nextInt();
	                scanner.nextLine();

	                char simboloJogadorAtual = jogadorAtual == jogador1 ? 'X' : 'O';
	                boolean jogadaValida = jogo.realizaJogada(linha, coluna, simboloJogadorAtual);

	                if (!jogadaValida) {
	                    System.out.println("Jogada inválida, tente novamente.");
	                    continue;
	                }

	                if (jogo.verificaGanhador()) {
	                    System.out.println(jogo);
	                    System.out.println(jogadorAtual.getNome() + " venceu!");

	                    jogadorAtual.aumentaPontos();

	                    jogoAcabou = true;

	                    System.out.print("Desejam jogar novamente? (S/N): ");
	                    String resposta = scanner.nextLine().toUpperCase();
	                    jogarNovamente = resposta.equals("S");

	                    if (!jogarNovamente) {
	                        try {
	                            FileWriter writer = new FileWriter("resultado.txt");
	                            writer.write("Vencedor: " + jogadorAtual.getNome() + " - Pontos: " + jogadorAtual.getPontos());
	                            writer.close();
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	                    } else {
	                        jogo = new JogoDaVelha(tamanhoTabuleiro);
	                        jogadorAtual = jogador1;
	                    }
	                } else {
	                    jogadorAtual = jogadorAtual == jogador1 ? jogador2 : jogador1;
	                }

	                if (jogoAcabou && jogarNovamente) {
	                    System.out.println("\nIniciando novo jogo...");
	                }
	            }
	        }
	        scanner.close();
	    }

}
