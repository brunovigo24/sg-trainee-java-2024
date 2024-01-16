package controladores;


import entidades.Produto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositorios.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/geral/produtos")
@AllArgsConstructor
public class ProdutoAPI {

    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable int id){
        return produtoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        return ResponseEntity.ok((produtoRepository.save(produto)));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") int id,
                                          @RequestBody Produto produto) {
        return produtoRepository.findById(id)
                .map(record -> {
                    record.setNome(produto.getNome());
                    /*record.setPreco(produto.getPreco());
                    record.setDescricao(produto.getDescricao());*/
                    Produto updated = produtoRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}