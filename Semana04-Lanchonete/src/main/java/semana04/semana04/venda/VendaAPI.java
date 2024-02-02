package semana04.semana04.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class VendaAPI {

    private final VendaService vendaService;

    @Autowired
    public VendaAPI (VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping("/realizar-venda")
    public void realizarVenda(@RequestBody VendaDTO vendaDTO) {
        vendaService.realizarVenda(vendaDTO);
    }
}
