package prova02.biblioteca.aluguel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import prova02.biblioteca.dtos.AlugarLivrosDTO;
import prova02.biblioteca.dtos.IdentificadorDeLivroDTO;
import prova02.biblioteca.livro.Livro;

import java.util.*;

public class AlugarService {

    private final AlugarRepository alugarRepository;

    @Autowired
    public AlugarService(AlugarRepository alugarRepository) { this.alugarRepository = AlugarService.this.alugarRepository;
    }

    public Alugar pegarPorId(int numeroaluguel) {
        return this.alugarRepository.findById(numeroaluguel).orElse(null);
    }

    @Transactional
    public void deletarAluguel(int numeroaluguel) {
        this.alugarRepository.deleteById(numeroaluguel);
    }


    @Transactional(readOnly = true)
    public List<Alugar> findByNome(String nome) {
        return this.alugarRepository.findAllByNome(Integer.valueOf("%" + nome + "%"));
    }
    @Transactional
    public List<Alugar> alugarLivro(Integer livroId,
                                      Integer pessoaId,
                                      IdentificadorDeLivroDTO identificadorDeLivroDTO) {
        List<Alugar> alugar =
                this.alugarRepository.findAllById(Arrays.asList(1, 2));

        alugar.stream().forEach(alugar -> {
            if (Objects.nonNull(alugar.getPessoaId())) {
                throw new RuntimeException("Aluguel já feito: " + alugar.getNumeroaluguel());
            } else {
                alugar.setPessoaId(pessoaId);
            }
        });
        return this.alugarRepository.saveAll(alugar);
    }

}
