
package com.semanadois.semanadois.cinema.sessao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessao")
public class SessaoControlador {
    private final SessaoService sessaoService;

    @Autowired
    public SessaoControlador(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @PostMapping("")
    public ResponseEntity<Sessao> cadastrar(@RequestBody Sessao sessao) {
        return ResponseEntity.ok(this.sessaoService.cadastrar(sessao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sessao> atualizar(@RequestBody Sessao sessao) {
        return ResponseEntity.ok(this.sessaoService.cadastrar(sessao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sessao> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.sessaoService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.sessaoService.deletarSessao(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Sessao>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.sessaoService.findByNome(nome));
    }
}
