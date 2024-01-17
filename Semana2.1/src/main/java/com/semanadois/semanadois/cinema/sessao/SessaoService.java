package com.semanadois.semanadois.cinema.sessao;

import com.semanadois.semanadois.cinema.sessao.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SessaoService  {

    private final SessaoRepository sessaoRepository;

    @Autowired
    public SessaoService (SessaoRepository sessaoRepository) {
        this.sessaoRepository = sessaoRepository;
    }

    @Transactional
    public Sessao cadastrar(Sessao sessao) {
        return this.sessaoRepository.save(sessao);
    }

    public Sessao pegarPorId(Integer id) {
        return this.sessaoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarSessao(Integer id) {
        this.sessaoRepository.deleteById(id);
    }


    @Transactional(readOnly = true)
    public List<Sessao> findByNome(String nome) {
        return this.sessaoRepository.findAllByNome("%" + nome + "%");
    }
}
