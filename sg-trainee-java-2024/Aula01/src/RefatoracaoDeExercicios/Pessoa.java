package RefatoracaoDeExercicios;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

@Data
@NoArgsConstructor
public class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Array de pessoas
        Pessoa[] pessoas = new Pessoa[5];

        for (int i = 0; i < pessoas.length; i++) {
            System.out.println("Digite o nome da pessoa " + (i + 1) + ":");
            String nome = scanner.nextLine();

            System.out.println("Digite a idade da pessoa " + (i + 1) + ":");
            int idade = scanner.nextInt();

            scanner.nextLine();

            Pessoa pessoa = new Pessoa(nome, idade);

            pessoas[i] = pessoa;
        }

        Arrays.sort(pessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa pessoa1, Pessoa pessoa2) {
                return pessoa1.getIdade() - pessoa2.getIdade();
            }
        });

        for (Pessoa pessoa : pessoas) {
            System.out.println("Nome: " + pessoa.getNome() + " | Idade: " + pessoa.getIdade());
        }
    }
}
