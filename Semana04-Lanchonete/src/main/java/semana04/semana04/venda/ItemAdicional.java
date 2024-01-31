package semana04.semana04.venda;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class ItemAdicional extends EntityId {
    private Integer adicionalId;
    private Integer produtoFabricadoId;
    private int quantidade;
    private BigDecimal valor;
}
