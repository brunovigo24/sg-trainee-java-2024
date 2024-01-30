package semana04.semana04.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import semana04.semana04.cliente.Cliente;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT COUNT(*) > 0 " +
                    "FROM identificador_de_livro i " +
                    "WHERE i.produto_id = :protudoId")
    Boolean existsIdentificadorComIdDoProduto(@Param("produtoId") Integer produtoId);



}
