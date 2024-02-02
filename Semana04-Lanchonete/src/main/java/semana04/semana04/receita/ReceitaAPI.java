package semana04.semana04.receita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import semana04.semana04.produto.ProdutoFabricado;

@RestController
@RequestMapping("/receita")

public class ReceitaAPI {

    private final ReceitaService receitaService;

    @Autowired
    public ReceitaAPI ( ReceitaService receitaService ) {
        this.receitaService = receitaService;
    }

    @GetMapping("/verificar-disponibilidade/{receitaId}")
    public String verificarDisponibilidadeIngrediente(@PathVariable Integer receitaId) {
        try {
            receitaService.verificarDisponibilidadeIngrediente(receitaId);
            return "Ingredientes disponíveis para a receita.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    @PostMapping("/produzir/{receitaId}")
    public String produzir(@PathVariable Integer receitaId) {
        try {
            ProdutoFabricado produtoFabricado = receitaService.produzir(receitaId);
            return "Produto fabricado com sucesso: " + produtoFabricado.getNome();
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
