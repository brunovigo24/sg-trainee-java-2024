package prova02.biblioteca.aluguel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova02.biblioteca.dtos.AlugarLivrosDTO;
import prova02.biblioteca.dtos.IdentificadorDeLivroDTO;
import prova02.biblioteca.livro.Livro;
import prova02.biblioteca.livro.LivroRepository;
import prova02.biblioteca.livro.LivroService;

import java.util.List;



@RestController
@RequestMapping("alugar")
public class AlugarControlador {

    private final AlugarService alugarService;

    @Autowired
    public AlugarControlador(AlugarService alugarService) {
        this.alugarService = alugarService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<Alugar> pegarPorId(@PathVariable Integer numassento) {
        return ResponseEntity.ok(this.alugarService.pegarPorId(numassento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluguel(@PathVariable Integer numassento) {
        this.alugarService.deletarAluguel(numassento);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Alugar>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.alugarService.findByNome(nome));
    }

    @PostMapping("/alugar-livro/{livroId}")
    public ResponseEntity alugarLivro(@PathVariable Integer filmeId,
                                           @RequestParam(name = "pessoaId") Integer pessoaId,
                                           @RequestBody IdentificadorDeLivroDTO identificadorDeLivroDTO) {
        return ResponseEntity.ok(
                this.alugarService.alugarLivro(
                        filmeId,
                        pessoaId,
                        identificadorDeLivroDTO
                )
        );
    }

}
