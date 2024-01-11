package Aula02;


import java.util.Scanner;


public class main extends ListagemDeProdutos {

public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);

    int opcao = 9;


        while (opcao != 6) {
            try {
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
                        VisualizarTodosPrudutos();
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

                    if (opcao < 1 || opcao > 6) {
                        System.out.println("Opção inválida.");
                        break;

                    }
                }

            } catch (Exception e) {
                System.out.println("Algo deu errado");

            }
        }

        class Leitor {
            public static int lerInteiro(String mensagem) {

                boolean valido = false;
                while (!valido) {
                    try {
                        System.out.println(mensagem);
                        Scanner scanner = new Scanner(System.in);
                        int inteiro = Integer.parseInt(scanner.nextLine());
                        valido = true;
                        return inteiro;
                    } catch (Exception e) {
                        System.out.println("Por favor, digite um número válido:");
                    }
                }
                return 0;
            }
        }
    }
}