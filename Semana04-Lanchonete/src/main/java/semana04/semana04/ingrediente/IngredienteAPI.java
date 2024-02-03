package semana04.semana04.ingrediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
