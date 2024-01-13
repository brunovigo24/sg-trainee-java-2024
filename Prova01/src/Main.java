import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends GestaoDeLivros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 9;


        while (opcao != 7) {
            try {
                System.out.println("\nEscolha uma opção: " +
                        "\n 1 - Visualizar livros " +
                        "\n 2 - Adicionar livro " +
                        "\n 3 - Alterar situação do livro " +
                        "\n 4 - Adicionar estoque ao livro " +
                        "\n 5 - Retirar estoque do livro " +
                        "\n 6 - Remover livro " +
                        "\n 7 - Sair do programa \n");

                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        if (livros.isEmpty()) {
                            System.out.println("Livro não cadastrado.");
                            break;
                        }
                        menuLivros();
                        break;
                    case 2:
                        cadastrarLivro();
                        break;
                    case 3:
                        ativarDesativarLivro();
                        break;
                    case 4:
                        adicionarEstoque();
                        break;
                    case 5:
                        retirarEstoque();
                        break;
                    case 6:
                        removerLivro();
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
