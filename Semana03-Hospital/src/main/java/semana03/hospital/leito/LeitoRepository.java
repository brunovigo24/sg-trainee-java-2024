package semana03.hospital.leito;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeitoRepository extends JpaRepository<Leito, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM hospital l WHERE l.nome ILIKE :nome")
    Page<Leito> getByNomeContainsIgnoreCase(@Param("nome") String nome);

    @Query(nativeQuery = true,
            value = "SELECT id, codigo_leito as codigoLeito FROM leitos ",
            countQuery = "SELECT COUNT(*) FROM leitos ")
    Page<LeitoProjection> getLeitosOcupadosPaginado(Pageable pageable);


    @Query(nativeQuery = true,
            value = "SELECT * FROM leitos ",
            countQuery = "SELECT COUNT(*) FROM leitos")
    Page<Leito> getLeitosTestePagina(Pageable pageable);

    @Query("SELECT l FROM Leito l " +
            "WHERE l.quarto.alas.especialidade.nome = :especialidade " +
            "AND l.paciente IS NULL")
    List<Leito> findLeitosLivresPorEspecialidade(Pageable pageable);
}


