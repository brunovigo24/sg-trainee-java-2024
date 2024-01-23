
package prova02.biblioteca.livro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova02.biblioteca.dtos.AlugarEDevolveLivros;
import prova02.biblioteca.dtos.IdentificadorDeLivroDTO;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/livro")
public class LivroControlador {
    private final LivroService livroService;

    @Autowired
    public LivroControlador(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        return ResponseEntity.ok(this.livroService.cadastrar(livro));
    }


    public void validarLivro(Livro livro) {
        if (Objects.isNull(livro.getNome())
            || livro.getNome().isEmpty()) {
            throw new RuntimeException("Livro sem situacao");
        }

        if (livro.getQuantidadeAlugada() != 0) {
            throw new RuntimeException("Livro com quantidade total alugada invalída");
        }
    }

    @PutMapping("/alugar")
    public ResponseEntity alugarLivros(@RequestBody List<AlugarEDevolveLivros>)

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@RequestBody Livro livro) {
        return ResponseEntity.ok(this.livroService.cadastrar(livro));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Livro> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.livroService.pegarPorId(id));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.livroService.deletarLivro(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-ordem-alfabetica")
    public ResponseEntity<List<Livro>> porOrdemAlfabetica() {
        List<Livro> livros = this.livroRepository.findAll;
        return ResponseEntity.ok(this.livroService.porOrdemAlfabetica());

    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Livro>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.livroService.findByNome(nome));
    }
    /*@PostMapping("/gerar-aluguel")
    public ResponseEntity<Livro> gerarAluguel(@RequestBody IdentificadorDeLivroDTO dto) {
        return ResponseEntity.ok(this.livroService.gerarIdentificadorDeLivro(dto));
    }*/

}
