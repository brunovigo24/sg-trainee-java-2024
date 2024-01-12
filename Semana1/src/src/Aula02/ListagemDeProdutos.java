package Aula02;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListagemDeProdutos  {

    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void menuProdutos(List<Produto> produtos, Scanner scanner) {
        imprimirMenuDeListagens();

        int escolhaDoUsuario = Leitor.lerInteiro(String.valueOf(scanner));
        scanner.nextLine();

            if (escolhaDoUsuario > 0 & escolhaDoUsuario < 12){
                switch (escolhaDoUsuario) {
                    case 1:
                        visualizarProdutos(produtos);
                        break;
                    case 2: //Parei aqui

                        break;
                }

            }

    }


    public static void visualizarProdutos(List<Produto> produtos) {
        System.out.println("Produtos cadastrados:");
        for (Produto produto : produtos) {
            System.out.println("Código: " + produto.getId() + " |Produto " + produto.getNome() + "| Preço " + produto.getPreco() + "| Estoque " + produto.getEstoque() + "|status " + produto.getStatus());
        }
    }


    public static void imprimirMenuDeListagens() {
        System.out.println("\n Escolha uma opção de impressão: " +
                "\n 1 - Ordem crescente de código " +
                "\n 2 - Ordem alfabética " +
                "\n 3 - Quantidade de estoque maior " +
                "\n 4 - Quantidade de estoque menor " +
                "\n 5 - Somente ativos " +
                "\n 6 - Somente inativos" +
                "\n 7 - Somente com estoque" +
                "\n 8 - Somente sem estoque" +
                "\n 9 - Filtrando por nome " +
                "\n 10 - Ordem de data de cadastro crescente " +
                "\n 11 - Ordem de data de cadastro decrecente");
    }
}
