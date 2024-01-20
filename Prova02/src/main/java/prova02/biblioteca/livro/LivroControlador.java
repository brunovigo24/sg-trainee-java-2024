
package prova02.biblioteca.livro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova02.biblioteca.dtos.IdentificadorDeLivroDTO;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroControlador {
    private final LivroService livroService;

    @Autowired
    public LivroControlador(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro filme) {
        return ResponseEntity.ok(this.livroService.cadastrar(filme));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@RequestBody Livro filme) {
        return ResponseEntity.ok(this.livroService.cadastrar(filme));
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

    @GetMapping("/por-nome")
    public ResponseEntity<List<Livro>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.livroService.findByNome(nome));
    }
    @PostMapping("/gerar-aluguel")
    public ResponseEntity<Livro> gerarAluguel(@RequestBody IdentificadorDeLivroDTO dto) {
        return ResponseEntity.ok(this.livroService.gerarIdentificadorDeLivro(dto));
    }

}
