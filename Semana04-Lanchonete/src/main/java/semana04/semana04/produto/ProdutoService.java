package semana04.semana04.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semana04.semana04.venda.ItemVenda;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto salvarProduto(Produto produto) {
        this.validarProduto(produto);
        produto.setDataCadastro(new Date());
        return produtoRepository.save(produto);
    }

    public void validarProduto(Produto produto) {
        if (Objects.isNull(produto.getTipo()))
            throw new RuntimeException("Produto sem tipo");
        if (Objects.isNull(produto.getFormato()))
            throw new RuntimeException("Produto sem formato");
    }

    public boolean verificarDisponibilidadeProduto(Integer produtoId, Integer quantidade) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return produto.getQuantidade() >= quantidade;
    }

    public void darEntradaEstoque(Integer idProduto, int quantidade) {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Pruduto não encontrado"));
        produto.setQuantidade(produto.getQuantidade() + quantidade);
        produtoRepository.save(produto);
    }

    public void atualizarEstoqueAoFinalizarVenda(Integer produtoId, Integer quantidadeVendida) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (produto.getQuantidade() < quantidadeVendida) {
            throw new RuntimeException("Quantidade vendida maior que a disponível em estoque");
        }

        produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
        produtoRepository.save(produto);
    }
}

