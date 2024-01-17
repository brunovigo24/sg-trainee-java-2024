package com.semanadois.semanadois.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoAPI {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoAPI(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("")
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        return ResponseEntity.ok(this.produtoService.cadastrar(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto) {
        return ResponseEntity.ok(this.produtoService.cadastrar(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> pegarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.produtoService.pegarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Integer id) {
        this.produtoService.deletarProduto(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<Produto>> findByNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.produtoService.findByNome(nome));
    }
}
