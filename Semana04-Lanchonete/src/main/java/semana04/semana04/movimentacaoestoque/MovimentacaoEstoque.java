package semana04.semana04.movimentacaoestoque;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

@Getter
@Setter
@NoArgsConstructor
public class MovimentacaoEstoque extends EntityId {

    private Integer produtoId;

    private TipoMovimentacao tipoMovimentacao;
}
