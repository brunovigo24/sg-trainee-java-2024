package semana04.semana04.ingrediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteAPI {

    private final IngredienteService ingredienteService;

    @Autowired
    public IngredienteAPI (IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @GetMapping("/verificar-disponibilidade/{ingredienteId}")
    public String verificarDisponibilidadeIngrediente(@PathVariable Integer ingredienteId, Integer quantidade) {
        try {
            ingredienteService.verificarDisponibilidadeIngrediente(ingredienteId, quantidade);
            return "Ingrediente disponível em estoque.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @PutMapping("entrada-estoque/{id}")
    public void darEntradaEstoque(@PathVariable("id") Integer id, @RequestParam("quantidade") int quantidade) {
        ingredienteService.darEntradaEstoque(id, quantidade);
    }
    //http://localhost:8080/ingrediente/entrada-estoque/1?quantidade=5

}
