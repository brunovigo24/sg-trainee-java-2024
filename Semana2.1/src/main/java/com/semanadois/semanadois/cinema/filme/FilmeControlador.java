
package com.semanadois.semanadois.cinema.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeControlador {
    private final FilmeService filmeService;

    @Autowired
    public FilmeControlador(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme) {
        return ResponseEntity.ok(this.filmeService.cadastrar(filme));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme) {
        return ResponseEntity.ok(this.filmeService.cadastrar(filme));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.filmeService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.filmeService.deletarProduto(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Filme>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.filmeService.findByNome(nome));
    }
}
