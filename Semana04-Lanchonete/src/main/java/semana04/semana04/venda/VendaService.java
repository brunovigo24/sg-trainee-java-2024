package semana04.semana04.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    @Autowired
    public VendaService (VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }


}
