package com.semanadois.semanadois.cinema.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM produto WHERE nome ILIKE :nome")
    List<Pessoa> findAllByNome(@Param("nome") String nome);
}
