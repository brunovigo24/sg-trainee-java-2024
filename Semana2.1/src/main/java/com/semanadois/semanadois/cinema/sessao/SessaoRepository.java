package com.semanadois.semanadois.cinema.sessao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM sessao WHERE nome ILIKE :nome")
    List<Sessao> findAllByNome(@Param("nome") String nome);
}
