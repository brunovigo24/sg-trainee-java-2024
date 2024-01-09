package Exercicio2;

import java.util.Random;
import java.util.Scanner;

public class Loteria {

    private static final int NUMEROS_SORTEADOS = 6;

    public static void main(String[] args) {
        int[] numerosSorteados = sortearNumeros();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seis números apostados que vão ser sorteaos de 1 até 99:");
        int[] numerosApostados = new int[NUMEROS_SORTEADOS];
        for (int i = 0; i < NUMEROS_SORTEADOS; i++) {
            numerosApostados[i] = scanner.nextInt();
        }

        int quantidadeAcertos = contarAcertos(numerosApostados, numerosSorteados);

        switch (quantidadeAcertos) {
            case 3:
                System.out.println("Você ganhou o prêmio de R$ 50,00");
                break;
            case 4:
                System.out.println("Você ganhou o prêmio de R$ 100,00");
                break;
            case 5:
                System.out.println("Você ganhou o prêmio de R$ 5.000,00");
                break;
            case 6:
                System.out.println("Você ganhou o prêmio de R$ 100.000,00");
                break;
            default:
                System.out.println("Você não acertou nenhum número :( ");
        }
    }
    private static int[] sortearNumeros() {
        Random random = new Random();
        int[] numerosSorteados = new int[NUMEROS_SORTEADOS];
        for (int i = 0; i < NUMEROS_SORTEADOS; i++) {
            numerosSorteados[i] = random.nextInt(99) + 1;
        }
        return numerosSorteados;
    }
    private static int contarAcertos(int[] numerosApostados, int[] numerosSorteados) {
        int quantidadeAcertos = 0;
        for (int numeroApostado : numerosApostados) {
            for (int numeroSorteado : numerosSorteados) {
                if (numeroApostado == numeroSorteado) {
                    quantidadeAcertos++;
                }
            }
        }
        return quantidadeAcertos;
    }
}
