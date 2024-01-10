package Aula02;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Mercado {

    private static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Visualizar produtos");
            System.out.println("2 - Cadastrar produto");
            System.out.println("3 - Ativar/desativar produto");
            System.out.println("4 - Adicionar estoque");
            System.out.println("5 - Retirar estoque");
            System.out.println("6 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    visualizarProdutos();
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
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 6);
    }

    private static void visualizarProdutos() {
        System.out.println("Produtos cadastrados:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private static void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do produto:");
        String nome = scanner.next();

        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();

        System.out.println("Digite a quantidade em estoque:");
        int quantidade = scanner.nextInt();

        System.out.println("O produto está ativo? (1 - sim, 0 - não)");
        int ativoouinativo = scanner.nextInt();

        SituacaoDeProduto situacaoDeProduto = null;
        if (ativoouinativo == 1 ){
            situacaoDeProduto = SituacaoDeProduto.ATIVO;
        } else {
            situacaoDeProduto = SituacaoDeProduto.INATIVO;
        }

        //SituacaoDeProduto situacaoDeProduto = SituacaoDeProduto.valueOf(scanner.nextLine());

        //SituacaoDeProduto situacaoDeProduto = SituacaoDeProduto.valueOf(ativoouinativo == 1 ? "ATIVO" : "INATIVO");

        //SituacaoDeProduto situacaoDeProduto = ativoouinativo == 1 ? SituacaoDeProduto.ATIVO : SituacaoDeProduto.INATIVO ;


        produtos.add(new Produto(nome, preco, quantidade, situacaoDeProduto);
        scanner.nextLine();


        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void ativarDesativarProduto() {
        Scanner scanner = new Scanner(System.in);

// Parei aqui
        System.out.println("Digite o código do produto:");
        int codigo = scanner.nextInt();

       Produto produto = buscarProdutoPorCodigo(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            SituacaoDeProduto.ATIVO : SituacaoDeProduto.INATIVO ;

            System.out.println("Produto " + (produto.isAtivo() ? "ativado" : "desativado") + " com sucesso!");
        }
    }

    private static void adicionarEstoque() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto:");
        int codigo = scanner.nextInt();

        Produto produto = buscarProdutoPorCodigo(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Digite a quantidade a ser adicionada:");
            int quantidade = scanner.nextInt();

            produto.setQuantidade(produto.getQuantidade() + quantidade);

            System.out.println("Quantidade adicionada com sucesso!");
        }
    }

    private static void retirarEstoque() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto:");
        int codigo = scanner.nextInt();

        Produto produto = buscarProdutoPorCodigo(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Digite a quantidade a ser retirada:");
        }
    }
}