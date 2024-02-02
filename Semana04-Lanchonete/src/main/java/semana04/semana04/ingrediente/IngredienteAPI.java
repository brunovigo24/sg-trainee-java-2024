package semana04.semana04.ingrediente;

import org.springframework.beans.factory.annotation.Autowired;
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

}
