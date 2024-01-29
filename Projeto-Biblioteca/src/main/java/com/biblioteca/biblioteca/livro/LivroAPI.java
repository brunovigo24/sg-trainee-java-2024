package com.biblioteca.biblioteca.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroAPI {
    private final LivroService livroService;

    @Autowired
    public LivroAPI(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Livro livro) {
        return ResponseEntity.ok(this.livroService.salvar(livro));
    }

    @GetMapping("/ordem-alfabetica")
    public ResponseEntity getPorOrdemAlfabetica() {
        return ResponseEntity.ok(this.livroService.getPorOrdemAlfabetica());
    }

    @GetMapping("/por-nome")
    public ResponseEntity getPorNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.livroService.getByNomeContainsIgnoreCase(nome));
    }

    @PutMapping("/alugar/{pessoaId}")
    public ResponseEntity alugarLivros(@RequestBody List<AlugaEDevolveLivros> dtos,
                                       @PathVariable Integer pessoaId) {

        this.livroService.alugaLivros(dtos, pessoaId);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/devolver")
    public ResponseEntity devolverLivros(@RequestBody List<AlugaEDevolveLivros> dtos) {

        this.livroService.devolveLivros(dtos);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarLivro(@PathVariable Integer id) {
        this.livroService.deletarLivro(id);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/gerar-identificadores")
    public ResponseEntity gerarIdentificadores(@RequestBody GerarIdentificadoresDTO dto) {
        return ResponseEntity.ok(this.livroService.gerarIdentificadoresDeLivros(dto));
    }
}
