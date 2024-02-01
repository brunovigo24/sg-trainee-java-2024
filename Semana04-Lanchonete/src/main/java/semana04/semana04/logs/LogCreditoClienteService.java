package semana04.semana04.logs;

import jakarta.persistence.Access;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import semana04.semana04.cliente.ClienteRepository;

import java.util.List;

@Service
public class LogCreditoClienteService {

    private final LogCreditoClienteRepository logCreditoClienteRepository;

    private final ClienteRepository clienteRepository;

    @Autowired
    public LogCreditoClienteService(LogCreditoClienteRepository logCreditoClienteRepository,
                                    ClienteRepository clienteRepository) {
        this.logCreditoClienteRepository = logCreditoClienteRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public List<LogCreditoCliente> getLogsCreditoClienteByClienteId(Integer clienteId) {
        return logCreditoClienteRepository.findByClienteId(clienteId);
    }

    @Transactional
    public List<LogCreditoCliente> getAllLogsCreditoCliente() {
        return logCreditoClienteRepository.findAll();
    }
    @Transactional
    public LogCreditoCliente salvarLogCreditoCliente(LogCreditoCliente logCreditoCliente) {
        // Implementar validações
        return logCreditoClienteRepository.save(logCreditoCliente);
    }
}
