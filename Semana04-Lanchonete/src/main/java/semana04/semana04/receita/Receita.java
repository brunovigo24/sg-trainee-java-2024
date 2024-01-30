package semana04.semana04.receita;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;
import semana04.semana04.item.ItemReceita;
import semana04.semana04.produto.ProdutoFabricado;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "receita")
public class Receita extends EntityId {

    @OneToMany(mappedBy = "receita")
    private List<ItemReceita> ingredientes;

    //Fazer no API e service
    public void verificarDisponibilidadeIngrediente() {
        // Implemente a lógica conforme necessário
    }

    public ProdutoFabricado produzir() {
        // Implemente a lógica conforme necessário
        return new ProdutoFabricado(this);
    }
}
