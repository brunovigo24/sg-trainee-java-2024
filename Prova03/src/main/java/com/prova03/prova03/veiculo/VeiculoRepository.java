package com.prova03.prova03.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM veiculo l WHERE l.nome ILIKE :nome")
    List<Veiculo> getByNomeContainsIgnoreCase(@Param("nome") String nome);
}