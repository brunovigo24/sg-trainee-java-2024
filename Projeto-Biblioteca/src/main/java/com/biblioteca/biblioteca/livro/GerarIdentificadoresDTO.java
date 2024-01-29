package com.biblioteca.biblioteca.livro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GerarIdentificadoresDTO {
    private Integer livroId;
    private int quantidadeTotal;
}
