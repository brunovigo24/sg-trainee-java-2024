
package com.semanadois.semanadois.cinema.assentos;

import com.semanadois.semanadois.cinema.dtos.ComprarAssentosDeFilmeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assento")
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
    public ResponseEntity<Assentos> pegarPorId(@PathVariable Integer numassento) {
        return ResponseEntity.ok(this.assentoService.pegarPorId(numassento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAssentos(@PathVariable Integer numassento) {
        this.assentoService.deletarAssento(numassento);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Assentos>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.assentoService.findByNome(nome));
    }

    @PostMapping("/comprar-ingresso/{filmeId}")
    public ResponseEntity comprarIngressos(@PathVariable Integer filmeId,
                                          @RequestParam(name = "pessoaId") Integer pessoaId,
                                           @RequestBody ComprarAssentosDeFilmeDTO comprarIngressoFilmeDTO) {
        return ResponseEntity.ok(
                this.assentoService.comprarAssentos(
                        filmeId,
                        pessoaId,
                        comprarIngressoFilmeDTO
                )
        );
    }
}
