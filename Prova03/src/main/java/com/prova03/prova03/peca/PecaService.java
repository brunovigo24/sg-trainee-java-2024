package com.prova03.prova03.peca;

import com.prova03.prova03.identificadores.IdentificadorDePeca;
import com.prova03.prova03.servico.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class PecaService {
    private final PecaRepository pecaRepository;

    @Autowired
    public PecaService(PecaRepository pecaRepository) {
        this.pecaRepository = pecaRepository;
    }

    @Transactional(readOnly = true)
    public Peca pegarPorId(Integer id) {
        return this.pecaRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Peca salvar(Peca peca) {
        if (Objects.isNull(peca.getNome()) || peca.getNome().isEmpty()) {
            throw new RuntimeException("Peca sem nome");
        }
        return this.pecaRepository.save(peca);
    }
    @Transactional
    public void deletarPeca(Integer pecaId) {
        this.pegarPorId(pecaId);
    }

    @Transactional(readOnly = true)
    public List<Peca> getPorOrdemAlfabeticaPorNome(Integer id, String nome, int quantidadeDeEstoque, int precoUnitario) {
        List<Peca> pecas = this.pecaRepository.findAll();
        pecas.sort(Comparator.comparing(Peca::getNome));
        return this.pecaRepository.getByNomeContainsIgnoreCase("%" + id + "%" + nome + "%" + quantidadeDeEstoque + "%" + precoUnitario);
    }

    @Transactional
    public Peca gerarIdentificadoresDePeca(GerarIdentificadoresDePecaDTO dto) {
        Peca peca = this.pegarPorId(dto.getPecaId());
        if (Objects.isNull(peca.getIdentificadorDePecas())) {
            peca.setIdentificadorDePecas(new ArrayList<>());
        }
        for (int i = 1; i <= dto.getQuantidadeTotal(); i++) {
            peca.getIdentificadorDePecas()
                    .add(new IdentificadorDePeca(i + peca.getQuantidadeDeEstoque()));
        }
        peca.setQuantidadeDeEstoque(peca.getQuantidadeDeEstoque() + dto.getQuantidadeTotal());
        peca.setQuantidadeDisponivel(peca.getQuantidadeDisponivel() + dto.getQuantidadeTotal());
        return this.pecaRepository.save(peca);
    }

}
