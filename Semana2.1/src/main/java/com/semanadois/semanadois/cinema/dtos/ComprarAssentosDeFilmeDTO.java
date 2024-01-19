package com.semanadois.semanadois.cinema.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ComprarAssentosDeFilmeDTO {

    private Integer sessaoId;
    private List<Integer> numeroAssento;

}
