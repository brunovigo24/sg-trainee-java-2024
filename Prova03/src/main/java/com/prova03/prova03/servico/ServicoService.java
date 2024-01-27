package com.prova03.prova03.servico;

import com.prova03.prova03.identificadores.IdentificadorDePeca;
import com.prova03.prova03.identificadores.IdentificadorDeServico;
import com.prova03.prova03.peca.GerarIdentificadoresDePecaDTO;
import com.prova03.prova03.peca.Peca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @Transactional(readOnly = true)
    public Servico pegarPorId(Integer id) {
        return this.servicoRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Servico salvar(Servico servico) {
        if (Objects.isNull(servico.getNome()) || servico.getNome().isEmpty()) {
            throw new RuntimeException("Servico sem nome");
        }
        return this.servicoRepository.save(servico);
    }

    @Transactional
    public void deletarServico(Integer servicoId) {
        this.pegarPorId(servicoId);
    }

    @Transactional(readOnly = true)
    public List<Servico> getPorOrdemAlfabeticaPorNome(Integer id, String nome, int precoDaMaoDeObra) {
        List<Servico> servicos = this.servicoRepository.findAll();
        servicos.sort(Comparator.comparing(Servico::getNome));
        return this.servicoRepository.getByNomeContainsIgnoreCase("%" + id + "%" + nome + "%" + precoDaMaoDeObra);
    }

    @Transactional
    public Servico gerarIdentificadoresDeServico(GerarIdentificadoresDeServicoDTO dto) {
        Servico servico = this.pegarPorId(dto.getServicoId());
        if (Objects.isNull(servico.getIdentificadorDeServicos())) {
            servico.setIdentificadorDeServicos(new ArrayList<>());
        }
        for (int i = 1; i <= dto.getQuantidadeTotal(); i++) {
            servico.getIdentificadorDeServicos()
                    .add(new IdentificadorDeServico(i + servico.getPrecoDaMaoDeObra()));
        }
        servico.setPrecoDaMaoDeObra(servico.getPrecoDaMaoDeObra() + dto.getQuantidadeTotal());
        return this.servicoRepository.save(servico);
    }

}
