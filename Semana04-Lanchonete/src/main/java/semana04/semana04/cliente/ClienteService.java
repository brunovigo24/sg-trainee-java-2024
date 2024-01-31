package semana04.semana04.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
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
        if (Objects.isNull(cliente.getCpf()) || cliente.getCpf().isEmpty()) {
            throw new RuntimeException("Cliente sem cpf");
        }

        //Tem que setar o bigDecimal.ZERO pois quando for puxar a função mov ou adicionar crédito se estiver vai dar bug
        return this.clienteRepository.save(cliente);
    }

    //Fazer método de adicionarCreditos
    /*public void adicionarCreditos(Integer clienteId, BigDecimal valor) {
        // Implementar a lógica
        return true;
    }*/

    @Transactional
    public Cliente atualizar(Cliente cliente, Integer clienteId) {
        if (!cliente.getId().equals(clienteId)) {
            throw new RuntimeException("Cliente diferente do ID");
        }
        this.pegarClientePorId(clienteId);
        return this.salvar(cliente);
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
