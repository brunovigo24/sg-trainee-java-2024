package semana03.hospital.hospital;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Transactional(readOnly = true)
    public Hospital pegarHospitalPorId(Integer id) {
        return this.hospitalRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Hospital salvar(Hospital hospital) {
        if (Objects.isNull(hospital.getNome()) || hospital.getNome().isEmpty()) {
            throw new RuntimeException("Hospital sem nome");
        }
        return this.hospitalRepository.save(hospital);
    }

    @Transactional
    public Hospital atualizar(Hospital hospital, Integer hospitalId) {
        if (!hospital.getId().equals(hospitalId)) {
            throw new RuntimeException("Hospital diferente do ID");
        }
        this.pegarHospitalPorId(hospitalId);
        return this.salvar(hospital);
    }

    @Transactional
    public void deletarHospital(Integer hospitalId) {
        this.pegarHospitalPorId(hospitalId);
        }


    @Transactional(readOnly = true)
    public List<Hospital> getByNomeContainsIgnoreCase(String nome) {
        return this.hospitalRepository.getByNomeContainsIgnoreCase("%" + nome + "%");
    }

    @Transactional(readOnly = true)
    public Hospital getById (Integer id) {
        return this.hospitalRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Hospital não encontrado");
        });
    }


}
