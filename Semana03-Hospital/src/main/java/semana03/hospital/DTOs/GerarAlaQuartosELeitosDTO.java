package semana03.hospital.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GerarAlaQuartosELeitosDTO {


    private Integer hospitalId;
    private List<String> especialidade;
    private Integer numeroDeAlas;
    private Integer quantidadeDeQuartos;
    private Integer quantidadeLeitosPorQuarto;

}
