package com.prova03.prova03.peca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peca")
public class PecaAPI {

    private final PecaService pecaService;

    @Autowired
    public PecaAPI(PecaService pecaService) {
        this.pecaService = pecaService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Peca peca) {
        return ResponseEntity.ok(this.pecaService.salvar(peca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPeca(@PathVariable Integer id) {
        this.pecaService.deletarPeca(id);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/gerar-identificadores-de-peca")
    public ResponseEntity gerarIdentificadores(@RequestBody GerarIdentificadoresDePecaDTO dto) {
        return ResponseEntity.ok(this.pecaService.gerarIdentificadoresDePeca(dto));
    }

    @GetMapping("/ordem-alfabetica-por-nome")
    public ResponseEntity getPorOrdemAlfabetica(@RequestParam(name = "nome") Integer id, String nome, int quantidadeDeEstoque, int precoUnitario) {
        return ResponseEntity.ok(this.pecaService.getPorOrdemAlfabeticaPorNome(id, nome, quantidadeDeEstoque, precoUnitario));
    }

}
