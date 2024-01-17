
package com.semanadois.semanadois.cinema.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaControlador {
    private final PessoaService pessoaService;

    @Autowired
    public PessoaControlador(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("")
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(this.pessoaService.cadastrar(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(this.pessoaService.cadastrar(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.pessoaService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.pessoaService.deletarPessoa(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Pessoa>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.pessoaService.findByNome(nome));
    }
}
