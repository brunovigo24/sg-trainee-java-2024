package com.prova03.prova03.veiculo;

import com.prova03.prova03.servico.GerarIdentificadoresDeServicoDTO;
import com.prova03.prova03.servico.Servico;
import com.prova03.prova03.servico.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class VeiculoAPI {

    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoAPI(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(this.veiculoService.salvar(veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarServico(@PathVariable Integer id) {
        this.veiculoService.deletarVeiculo(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/filtrando-por-modelo")
    public ResponseEntity getPorModelo(@RequestParam(name = "nome") Integer id, String modelo, String marca, Integer clienteId, String nomeCliente) {
        return ResponseEntity.ok(this.veiculoService.getPorModelo(id, modelo, marca, clienteId, nomeCliente ));
    }

    @PostMapping("/gerar-identificadores-de-veiculo")
    public ResponseEntity gerarIdentificadores(@RequestBody GerarIdentificadoresDoVeiculoDTO dto) {
        return ResponseEntity.ok(this.veiculoService.gerarIdentificadoresDeVeiculo(dto));
    }

}