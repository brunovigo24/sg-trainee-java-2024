package com.prova03.prova03.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(nativeQuery = true,
        value = "SELECT COUNT(*) > 0 " +
                "FROM identificador_do_servico i " +
                "WHERE i.pessoa_id = :pessoaId")
    Boolean existsIdentificadorComIdDoCliente(@Param("clienteId") Integer clienteId);

    @Query(nativeQuery = true,
            value = "SELECT * FROM cliente l WHERE l.nome ILIKE :nome")
    List<Cliente> getByNomeContainsIgnoreCase(@Param("nome") String nome);



}
