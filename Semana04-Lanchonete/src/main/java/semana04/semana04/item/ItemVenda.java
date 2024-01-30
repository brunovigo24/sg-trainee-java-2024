package semana04.semana04.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class ItemVenda extends EntityId {

    private Long vendaId;
    private Long produtoId;
    private Integer quantidade;
    private BigDecimal valor;

}
