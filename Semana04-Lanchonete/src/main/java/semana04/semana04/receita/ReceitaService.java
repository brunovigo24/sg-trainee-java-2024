package semana04.semana04.receita;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semana04.semana04.ingrediente.Ingrediente;
import semana04.semana04.produto.ProdutoFabricado;
import semana04.semana04.produto.ProdutoService;

import java.util.List;

@Service
public class ReceitaService {

    private final ReceitaRepository receitaRepository;
    private final ProdutoService produtoService;


    @Autowired
    public ReceitaService ( ReceitaRepository receitaRepository,
                            ProdutoService produtoService) {
        this.receitaRepository = receitaRepository;
        this.produtoService = produtoService;
    }

    public Receita criarReceita(List<Ingrediente> ingredientes) {
        Receita receita = new Receita();
        receita.setIngredientes(ingredientes);
        receitaRepository.save(receita);
        return receita;
    }

    public void verificarDisponibilidadeIngrediente(Integer receitaId) {
        Receita receita = receitaRepository.findById(receitaId)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada"));

        for (Ingrediente ingrediente : receita.getIngredientes()) {
            if (!produtoService.verificarDisponibilidadeProduto(ingrediente.getProduto().getId(), ingrediente.getQuantidade())) {
                throw new RuntimeException("Ingrediente não disponível em estoque");
            }
        }
    }

    public ProdutoFabricado produzir(Integer receitaId) {
        Receita receita = receitaRepository.findById(receitaId)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada"));

        // Verifica disponibilidade dos ingredientes antes de produzir
        verificarDisponibilidadeIngrediente(receitaId);

        // Cria e retornar um novo ProdutoFabricado com base na receita
        return new ProdutoFabricado();
    }
}
