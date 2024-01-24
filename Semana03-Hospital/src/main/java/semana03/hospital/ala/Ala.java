package semana03.hospital.ala;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana03.hospital.Entity.EntityId;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ala")
public class Ala extends EntityId {

    @Column(name = "especialidade")
    private String especialidade;

    @Column(name = "hospital_id")
    private Integer hospitalId;
}
