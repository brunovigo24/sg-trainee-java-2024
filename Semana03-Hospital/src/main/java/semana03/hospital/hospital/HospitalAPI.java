package semana03.hospital.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
public class HospitalAPI {
    private final HospitalService hospitalService;

    @Autowired
    public HospitalAPI(HospitalService hospitalService) {
        this.hospitalService =  hospitalService;
    }

    @GetMapping("/por-nome")
    public ResponseEntity getPorNome(@RequestParam(name = "nome") String nome) {
        return ResponseEntity.ok(this.hospitalService.getByNomeContainsIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Hospital hospital) {
        return ResponseEntity.ok(this.hospitalService.salvar(hospital));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Hospital hospital,
                                    @PathVariable Integer id) {
        return ResponseEntity.ok(this.hospitalService.salvar(hospital));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        this.hospitalService.deletarHospital(id);
        return ResponseEntity.accepted().build();
    }
}
