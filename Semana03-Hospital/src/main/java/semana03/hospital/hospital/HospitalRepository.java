package semana03.hospital.hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM hospital l WHERE l.nome ILIKE :nome")
    List<Hospital> getByNomeContainsIgnoreCase(@Param("nome") String nome);


}
