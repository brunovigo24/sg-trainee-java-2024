package com.semanadois.semanadois.cinema.assentos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssentosRepository extends JpaRepository<Assentos, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM produto WHERE nome ILIKE :nome")
    List<Assentos> findAllByNome(@Param("nome") Integer numeroAssento);
}
