package semana04.semana04.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semana04.semana04.ingrediente.Ingrediente;
import semana04.semana04.ingrediente.IngredienteRepository;
import semana04.semana04.ingrediente.IngredienteService;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final IngredienteRepository ingredienteRepository;

    private final IngredienteService ingredienteService;
    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository,
                          IngredienteRepository ingredienteRepository,
                          IngredienteService ingredienteService) {
        this.produtoRepository = produtoRepository;
        this.ingredienteRepository = ingredienteRepository;
        this.ingredienteService = ingredienteService;
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


        //Função para caso o enum for INGREDIENTE ele ser cadastrado no Ingredinte, não no Produto.
        Produto produtoSalvo = produtoRepository.save(produto);

        if (TipoProduto.INGREDIENTE.equals(produto.getTipo())) {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setProduto(produtoSalvo);
            ingrediente.setQuantidade(0);  // Defina a quantidade inicial conforme necessário
            ingredienteRepository.save(ingrediente);
        }

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

