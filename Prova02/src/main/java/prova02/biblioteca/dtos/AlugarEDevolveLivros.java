package prova02.biblioteca.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AlugarEDevolveLivros {

    private Integer livroId;
    private List<Integer> numeros;




}
