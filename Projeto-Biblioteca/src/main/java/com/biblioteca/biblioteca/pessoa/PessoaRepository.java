package com.biblioteca.biblioteca.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query(nativeQuery = true,
        value = "SELECT COUNT(*) > 0 " +
                "FROM identificador_de_livro i " +
                "WHERE i.pessoa_id = :pessoaId")
    Boolean existsIdentificadorComIdDaPessoa(@Param("pessoaId") Integer pessoaId);



}
