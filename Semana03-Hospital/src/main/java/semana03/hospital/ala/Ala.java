package semana03.hospital.ala;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.SqlTypes;
import semana03.hospital.Entity.EntityId;
import semana03.hospital.quarto.Quarto;




import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ala")
public class Ala extends EntityId {


    @JoinColumn(name = "ala_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quarto> quartos;

    @Column(name = "especialidade")
    private String especialidade;
    private String nome;

}
