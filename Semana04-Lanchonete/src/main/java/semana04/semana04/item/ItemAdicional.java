package semana04.semana04.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

@NoArgsConstructor
@Getter
@Setter

public class ItemAdicional extends EntityId {
    private Integer adicionalId;
    private Integer produtoFabricadoId;
    private int quantidade;
}
