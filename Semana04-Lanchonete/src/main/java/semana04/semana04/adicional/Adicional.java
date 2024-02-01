package semana04.semana04.adicional;

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
public class Adicional extends EntityId {

    //Validar se o produto existe
    private Integer produtoId;

    private BigDecimal preco;
}
