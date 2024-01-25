package semana03.hospital.hospital;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana03.hospital.Entity.EntityId;
import semana03.hospital.ala.Ala;
import semana03.hospital.leito.Leito;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "hospital")
public class Hospital extends EntityId {

    private List<Ala> alas = new ArrayList<>();

    @Column(name = "nome")
    private String nome;

    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hospital_id")*/

}
