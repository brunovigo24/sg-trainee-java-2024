package semana04.semana04.ingrediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semana04.semana04.produto.Produto;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    @Autowired
    public  IngredienteService (IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public boolean verificarDisponibilidadeIngrediente(Integer ingredienteId, Integer quantidade) {
        Ingrediente ingrediente = ingredienteRepository.findById(Long.valueOf(ingredienteId))
                .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));

        return ingrediente.getQuantidade() >= quantidade;
    }

    public void darEntradaEstoque(Integer ingredienteId, int quantidade) {
        Ingrediente ingrediente = ingredienteRepository.findById(Long.valueOf(ingredienteId))
                .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));
        ingrediente.setQuantidade(ingrediente.getQuantidade() + quantidade);
        ingredienteRepository.save(ingrediente);
    }
}
