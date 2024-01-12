package Aula02;

import java.util.ArrayList;
import java.util.Scanner;


public class GestaoProduto {

    static ArrayList<Produto> produtos = new ArrayList<>();

    static void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do produto:");
        String nome = scanner.next();

        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();

        System.out.println("Digite a quantidade em estoque:");
        int estoque = scanner.nextInt();

        System.out.println("O produto está ativo? (1 - sim, 0 - não)");
        int ativoouinativo = scanner.nextInt();

        SituacaoDeProduto situacaoDeProduto = SituacaoDeProduto.valueOf(ativoouinativo == 1 ? "ATIVO" : "INATIVO");

        Integer id = produtos.size()+1;
        produtos.add(new Produto(id, nome, preco, estoque, situacaoDeProduto));
        scanner.nextLine();

        System.out.println("Produto cadastrado com sucesso!");

        /*SituacaoDeProduto situacaoDeProduto = null;
        if (ativoouinativo == 1 ){
            situacaoDeProduto = SituacaoDeProduto.ATIVO;
        } else {
            situacaoDeProduto = SituacaoDeProduto.INATIVO;
        }*/

        //SituacaoDeProduto situacaoDeProduto = SituacaoDeProduto.valueOf(scanner.nextLine());

        //SituacaoDeProduto situacaoDeProduto = ativoouinativo == 1 ? SituacaoDeProduto.ATIVO : SituacaoDeProduto.INATIVO ;

    }

    /* private static void ativarDesativarProduto() {
         Scanner scanner = new Scanner(System.in);

 // Parei aqui
         System.out.println("Digite o código do produto:");
         int codigo = scanner.nextInt();

        Produto produto = buscarProdutoPorCodigo(codigo);

         if (produto == null) {
             System.out.println("Produto não encontrado.");
         } else {
             SituacaoDeProduto status = SituacaoDeProduto.ATIVO;
             System.out.println(status.getLabel());

             System.out.println("Produto " + (produto.isAtivo() ? "ativado" : "desativado") + " com sucesso!");
         }
     }*/
    static void ativarDesativarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto:");
        int codigo = scanner.nextInt();

        Produto produto = buscarProdutoPorCodigo(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            SituacaoDeProduto statusAtual = produto.getStatus();
            produto.setStatus(statusAtual == SituacaoDeProduto.ATIVO ? SituacaoDeProduto.INATIVO : SituacaoDeProduto.ATIVO);

            System.out.println("Produto " + produto.getStatus().getLabel() + " com sucesso!");
        }
    }

    static void adicionarEstoque() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto:");
        int codigo = scanner.nextInt();

        Produto produto = buscarProdutoPorCodigo(codigo);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Digite a quantidade a ser adicionada:");
            int estoque = scanner.nextInt();

            produto.setEstoque(produto.getEstoque() + estoque);

            System.out.println("Quantidade adicionada com sucesso!");
        }
    }

    static void retirarEstoque() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto:");
        int id = scanner.nextInt();

        Produto produto = buscarProdutoPorCodigo(id);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Digite o estoque a ser retirada:");
        }
    }


    //
    static void removerProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do produto:");
        int id = scanner.nextInt();

        Produto produto = buscarProdutoPorCodigo(id);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Produto removido com sucesso.");
        }

    }

    private static Produto buscarProdutoPorCodigo(Integer id){
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)){
                return produto;
            }
        }
        return null;
    }

    public Produto escolherProduto() {
        int codigoDoProdutoEscolhido = Leitor.lerInteiro("Escolha um produto: ");
        Produto produto = this.produtos
                .stream()
                .filter(p -> p.getId() == codigoDoProdutoEscolhido)
                .findFirst()
                .orElse(null);
        return produto;
    }

    public void alertarProdutoNaoEncontrado() {
        System.out.println("Produto não encontrado.");

    }
}
