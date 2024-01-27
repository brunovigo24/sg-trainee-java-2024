package com.prova03.prova03.servico;


import com.prova03.prova03.peca.GerarIdentificadoresDePecaDTO;
import com.prova03.prova03.peca.Peca;
import com.prova03.prova03.peca.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class ServicoAPI {

    private final ServicoService servicoService;

    @Autowired
    public ServicoAPI(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Servico servico) {
        return ResponseEntity.ok(this.servicoService.salvar(servico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarServico(@PathVariable Integer id) {
        this.servicoService.deletarServico(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/ordem-alfabetica-por-nome")
    public ResponseEntity getPorOrdemAlfabetica(@RequestParam(name = "nome") Integer id, String nome, int precoDaMaoDeObra) {
        return ResponseEntity.ok(this.servicoService.getPorOrdemAlfabeticaPorNome(id, nome, precoDaMaoDeObra ));
    }

    @PostMapping("/gerar-identificadores-de-servico")
    public ResponseEntity gerarIdentificadores(@RequestBody GerarIdentificadoresDeServicoDTO dto) {
        return ResponseEntity.ok(this.servicoService.gerarIdentificadoresDeServico(dto));
    }

}
