package Exercicio1;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;


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

        Pessoa[] pessoas = new Pessoa[] {
                new Pessoa("Bruno", 20),
                new Pessoa("João", 22),
                new Pessoa("Keven", 27),
                new Pessoa("Tiago", 28),
                new Pessoa("Gustavo", 30)
        };

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
