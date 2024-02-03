package semana04.semana04.ingrediente;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;
import semana04.semana04.produto.Produto;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ingrediente")
public class Ingrediente extends EntityId {

        //
        @ManyToOne
        @JoinColumn(name = "produto_id", nullable = false)
        private Produto produto;

        private Integer quantidade;

}
