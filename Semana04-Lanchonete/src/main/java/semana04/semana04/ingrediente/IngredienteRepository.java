package semana04.semana04.ingrediente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import semana04.semana04.logs.LogCreditoCliente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    @Query("SELECT COUNT(i) > 0 FROM ingrediente i WHERE i.produto.id = :produtoId AND i.quantidade >= :quantidade")
    boolean verificarDisponibilidadeIngrediente(@Param("produtoId") Long produtoId, @Param("quantidade") Integer quantidade);
}
