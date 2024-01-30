package semana04.semana04.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "cliente")
public class Cliente extends EntityId {
    @Column(name = "nome")
    private String nome;
}
