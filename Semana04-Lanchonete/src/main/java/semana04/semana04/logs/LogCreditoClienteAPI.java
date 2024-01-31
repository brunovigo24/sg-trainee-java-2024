package semana04.semana04.logs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs-credito-cliente")
public class LogCreditoClienteAPI {

    private final LogCreditoClienteService logCreditoClienteService;

    @Autowired
    public LogCreditoClienteAPI (LogCreditoClienteService logCreditoClienteService) {
        this.logCreditoClienteService = logCreditoClienteService;
    }
    @GetMapping
    public List<LogCreditoCliente> getAllLogsCreditoCliente() {
        return logCreditoClienteService.getAllLogsCreditoCliente();
    }

    @GetMapping("/cliente/{clienteId}")
    public List<LogCreditoCliente> getLogsCreditoClienteByClienteId(@PathVariable Integer clienteId) {
        // Exemplo: Buscar logs de crédito para um cliente específico
        return logCreditoClienteService.getLogsCreditoClienteByClienteId(clienteId);
    }

    @PostMapping
    public LogCreditoCliente salvarLogCreditoCliente(@RequestBody LogCreditoCliente logCreditoCliente) {
        return logCreditoClienteService.salvarLogCreditoCliente(logCreditoCliente);
    }

}
