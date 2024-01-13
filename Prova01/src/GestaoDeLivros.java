import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class GestaoDeLivros extends PadraoIdInteiro {

    static ArrayList<Livro> livros = new ArrayList<>();

    static void cadastrarLivro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome o livro: ");
        String nome = scanner.next();

        System.out.println("Digite a quantidade em estoque: ");
        int estoque = scanner.nextInt();

        System.out.println("O livro está ativo ? (1 - sim, 0 - não");
        int ativoouinativo = scanner.nextInt();

        SituacaoDeLivro situacaoDeLivro = SituacaoDeLivro.valueOf(ativoouinativo == 1 ? "ATIVO" : "INATIVO");

        Date DataDeCadastro = new Date();

        Integer id = livros.size() + 1;
        livros.add(new Livro(id, nome, situacaoDeLivro, DataDeCadastro, estoque));
        scanner.nextLine();

        System.out.println("Livro cadastrado com sucesso !");
    }

    static void adicionarEstoque() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto:");
        int codigo = scanner.nextInt();

        Livro livros = buscarLivroPorCodigo(codigo);

        if (livros == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Digite a quantidade a ser adicionada:");
            int estoque = scanner.nextInt();

            livros.setEstoque(livros.getEstoque() + estoque);

            System.out.println("Quantidade adicionada com sucesso!");
        }
    }



    private static Livro buscarLivroPorCodigo(Integer id) {
        for (Livro livros : livros) {
            if (livros.getId().equals(id)) {
                return livros;
            }
        }
        return null;
    }

    private static Livro buscarLivroPorNome(String nome) {
        for (Livro livros : livros) {
            if (livros.getNome().equals(nome)) {
                return livros;
            }
        }
        return null;
    }


    static  void pesquisaLivroPorNome() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome desejado");
        String nome = scanner.nextLine();

        Livro livros = buscarLivroPorNome(nome);

        if (livros == null) {
            System.out.println("Livro não encontrado.");
        } else {
            System.out.println("Livro " + livros.getNome().equals(nome) + " encontrado com sucesso!");

        }
    }

    static void retirarEstoque() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do livro:");
        int id = scanner.nextInt();

        Livro livros = buscarLivroPorCodigo(id);

        if (livros == null) {
            System.out.println("Livro não encontrado.");
        } else {
            System.out.println("Digite o estoque a ser retirado:");
        }
    }

    static void removerLivro(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto:");
        int id = scanner.nextInt();

        Livro livros = buscarLivroPorCodigo(id);

        if (GestaoDeLivros.livros == null) {
            System.out.println("Livro não encontrado.");
        } else {
            System.out.println("Produto removido com sucesso.");
        }

    }
    static void ativarDesativarLivro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do livro: ");
        int codigo = scanner.nextInt();

        Livro livros = buscarLivroPorCodigo(codigo);

        if (livros == null) {
            System.out.println("Livro não encontrado.");
        } else {
            SituacaoDeLivro statusAtual = livros.getStatus();
            livros.setStatus(statusAtual == SituacaoDeLivro.ATIVO ? SituacaoDeLivro.INATIVO : SituacaoDeLivro.ATIVO);

            System.out.println("Livro " + livros.getStatus().getLabel() + " com sucesso!");
        }
    }
    public static void visualizarLivros() {
        System.out.println("Produtos cadastrados:");
        for (Livro livro : livros) {
            System.out.println("Código: " + livros.get(livro.id) + " |Produto " + livro.getNome() +  "| Estoque " + livro.getEstoque() + "|status " + livro.getStatus());
        }
    }

    public static void menuLivros() {
        Scanner scanner = new Scanner(System.in);

        int opcao = 2;

        while (opcao != 2) {
            try {
                System.out.println("\n Escolha uma opção de impressão: " +
                        "\n 1 - Ordem alfabética " +
                        "\n 2 - Filtrar por nome digitado ");

                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        if (livros.isEmpty()) {
                            System.out.println("Livro não cadastrado.");
                            break;
                        }
                        visualizarLivros();
                    case 2:
                        pesquisaLivroPorNome();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Algo deu errado");

            }

        }
    }
}