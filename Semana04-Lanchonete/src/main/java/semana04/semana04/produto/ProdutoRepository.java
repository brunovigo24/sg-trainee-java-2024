package semana04.semana04.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import semana04.semana04.cliente.Cliente;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM produto WHERE nome ILIKE :nome")
    List<Produto> findAllByNome(@Param("nome") String nome);

}
