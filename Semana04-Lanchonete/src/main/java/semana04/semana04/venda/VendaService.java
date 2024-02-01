package semana04.semana04.venda;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semana04.semana04.cliente.ClienteService;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ClienteService clienteService;

    @Autowired
    public VendaService (VendaRepository vendaRepository,
                         ClienteService clienteService) {
        this.vendaRepository = vendaRepository;
        this.clienteService = clienteService;
    }

    /*@Transactional
    public void realizarVenda(VendaDTO dto) {
        verificarDisponibilidadeProduto();
        verificarCreditosCliente(dto.getClienteId(), dto.getValor());

        //Nova venda
        Venda venda = new Venda();
        venda.setClienteId(dto.getClienteId());
        venda.setValor(dto.getValor());
        venda.setDataVenda(new Date());
        venda.setItens(dto.getItens());

        vendaRepository.save(venda);
    }

    private void verificarDisponibilidadeProduto() {
        // Implementar lógica
    }

    private void verificarCreditosCliente(Integer clienteId, BigDecimal valorVenda) {
        if (!clienteService.verificarCreditosCliente(clienteId, valorVenda)) {
            throw new RuntimeException("Créditos insuficientes para realizar a venda");
        }
    }*/

}
