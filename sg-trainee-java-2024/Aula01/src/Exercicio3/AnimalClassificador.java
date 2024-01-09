package Exercicio3;

import java.util.Arrays;
import java.util.Scanner;

public class AnimalClassificador {

    private static final String[] TIPOS = {"vertebrado", "invertebrado"};
    private static final String[] SUBTIPOS = {"ave", "mamífero", "inseto", "anelídeo"};
    private static final String[] NOMES = {"águia", "pomba", "lagarta", "sanguessuga"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o tipo do animal vertebrado ou invertebrado: ");
        String tipo = scanner.nextLine();

        System.out.println("Informe o subtipo do animal ave, mamífero, inseto, anelídeo: ");
        String subtipo = scanner.nextLine();

        System.out.println("Informe o nome do animal águia, pomba, lagarta, sanguessuga: ");
        String nome = scanner.nextLine();

        String animal = getAnimal(tipo, subtipo);

        System.out.println("O animal classificado é: " + animal + " " + nome);
    }

    private static String getAnimal(String tipo, String subtipo) {
        if (!Arrays.asList(TIPOS).contains(tipo)) {
            return null;
        }

        if (!Arrays.asList(SUBTIPOS).contains(tipo)) {
            return null;
        }

        return TIPOS[Arrays.asList(TIPOS).indexOf(tipo)] + "-" + SUBTIPOS[Arrays.asList(SUBTIPOS).indexOf(subtipo)];
    }
}
