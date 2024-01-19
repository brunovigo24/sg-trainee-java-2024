package com.semanadois.semanadois.cinema.assentos;

import com.semanadois.semanadois.cinema.dtos.ComprarAssentosDeFilmeDTO;
import com.semanadois.semanadois.cinema.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class AssentoService {

    private final AssentosRepository assentosRepository;

    @Autowired
    public AssentoService(AssentosRepository assentosRepository) { this.assentosRepository = assentosRepository;
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
        return this.assentosRepository.findAllByNome(Integer.valueOf("%" + nome + "%"));
    }

    @Transactional
    public List<Assentos> comprarAssentos(Integer filmeId,
                                          Integer pessoaId,
                                          ComprarAssentosDeFilmeDTO comprarIngressoFilmeDTO) {
        List<Assentos> assentos =
                this.assentosRepository.findAllById(Arrays.asList(1, 2));

        assentos.stream().forEach(assento -> {
            if (Objects.nonNull(assento.getPessoaId())) {
                throw new RuntimeException("Assento já comprado: " + assento.getNumeroassento());
            } else {
                assento.setPessoaId(pessoaId);
            }
        });
        return this.assentosRepository.saveAll(assentos);
    }
}
