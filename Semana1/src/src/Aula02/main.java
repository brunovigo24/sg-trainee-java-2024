package Aula02;


import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

import static Aula02.ListagemDeProdutos.menuProdutos;


public class main extends GestaoProduto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao = 9;


        while (opcao != 7) {
            try {
                System.out.println("\nEscolha uma opção: " +
                        "\n 1 - Visualizar produtos " +
                        "\n 2 - Adicionar produto " +
                        "\n 3 - Alterar situação do produto " +
                        "\n 4 - Adicionar estoque ao produto " +
                        "\n 5 - Retirar estoque do produto " +
                        "\n 6 - Remover produto " +
                        "\n 7 - Sair do programa \n");

                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        if (produtos.isEmpty()) {
                            System.out.println("Produto não cadastrado.");
                            break;
                        }
                        menuProdutos(produtos, scanner);
                        break;
                    case 2:
                        cadastrarProduto();
                        break;
                    case 3:
                        ativarDesativarProduto();
                        break;
                    case 4:
                        adicionarEstoque();
                        break;
                    case 5:
                        retirarEstoque();
                        break;
                    case 6:
                        removerProduto();
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        break;

                    default:

                        if (opcao < 1 || opcao > 6) {
                            System.out.println("Opção inválida.");
                            break;
                        }
                }

            } catch (Exception e) {
                System.out.println("Algo deu errado");

            }
        }
    }
}

