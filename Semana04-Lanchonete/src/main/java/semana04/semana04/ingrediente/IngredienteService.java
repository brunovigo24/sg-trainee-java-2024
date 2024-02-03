package semana04.semana04.ingrediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public  IngredienteService (IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public boolean verificarDisponibilidadeIngrediente(Integer ingredienteId, Integer quantidade) {
        Ingrediente ingrediente = ingredienteRepository.findById(ingredienteId)
                .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));

        return ingrediente.getQuantidade() >= quantidade;
    }

}
