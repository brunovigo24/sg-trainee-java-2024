package semana04.semana04.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return produtoRepository.save(produto);
    }

    public void validarProduto(Produto produto) {
        if (Objects.isNull(produto.getTipo()))
            throw new RuntimeException("Produto sem tipo");
        if (Objects.isNull(produto.getFormato()))
            throw new RuntimeException("Produto sem formato");
    }


    public void darEntradaEstoque(Integer idProduto, int quantidade) {
        Produto produto = produtoRepository.findById(idProduto).orElse(null);
        if (produto != null) {
            produto.setQuantidade(produto.getQuantidade() + quantidade);
            produtoRepository.save(produto);
        }
    }
}