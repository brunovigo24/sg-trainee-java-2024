package semana03.hospital.leito;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana03.hospital.Entity.EntityId;
import semana03.hospital.quarto.StatusQuarto;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "leito")
public class Leito extends EntityId {

    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "status")
    private StatusLeito status;
    @Column(name = "status_string")
    private StatusLeito statusString;


    @Column(name = "quarto_id")
    private Integer quartoId;

    @Column(name = "paciente_id")
    private Integer pacienteId;

}
