package semana04.semana04.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LogCreditoClienteRepository extends JpaRepository<LogCreditoCliente, Integer> {
    @Query("SELECT lc FROM logcreditocliente lc WHERE lc.clienteId = :clienteId")
    List<LogCreditoCliente> findByClienteId(Integer clienteId);

}