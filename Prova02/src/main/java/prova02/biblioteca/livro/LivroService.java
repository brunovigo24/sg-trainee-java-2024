package prova02.biblioteca.livro;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prova02.biblioteca.dtos.AlugarEDevolveLivros;
import prova02.biblioteca.dtos.IdentificadorDeLivroDTO;

import java.util.List;
import java.util.Objects;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Transactional
    public Livro cadastrar(Livro livro) {
        return this.livroRepository.save(livro);
    }


    @Transactional
    public Livro porOrdemAlfabetica(Livro livro) {
        return this.livroRepository.save(livro);
    }

    @Transactional(readOnly = true)
    public List<Livro> getOndeTemDisponivel() {
        List<Livro> livros = this.livroRepository.findAll();
        livros = livros
                .stream()
                .filter(livro -> livro.getQuantidadeDisponivel() > 0)
                .toList();
        return livros;
    }

    @Transactional
    public void alugaLivro(List<AlugarEDevolveLivros> dtos, Integer pessoaId) {
        if (Objects.isNull(dtos)) {
            throw new RuntimeException("DTO nulo");
        }
        dtos.forEach(dto -> {
            Livro livro = this.livroRepository
                    .findById(dto.getLivroId())
                    .orElseThrow(RuntimeException::new);
            if (livro.getSituacao().equals(SituacaoDeLivro.INATIVO)) {
                List<IdentificadorDeLivroDTO> identificadorDeLivroDTOS = livro.getIdentificadorDeLivroDTOS()
                        .stream()
                        .filter(idem -> dto.getNumeros().contains(idem.getNumero())
                                && Objects.isNull(idem.getPessoaId()))
                        .toList();
                if (identificadorDeLivroDTOS.size() != dto.getNumeros().size()) {
                    throw new RuntimeException("Algum livro não está dsponivel: ");
                }
                identificadorDeLivroDTOS.forEach(idem -> {
                    idem.setPessoaId(pessoaId);
                });
                livro.setQuantidadeAlugada(livro.getQuantidadeAlugada() + identificadorDeLivroDTOS.size());
                livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - identificadorDeLivroDTOS);
                this.livroRepository.save(livro);
            }
        });

    }


    @Transactional(readOnly = true)
    public Livro getById(Integer id) {
        return this.livroRepository.findById(id).orElse(null);
    }

    public Livro pegarPorId(Integer id) {
        return this.livroRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarLivro(Integer id) {this.livroRepository.deleteById(id);
    }


    @Transactional(readOnly = true)
    public List<Livro> findByNome(String nome) {
        return this.livroRepository.findAllByNome("%" + nome + "%");
    }

    /*@Transactional
    public Livro gerarIdentificadorDeLivro (IdentificadorDeLivroDTO dto) {
        Livro livro = this.getById(dto.getLivroId());
        if (Objects.nonNull(livro)) {
            List<Alugar> alugarList = null;
            for (int x = 1; x < dto.getNumeroAluguel(); x++) {
                alugarList = new ArrayList<>();
                Alugar alugar = new Alugar();
                alugar.setNumeroaluguel(x);
                alugar.setInicioaluguel(new Date());
                alugar.setTerminoaluguel(new Date());

                alugarList.add(alugar);
            }
            livro.setAlugarList(alugarList);
            this.cadastrar(livro);
            return livro;
        } else {
            throw new RuntimeException("Não tem livro com esse código!");
        }
    }*/

}
