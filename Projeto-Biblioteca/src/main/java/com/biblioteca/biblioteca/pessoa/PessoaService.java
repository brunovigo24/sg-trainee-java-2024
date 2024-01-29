package com.biblioteca.biblioteca.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional(readOnly = true)
    public Pessoa pegarPessoaPorId(Integer id) {
        return this.pessoaRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        if (Objects.isNull(pessoa.getNome()) || pessoa.getNome().isEmpty()) {
            throw new RuntimeException("Pessoa sem nome");
        }
        return this.pessoaRepository.save(pessoa);
    }

    @Transactional
    public Pessoa atualizar(Pessoa pessoa, Integer pessoaId) {
        if (!pessoa.getId().equals(pessoaId)) {
            throw new RuntimeException("Pessoa diferente do ID");
        }
        this.pegarPessoaPorId(pessoaId);
        return this.salvar(pessoa);
    }

    @Transactional
    public void deletarPessoa(Integer pessoaId) {
        this.pegarPessoaPorId(pessoaId);
        if (this.pessoaRepository.existsIdentificadorComIdDaPessoa(pessoaId)) {
            throw new RuntimeException("Pessoa tem livro alugado");
        }
    }

}
