package semana04.semana04.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(nativeQuery = true,
        value = "SELECT COUNT(*) > 0 " +
                "FROM identificador_de_livro i " +
                "WHERE i.pessoa_id = :pessoaId")
    Boolean existsIdentificadorComIdDoCliente(@Param("clienteId") Integer clienteId);



}
