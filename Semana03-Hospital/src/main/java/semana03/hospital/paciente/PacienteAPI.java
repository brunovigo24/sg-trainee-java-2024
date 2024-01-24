package semana03.hospital.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteAPI {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteAPI(PacienteService pacienteService) {
        this.pacienteService =  pacienteService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(this.pacienteService.salvar(paciente));
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody Paciente paciente,
                                    @PathVariable Integer id) {
        return ResponseEntity.ok(this.pacienteService.salvar(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        this.pacienteService.deletarPaciente(id);
        return ResponseEntity.accepted().build();
    }
}
