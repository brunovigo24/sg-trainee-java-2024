package semana04.semana04.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoAPI {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoAPI ( ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }


    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Integer id) {
        return produtoService.getProdutoById(id);
    }
    //http://localhost:8080/produto/entrada-estoque/1?quantidade=5

    @PostMapping("")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }
    //http://localhost:8080/produto
    //{
    //	"nome": "Bolacha",
    //	"precoCusto": 3.00,
    //	"precoVenda": 6.00,
    //	"tipo": "PRODUTO_FINAL",
    //	"formato": "UNIDADE"
    //}

    @PutMapping("entrada-estoque/{id}")
    public void darEntradaEstoque(@PathVariable("id") Integer id, @RequestParam("quantidade") int quantidade) {
        produtoService.darEntradaEstoque(id, quantidade);
    }

}
