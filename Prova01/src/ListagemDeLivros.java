import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListagemDeLivros extends GestaoDeLivros {

    public static void menuLivros(List<Livro> livros, Scanner scanner) {


        int opcao = 2;

        while (opcao != 2) {
            imprimirMenuDeListagens();
            switch (opcao) {
                case 1:
                    if (livros.isEmpty()) {
                        System.out.println("Livro não cadastrado.");
                        break;
                    } visualizarLivros();
                case 2:
                    pesquisaLivroPorNome();
                    break;
            }
        }

    }

    private static void imprimirMenuDeListagens() {
        System.out.println("\n Escolha uma opção de impressão: " +
                "\n 1 - Ordem alfabética " +
                "\n 2 - Filtrar por nome digitado ");

    }
}
