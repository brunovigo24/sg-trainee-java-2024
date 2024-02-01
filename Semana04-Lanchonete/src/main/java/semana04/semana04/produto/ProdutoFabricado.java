package semana04.semana04.produto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.adicional.ItemAdicional;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ProdutoFabricado extends Produto {
    private Integer receitaId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "produtofabricado_id")
    private List<ItemAdicional> adicionais = new ArrayList<>();
}
