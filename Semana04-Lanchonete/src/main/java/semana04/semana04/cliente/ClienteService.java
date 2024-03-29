package semana04.semana04.cliente;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import semana04.semana04.logs.LogCreditoCliente;
import semana04.semana04.logs.LogCreditoClienteRepository;
import semana04.semana04.logs.LogCreditoClienteService;
import semana04.semana04.logs.MovimentoCredito;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    private final LogCreditoClienteRepository logCreditoClienteRepository;

    private final LogCreditoClienteService logCreditoClienteService;


    @Autowired
    public ClienteService(ClienteRepository clienteRepository,
                          LogCreditoClienteRepository logCreditoClienteRepository,
                          LogCreditoClienteService logCreditoClienteService) {
        this.clienteRepository = clienteRepository;
        this.logCreditoClienteRepository = logCreditoClienteRepository;
        this.logCreditoClienteService = logCreditoClienteService;}

    @Transactional(readOnly = true)
    public Cliente pegarClientePorId(Integer id) {
        return this.clienteRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Cliente salvar(Cliente cliente, BigDecimal valor) {
        if (Objects.isNull(cliente.getNome()) || cliente.getNome().isEmpty()) {
            throw new RuntimeException("Cliente sem nome");
        }
        if (Objects.isNull(cliente.getCpf()) || cliente.getCpf().isEmpty()) {
            throw new RuntimeException("Cliente sem cpf");
        }
        //Garantindo que atributo valorCreditos não seja nulo
        if (Objects.isNull(cliente.getValorCreditos())) {
            cliente.setValorCreditos(BigDecimal.ZERO);
        } else cliente.setValorCreditos(cliente.getValorCreditos().add(valor));

        clienteRepository.save(cliente);

        LogCreditoCliente logCreditoCliente = new LogCreditoCliente();
        logCreditoCliente.setClienteId(cliente.getId());
        logCreditoCliente.setValor(valor);
        logCreditoCliente.setMovimento(MovimentoCredito.ENTRADA);
        logCreditoClienteRepository.save(logCreditoCliente);

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void adicionarCreditos(Integer clienteId, BigDecimal valor) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        if (valor.compareTo(BigDecimal.ZERO) <= 0 ) {
            throw new RuntimeException(" O valor dos créditos deve ser maior que zero");
        }
        cliente.setValorCreditos(cliente.getValorCreditos().add(valor));
        clienteRepository.save(cliente);

        //Registrar mov de cliente
        LogCreditoCliente logCreditoCliente = new LogCreditoCliente();
        logCreditoCliente.setClienteId(cliente.getId());
        logCreditoCliente.setValor(valor);
        logCreditoCliente.setData(new Date());
        logCreditoCliente.setMovimento(MovimentoCredito.ENTRADA);
        logCreditoClienteRepository.save(logCreditoCliente);
    }

    public boolean verificarCreditosCliente(Integer clienteId, BigDecimal valorVenda) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Verificar se o cliente tem créditos suficientes
        return cliente.getValorCreditos().compareTo(valorVenda) >= 0;
    }

    public boolean retirarCreditosAoFinalizarVenda(Integer clienteId, BigDecimal valorVenda) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (cliente.getValorCreditos().compareTo(valorVenda) < 0) {
            throw new RuntimeException("Créditos insuficientes para finalizar a venda");
        }

        cliente.setValorCreditos(cliente.getValorCreditos().subtract(valorVenda));
        clienteRepository.save(cliente);

        // Registrar no log de crédito
        LogCreditoCliente logCreditoCliente = new LogCreditoCliente();
        logCreditoCliente.setClienteId(clienteId);
        logCreditoCliente.setValor(valorVenda.negate()); // Valor negativo para representar saída de créditos
        logCreditoCliente.setData(new Date());
        logCreditoCliente.setMovimento(MovimentoCredito.SAIDA_COMPRA);
        logCreditoClienteService.salvarLogCreditoCliente(logCreditoCliente);
        return true;
    }
    @Transactional
    public Cliente atualizar(Cliente cliente, Integer clienteId, BigDecimal valor) {
        if (!cliente.getId().equals(clienteId)) {
            throw new RuntimeException("Cliente diferente do ID");
        }
        this.pegarClientePorId(clienteId);
        return this.salvar(cliente, valor);
    }


    @Transactional(readOnly = true)
    public List<Cliente> findByNome(String nome) {
        return this.clienteRepository.findAllByNome("%" + nome + "%");
    }

    @Transactional
    public void deletarCliente(Integer clienteId) {
        /*this.pegarClientePorId(clienteId);
        if (this.clienteRepository.findAllByNome()) {
            throw new RuntimeException("Cliente tem créditos positivos");*/
            this.clienteRepository.deleteById(clienteId);
        //}
    }

}
