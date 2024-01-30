package semana04.semana04.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public Cliente pegarClientePorId(Integer id) {
        return this.clienteRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        if (Objects.isNull(cliente.getNome()) || cliente.getNome().isEmpty()) {
            throw new RuntimeException("Cliente sem nome");
        }
        return this.clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente atualizar(Cliente cliente, Integer clienteId) {
        if (!cliente.getId().equals(clienteId)) {
            throw new RuntimeException("Cliente diferente do ID");
        }
        this.pegarClientePorId(clienteId);
        return this.salvar(cliente);
    }

    @Transactional
    public void deletarCliente(Integer clienteId) {
        this.pegarClientePorId(clienteId);
        if (this.clienteRepository.existsIdentificadorComIdDoCliente(clienteId)) {
            throw new RuntimeException("Cliente tem livro alugado");
        }
    }

}
