package prova02.biblioteca.aluguel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlugarRepository extends JpaRepository<Alugar, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM produto WHERE nome ILIKE :nome")
    List<Alugar> findAllByNome(@Param("nome") Integer numeroAssento);
}