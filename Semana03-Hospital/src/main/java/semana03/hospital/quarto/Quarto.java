package semana03.hospital.quarto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana03.hospital.Entity.EntityId;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "quarto")
public class Quarto extends EntityId {

    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "status")
    private StatusQuarto status;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_string")
    private StatusQuarto statusString;

    @Column(name = "ala_id")
    private Integer alaId;



}
