package semana04.semana04.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LogCreditoClienteRepository extends JpaRepository<LogCreditoCliente, Integer> {

    List<LogCreditoCliente> findByClienteId(Integer clienteId);

}