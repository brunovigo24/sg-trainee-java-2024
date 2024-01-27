package com.prova03.prova03.peca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM peca l WHERE l.nome ILIKE :nome")
    List<Peca> getByNomeContainsIgnoreCase(@Param("nome") String nome);
}