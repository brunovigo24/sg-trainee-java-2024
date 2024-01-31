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
public class Receita extends EntityId{


    private Integer produtoId;

    /*@OneToMany(mappedBy = "receita")
    private List<ItemReceita> ingredientes;

    //Fazer no API e service
    /*
    public void verificarDisponibilidadeIngrediente() {
        // Implementar lógica
    }

    public ProdutoFabricado produzir() {
        // Implementar lógica
        return new ProdutoFabricado(this);
    }*/

    //Validar se é um insulmo e se existe
}
