package adivinharnumeros;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class JogoDeAdivinharNum {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        boolean jogarNovamente = true;

        System.out.println("Jogo de adivinhar números");

        while (jogarNovamente) {
            int intervaloMinimo = 1;
            int intervaloMaximo = 100;

            try {
                System.out.println("Digite o intervalo de números que deseja adivinhar.");
                System.out.println("Digite o valor mínimo do intervalo");
                intervaloMinimo = sc.nextInt();
                System.out.println("Digite o valor máximo do intervalo");
                intervaloMaximo = sc.nextInt();


                if (intervaloMinimo >= intervaloMaximo) {
                    System.out.println("Intervalo inválido, o valor minimo do intervalo precisa ser menor que o valor máximo.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida!");
                sc.next();
                continue;
            }

            int aleatorio = random.nextInt(intervaloMaximo - intervaloMinimo + 1) + intervaloMinimo;
            int  tentativas = 0;
            boolean acertou = false;

            System.out.println("Agora tente adivinhar um número entre " + intervaloMinimo + " e "  + intervaloMaximo);
            System.out.println("Para sair do jogo digite 1");

            while (!acertou) {
                System.out.println("Digite sua adivinhação");
                int palpite;

                try {
                    palpite = sc.nextInt();
                } catch (InputMismatchException exception) {
                    System.out.println("Invalido");
                    continue;
                }
                if (palpite == 1) {
                    System.out.println("Saindo do jogo!!");
                    break;
                }
                tentativas++;

                if (palpite < aleatorio) {
                    System.out.println("Numero maior que " + palpite + " tente outro palpite");
                } else if (palpite > aleatorio) {
                    System.out.println("Numero menor que " + palpite + " tente outro palpite");
                } else {
                    System.out.println("Você acertou");
                    acertou = true;
                }

            }
            System.out.print("Deseja jogar novamente? (1)Sim e (2)Não): ");
            char resposta = sc.next().charAt(0);
            jogarNovamente = (resposta == '1' || resposta == '1');
        }

        System.out.println("Bye, Bye");
        sc.close();
    }

}

