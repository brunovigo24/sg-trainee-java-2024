package prova02.biblioteca.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService  {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService (PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public Pessoa cadastrar(Pessoa pessoa) {
        return this.pessoaRepository.save(pessoa);
    }

    public Pessoa pegarPorId(Integer id) {
        return this.pessoaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarPessoa(Integer id) {
        this.pessoaRepository.deleteById(id);
    }


    @Transactional(readOnly = true)
    public List<Pessoa> findByNome(String nome) {
        return this.pessoaRepository.findAllByNome("%" + nome + "%");
    }
}
