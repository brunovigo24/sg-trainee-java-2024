package semana04.semana04.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cliente")
public class ClienteAPI {
    private final ClienteService clienteService;

    @Autowired
    public ClienteAPI(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("")
    public ResponseEntity salvar(@RequestBody Cliente cliente, BigDecimal valor) {
        return ResponseEntity.ok(this.clienteService.salvar(cliente, valor));
    }
    @PutMapping("/adicionar-creditos/{clienteId}")
    public void adicionarCreditos(@PathVariable("clienteId")Integer clienteId, @RequestParam ("valor") BigDecimal valor) {
        clienteService.adicionarCreditos(clienteId, valor);
    }

    @GetMapping("/verificar-creditos/{clienteId}/{valorVenda}")
    public boolean verificarCreditosCliente(
            @PathVariable Integer clienteId,
            @PathVariable BigDecimal valorVenda) {
        return clienteService.verificarCreditosCliente(clienteId, valorVenda);
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Cliente cliente, BigDecimal valor,
                                    @PathVariable Integer id) {
        return ResponseEntity.ok(this.clienteService.salvar(cliente, valor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        this.clienteService.deletarCliente(id);
        return ResponseEntity.accepted().build();
    }
}
