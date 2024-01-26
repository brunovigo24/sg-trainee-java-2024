package semana03.hospital.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana03.hospital.leito.LeitoProjection;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeitoProjectionDTO {
    private Integer id;
    private String codigo;

    public LeitoProjectionDTO(LeitoProjection leitoProjection) {
        this.id = leitoProjection.getId();
        this.codigo = leitoProjection.getCodigoLeito();
    }
}
