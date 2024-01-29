package com.biblioteca.biblioteca.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaAPI {
    private final PessoaService pessoaService;

    @Autowired
    public PessoaAPI(PessoaService pessoaService) {
        this.pessoaService =  pessoaService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(this.pessoaService.salvar(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Pessoa pessoa,
                                    @PathVariable Integer id) {
        return ResponseEntity.ok(this.pessoaService.salvar(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        this.pessoaService.deletarPessoa(id);
        return ResponseEntity.accepted().build();
    }
}
