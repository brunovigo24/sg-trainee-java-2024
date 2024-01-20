package prova02.biblioteca.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import prova02.biblioteca.livro.LivroService;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AlugarLivrosDTO {

    private Integer livroId;
 private Integer numeroaluguel;


}
