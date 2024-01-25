package semana03.hospital.DTOs;

import lombok.Getter;
import lombok.Setter;
import semana03.hospital.ala.Ala;

@Getter
@Setter
public abstract class GerarAlaQuartosELeitosDTO {

    private String especialidade;
    private String nome;
    private int quantidadeQuartos;
    private int quantidadeLeitosPorQuarto;


}
