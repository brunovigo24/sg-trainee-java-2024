package semana03.hospital.leito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import semana03.hospital.DTOs.LeitoProjectionDTO;
import semana03.hospital.ala.AlaService;

import java.util.List;

@RestController
@RequestMapping("/leitos")
public class LeitoAPI {

    private final LeitoService leitoService;

    private final LeitoRepository leitoRepository;



    @Autowired
    public LeitoAPI(LeitoService leitoService,
                    LeitoRepository leitoRepository) {
        this.leitoService =  leitoService;
        this.leitoRepository = leitoRepository;
    }

    @GetMapping("/livres/{especialidade}")
    public ResponseEntity<Page<LeitoProjectionDTO>> getLeitosLivresPorEspecialidade(Pageable pageable) {
        return ResponseEntity.ok(this.leitoService.findLeitosLivresPorEspecialidade(pageable));
    }

    @GetMapping("/ocupados")
    public ResponseEntity<Page<LeitoProjectionDTO>> getLeitosOcupados(Pageable pageable ) {
        return ResponseEntity.ok(this.leitoService.getLeitosOcupados(pageable));
    }

    @GetMapping("/ocupados-teste")
    public ResponseEntity<Page<Leito>> getLeitosOcupadosTeste(Pageable pageable ) {
        return ResponseEntity.ok(this.leitoService.getLeitosOcupadosTeste(pageable));
    }

}
