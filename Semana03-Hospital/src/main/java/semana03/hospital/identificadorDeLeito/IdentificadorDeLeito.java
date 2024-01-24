package semana03.hospital.identificadorDeLeito;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "identificador_de_leito")
public class IdentificadorDeLeito {
    @Column(name = "pessoa_id")
    private Integer pessoaId;

    @Column(name = "codigo")
    private Integer codigo;

}
