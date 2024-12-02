package jogodavelha;
import java.util.Scanner;

    public class Jogo {
        public static void main(String[] args) {
            char[][] tabuleiroVazio = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
            boolean fim = false;
            char jogadorAtual = 'X';

            Scanner sc = new Scanner(System.in);

            while (!fim) {
                //Recebe as entradas
                tabuleiro(tabuleiroVazio);
                System.out.println("Jogador " + jogadorAtual);
                System.out.println("Escolha a linha e a coluna, a cada escolha tecle enter !!");
                int linha = sc.nextInt();
                int coluna = sc.nextInt();

                //Verifica as condições se vence se empata.
                if (validarJogo(tabuleiroVazio, linha, coluna)) {
                    tabuleiroVazio[linha][coluna] = jogadorAtual;
                    if (vencedor(tabuleiroVazio, jogadorAtual)) {
                        tabuleiro(tabuleiroVazio);
                        System.out.println("Parabéns o jogador " + jogadorAtual + " venceu!");
                        fim = true;
                    } else if (verificarEmpate(tabuleiroVazio)) {
                        tabuleiro(tabuleiroVazio);
                        System.out.println("O jogo deu empate!");
                        fim = true;
                    } else {
                        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Jogada inválida!");
                    System.out.println("Tente novamente!");
                }
            }

            sc.close();
        }
        //Percorre o tabuleiro
        public static void tabuleiro(char[][] tabuleiro) {
            System.out.println("  0 1 2");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(tabuleiro[i][j]);
                    if (j < 2) System.out.print("|");
                }
                System.out.println();
                if (i < 2) System.out.println(" ");
            }
        }
        //Metodos de verificação.

        public static boolean validarJogo(char[][] tabuleiro, int linha, int coluna) {
            return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == '-';
        }

        public static boolean vencedor(char[][] tabuleiro, char jogador) {
            for (int i = 0; i < 3; i++) {
                if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                    return true;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador) {
                    return true;
                }
            }
            if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
                return true;
            }
            if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
                return true;
            }
            return false;
        }

        public static boolean verificarEmpate(char[][] tabuleiro) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tabuleiro[i][j] == '-') {
                        return false;
                    }
                }
            }
            return true;
        }
    }


