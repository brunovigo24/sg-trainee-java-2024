
package com.semanadois.semanadois.cinema.assentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
@RestController
@RequestMapping("/filme")
public class AssentosControlador {
    private final AssentoService assentoService;

    @Autowired
    public AssentosControlador(AssentoService assentoService) {
        this.assentoService = assentoService;
    }

    @PostMapping("")
    public ResponseEntity<Assentos> cadastrar(@RequestBody Assentos assentos) {
        return ResponseEntity.ok(this.assentoService.cadastrar(assentos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assentos> atualizar(@RequestBody Assentos assentos) {
        return ResponseEntity.ok(this.assentoService.cadastrar(assentos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assentos> pegarPorId(@PathVariable int numassento) {
        return ResponseEntity.ok(this.assentoService.pegarPorId(numassento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAssentos(@PathVariable int numassento) {
        this.assentoService.deletarAssentos(numassento);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Assentos>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.assentoService.findByNome(nome));
    }
}*/
