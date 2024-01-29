package com.biblioteca.biblioteca.livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM livro l WHERE l.nome ILIKE :nome")
    List<Livro> getByNomeContainsIgnoreCase(@Param("nome") String nome);
}
