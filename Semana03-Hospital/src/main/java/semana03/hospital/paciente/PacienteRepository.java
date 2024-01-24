package semana03.hospital.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT COUNT(*) > 0 " +
                    "FROM identificador_de_leito i " +
                    "WHERE i.paciente_id = :pacieteId")
    Boolean existsIdentificadorDeLeito(@Param("pacienteId") Integer pacienteId);
}
