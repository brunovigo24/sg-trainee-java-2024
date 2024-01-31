package semana04.semana04.produto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.venda.ItemAdicional;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ProdutoFabricado extends Produto {
    private Integer receitaId;
    private List<ItemAdicional> adicionais;
}
