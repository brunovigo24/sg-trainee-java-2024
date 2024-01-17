package com.semanadois.semanadois.cinema.assentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
@Service
public class AssentoService {

    private final AssentosRepository assentosRepository;

    @Autowired
    public AssentoService(AssentosRepository) {
        this.assentosRepository = assentosRepository;
    }

    @Transactional
    public Assentos cadastrar(Assentos filme) {
        return this.assentosRepository.save(filme);
    }

    public Assentos pegarPorId(int numassento) {
        return this.assentosRepository.findById(numassento).orElse(null);
    }

    @Transactional
    public void deletarAssento(int numassento) {
        this.assentosRepository.deleteById(numassento);
    }


    @Transactional(readOnly = true)
    public List<Assentos> findByNome(String nome) {
        return this.assentosRepository.findAllByNome("%" + nome + "%");
    }
}*/
