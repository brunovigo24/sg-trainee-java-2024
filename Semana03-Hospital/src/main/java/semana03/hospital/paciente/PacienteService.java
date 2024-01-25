package semana03.hospital.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import semana03.hospital.hospital.Hospital;

import java.util.List;
import java.util.Objects;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional(readOnly = true)
    public Paciente pegarPacientePorId(Integer id) {
        return this.pacienteRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Paciente salvar(Paciente paciente) {
        if (Objects.isNull(paciente.getNome()) || paciente.getNome().isEmpty()) {
            throw new RuntimeException("Paciente sem nome");
        }
        return this.pacienteRepository.save(paciente);
    }

    @Transactional
    public Paciente atualizar(Paciente paciente, Integer pacienteId) {
        if (!paciente.getId().equals(pacienteId)) {
            throw new RuntimeException("Paciente diferente do ID");
        }
        this.pegarPacientePorId(pacienteId);
        return this.salvar(paciente);
    }

    @Transactional
    public void deletarPaciente(Integer pacienteId) {
        this.pegarPacientePorId(pacienteId);
    }

    @Transactional(readOnly = true)
    public List<Hospital> getByNomeContainsIgnoreCase(String nome) {
        return this.pacienteRepository.getByNomeContainsIgnoreCase("%" + nome + "%");
    }
}
