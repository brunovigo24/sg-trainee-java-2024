package Aula02;

import java.util.Scanner;

public class Leitor {
        public static int lerInteiro(String mensagem) {

            boolean valido = false;
            while (!valido) {
                try {
                    System.out.println(mensagem);
                    Scanner scanner = new Scanner(System.in);
                    int inteiro = Integer.parseInt(scanner.nextLine());
                    valido = true;
                    scanner.close(); // Close the Scanner
                    return inteiro;
                } catch (Exception e) {
                    System.out.println("Por favor, digite um número válido:");
                }
            }
            return 0;
        }
}


