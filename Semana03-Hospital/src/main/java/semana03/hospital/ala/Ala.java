package semana03.hospital.ala;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana03.hospital.Entity.EntityId;
import semana03.hospital.leito.Leito;
import semana03.hospital.quarto.Quarto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ala")
public class Ala extends EntityId {

    private List<Quarto> quartos = new ArrayList<>();

    @Column(name = "especialidade")
    private String especialidade;

    private String nome;

    @Column(name = "hospital_id")
    private Integer hospitalId;
}
