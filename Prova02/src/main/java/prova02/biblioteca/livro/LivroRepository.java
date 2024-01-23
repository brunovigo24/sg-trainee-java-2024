package prova02.biblioteca.livro;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Service
    public class LivroService {
        private final LivroRepository livroRepository;

        @Autowired
        public LivroService(LivroRepository livroRepository) {
            this.livroRepository = livroRepository;
        }
    }



    @Query(nativeQuery = true,
            value = "SELECT * FROM livro l WHERE l.nome ILIKE :nome")
    List<Livro> findAllByNome(@Param("nome") String nome);

    @Query(nativeQuery = true,
            value = "SELECT * FROM livro l WHERE l.nome ILIKE :nome")
    List<Livro> getByNomeContainsIgnoreCase(@Param("nome") String nome);
}
