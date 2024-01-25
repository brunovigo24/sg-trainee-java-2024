package semana03.hospital.quarto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM hospital l WHERE l.nome ILIKE :nome")
    List<Quarto> getByNomeContainsIgnoreCase(@Param("nome") String nome);


}
