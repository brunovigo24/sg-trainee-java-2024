package com.semanadois.semanadois.cinema.filme;

import com.semanadois.semanadois.cinema.assentos.Assentos;
import com.semanadois.semanadois.cinema.dtos.GerarSessoesAssentosDTO;
import com.semanadois.semanadois.cinema.sessao.Sessao;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    @Autowired
    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Transactional
    public Filme cadastrar(Filme filme) {
        return this.filmeRepository.save(filme);
    }


    @Transactional(readOnly = true)
    public Filme getById(Integer id) {
        return this.filmeRepository.findById(id).orElse(null);
    }

    public Filme pegarPorId(Integer id) {
        return this.filmeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarProduto(Integer id) {this.filmeRepository.deleteById(id);
    }


    @Transactional(readOnly = true)
    public List<Filme> findByNome(String nome) {
        return this.filmeRepository.findAllByNome("%" + nome + "%");
    }

    @Transactional
    public Filme gerarSessoesAssentos(GerarSessoesAssentosDTO dto) {
        Filme filme = this.getById(dto.getFilmeId());
        if (Objects.nonNull(filme)) {
            List<Sessao> sessaoList = null;
            for (int s = 1; s < dto.getNumeroSessao(); s++) {
                sessaoList = new ArrayList<>();
                Sessao sessao = new Sessao();
                sessao.setNumemoSessao(s);
                sessao.setHorarioinicio(new Date());
                sessao.setHorariotermino(new Date());

                // criar assentos
                List<Assentos> assentosList = new ArrayList<>();
                for (int a= 1; a <= dto.getNumeroAssento(); a++) {
                    Assentos assento = new Assentos();
                    assento.setNumeroassento(a);
                    assentosList.add(assento);
                }
                sessao.setAssentos(assentosList);
                sessaoList.add(sessao);
            }

            // atribuir a lista de sessões ao filme
            filme.setSessaoList(sessaoList);

            this.cadastrar(filme);
            return filme;
        } else {
            throw new RuntimeException("Não tem filme com esse código!");
        }
    }
}
