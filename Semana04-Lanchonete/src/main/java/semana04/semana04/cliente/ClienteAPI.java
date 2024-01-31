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
    public ResponseEntity salvar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(this.clienteService.salvar(cliente));
    }
    @PostMapping("/{clienteId}/adicionar-creditos")
    public void adicionarCreditos(@PathVariable Integer clienteId, @RequestParam BigDecimal valor) {
        clienteService.adicionarCreditos(clienteId, valor);
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Cliente cliente,
                                    @PathVariable Integer id) {
        return ResponseEntity.ok(this.clienteService.salvar(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        this.clienteService.deletarCliente(id);
        return ResponseEntity.accepted().build();
    }
}
