package com.prova03.prova03.veiculo;

import com.prova03.prova03.identificadores.IdentificadorDeServico;
import com.prova03.prova03.identificadores.IdentificadorDeVeiculo;
import com.prova03.prova03.servico.GerarIdentificadoresDeServicoDTO;
import com.prova03.prova03.servico.Servico;
import com.prova03.prova03.servico.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Transactional(readOnly = true)
    public Veiculo pegarPorId(Integer id) {
        return this.veiculoRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Veiculo salvar(Veiculo veiculo) {
        if (Objects.isNull(veiculo.getModelo()) || veiculo.getModelo().isEmpty()) {
            throw new RuntimeException("Servico sem nome");
        }
        return this.veiculoRepository.save(veiculo);
    }

    @Transactional
    public void deletarVeiculo(Integer veiculoId) {
        this.pegarPorId(veiculoId);
    }

    @Transactional(readOnly = true)
    public List<Veiculo> getPorModelo(Integer id, String modelo, String marca, Integer clienteId, String nomeCliente) {
        List<Veiculo> veiculos = this.veiculoRepository.findAll();
        veiculos.sort(Comparator.comparing(Veiculo::getModelo));
        return this.veiculoRepository.getByNomeContainsIgnoreCase("%" + id + "%" + modelo + "%" + marca + "%" + clienteId + "%" + nomeCliente);
    }

    @Transactional
    public Veiculo gerarIdentificadoresDeVeiculo(GerarIdentificadoresDoVeiculoDTO dto) {
        Veiculo veiculo = this.pegarPorId(dto.getVeiculoId());
        if (Objects.isNull(veiculo.getIdentificadorDeVeiculos())) {
            veiculo.setIdentificadorDeVeiculos(new ArrayList<>());
        }
        for (int i = 1; i <= dto.getQuantidadeTotal(); i++) {
            veiculo.getIdentificadorDeVeiculos()
                    .add(new IdentificadorDeVeiculo(i + veiculo.getId()));
        }
        veiculo.setId(veiculo.getId() + dto.getQuantidadeTotal());
        return this.veiculoRepository.save(veiculo);
    }
}