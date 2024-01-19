package com.semanadois.semanadois.cinema.dtos;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GerarSessoesAssentosDTO {
    Integer filmeId;
    Integer numeroSessao;
    Integer numeroAssento;

}
