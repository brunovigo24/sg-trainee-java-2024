package semana03.hospital.paciente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana03.hospital.Entity.EntityId;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "paciente")
public class Paciente extends EntityId {

    @Column(name = "nome")
    private String nome;

}
