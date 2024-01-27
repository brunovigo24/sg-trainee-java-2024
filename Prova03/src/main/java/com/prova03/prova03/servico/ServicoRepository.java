package com.prova03.prova03.servico;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM servico l WHERE l.nome ILIKE :nome")
    List<Servico> getByNomeContainsIgnoreCase(@Param("nome") String nome);
}