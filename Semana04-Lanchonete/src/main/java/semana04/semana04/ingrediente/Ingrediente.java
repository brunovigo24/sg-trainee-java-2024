package semana04.semana04.ingrediente;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ingrediente")
public class Ingrediente extends EntityId {

        private Integer produtoId;
        private Integer quantidade;

        /*public boolean ehIngrediente() {
            // Implemente a lógica conforme necessário
            return true;
        }*/
}
