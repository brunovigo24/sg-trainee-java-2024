package semana03.hospital.quarto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana03.hospital.Entity.EntityId;
import semana03.hospital.leito.Leito;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "quarto")
public class Quarto extends EntityId {

    @JoinColumn(name = "quarto_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Leito> leitos;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "status")
    private StatusQuarto status;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_string")
    private StatusQuarto statusString;




}
