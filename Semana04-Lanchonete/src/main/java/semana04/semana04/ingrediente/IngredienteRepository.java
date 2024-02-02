package semana04.semana04.ingrediente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import semana04.semana04.logs.LogCreditoCliente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
}
