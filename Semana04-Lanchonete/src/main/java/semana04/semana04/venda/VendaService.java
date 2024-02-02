package semana04.semana04.venda;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semana04.semana04.cliente.ClienteService;
import semana04.semana04.logs.LogCreditoCliente;
import semana04.semana04.logs.LogCreditoClienteService;
import semana04.semana04.logs.MovimentoCredito;
import semana04.semana04.produto.Produto;
import semana04.semana04.produto.ProdutoService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    private final LogCreditoClienteService logCreditoClienteService;

    @Autowired
    public VendaService (VendaRepository vendaRepository,
                         ClienteService clienteService,
                         ProdutoService produtoService,
                         LogCreditoClienteService logCreditoClienteService) {
        this.vendaRepository = vendaRepository;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.logCreditoClienteService = logCreditoClienteService;
    }
    private List<ItemVenda> criarItensVenda(VendaDTO vendaDTO) {
        List<ItemVenda> itensVenda = new ArrayList<>();

        for (int i = 0; i < vendaDTO.getProdutoId().size(); i++) {
            Integer produtoId = vendaDTO.getProdutoId().get(i);
            Integer quantidade = vendaDTO.getQuantidades().get(i);

            Produto produto = produtoService.getProdutoById(produtoId);

            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProdutoId(produtoId);
            itemVenda.setQuantidade(quantidade);
            itemVenda.setValor(produto.getPrecoVenda().multiply(new BigDecimal(quantidade)));

            itensVenda.add(itemVenda);
        }
        return itensVenda;
    }

    @Transactional
    public void realizarVenda(VendaDTO vendaDTO) {
        BigDecimal valorTotal = calcularValorTotal(vendaDTO);

        clienteService.verificarCreditosCliente(vendaDTO.getClienteId(), valorTotal);
        //produtoService.verificarDisponibilidadeProduto(Integer produtoId, Integer quantidade);

        Venda venda = new Venda();
        venda.setClienteId(vendaDTO.getClienteId());
        venda.setValor(valorTotal);
        venda.setDataVenda(new Date());
        venda.setItens(criarItensVenda(vendaDTO));

        vendaRepository.save(venda);

        LogCreditoCliente logCreditoCliente = new LogCreditoCliente();
        logCreditoCliente.setClienteId(vendaDTO.getClienteId());
        logCreditoCliente.setValor(valorTotal.negate()); // Valor negativo para representar saída de créditos
        logCreditoCliente.setData(new Date());
        logCreditoCliente.setMovimento(MovimentoCredito.SAIDA_COMPRA);

        logCreditoClienteService.salvarLogCreditoCliente(logCreditoCliente);
    }

    private void verificarDisponibilidadeEAtualizarEstoque(VendaDTO vendaDTO) {
        for (int i = 0; i < vendaDTO.getProdutoId().size(); i++) {
            Integer produtoId = vendaDTO.getProdutoId().get(i);
            Integer quantidade = vendaDTO.getQuantidades().get(i);

            //produtoService.verificarDisponibilidadeEAtualizarEstoque(produtoId, quantidade);
        }
    }

    private BigDecimal calcularValorTotal(VendaDTO vendaDTO) {
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (int i = 0; i < vendaDTO.getProdutoId().size(); i++) {
            Integer produtoId = vendaDTO.getProdutoId().get(i);
            Integer quantidade = vendaDTO.getQuantidades().get(i);

            Produto produto = produtoService.getProdutoById(produtoId);
            BigDecimal valorItem = produto.getPrecoVenda().multiply(new BigDecimal(quantidade));

            valorTotal = valorTotal.add(valorItem);
        }

        return valorTotal;
    }
    private void verificarDisponibilidadeProduto(List<ItemVenda> itensVenda) {
        for (ItemVenda itemVenda : itensVenda) {
            if (!produtoService.verificarDisponibilidadeProduto(itemVenda.getProdutoId(), itemVenda.getQuantidade())) {
                throw new RuntimeException("Produto não disponível em estoque: " + itemVenda.getProdutoId());
            }
        }
    }

}
