package com.prova03.prova03.cliente;

import com.prova03.prova03.servico.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
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
        if (Objects.isNull(cliente.getNomeCliente()) || cliente.getNomeCliente().isEmpty()) {
            throw new RuntimeException("Cliente sem nome");
        }
        return this.clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente atualizar(Cliente cliente, Integer pessoaId) {
        if (!cliente.getId().equals(pessoaId)) {
            throw new RuntimeException("Cliente diferente do ID");
        }
        this.pegarClientePorId(pessoaId);
        return this.salvar(cliente);
    }

    @Transactional
    public void deletarCliente(Integer clienteId) {
        this.pegarClientePorId(clienteId);
        if (this.clienteRepository.existsIdentificadorComIdDoCliente(clienteId)) {
            throw new RuntimeException("Cliente tem livro alugado");
        }
    }

    @Transactional(readOnly = true)
    public List<Cliente> getPorOrdemAlfabeticaPorNome(Integer id, String nome) {
        List<Cliente> clientes = this.clienteRepository.findAll();
        clientes.sort(Comparator.comparing(Cliente::getNomeCliente));
        return this.clienteRepository.getByNomeContainsIgnoreCase("%" + id + "%" + nome );
    }

}
