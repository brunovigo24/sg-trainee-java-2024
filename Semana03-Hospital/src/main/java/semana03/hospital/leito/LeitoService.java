package semana03.hospital.leito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import semana03.hospital.DTOs.LeitoProjectionDTO;
import semana03.hospital.ala.AlaRepository;
import semana03.hospital.hospital.HospitalService;
import semana03.hospital.quarto.QuartoRepository;

import java.util.List;

@Service
public class LeitoService {

    @Autowired
    private LeitoRepository leitoRepository;

    public Page<LeitoProjectionDTO> getLeitosOcupados(Pageable pageable) {
        Page<LeitoProjection> leitoProjections =  this.leitoRepository.getLeitosOcupadosPaginado(pageable);
        List<LeitoProjectionDTO> leitoProjectionDTOList = leitoProjections
                .getContent().stream().map(p -> {
                    return new LeitoProjectionDTO(p);
                }).toList();
        return new PageImpl<>(leitoProjectionDTOList, pageable, leitoProjections.getTotalElements());
    }

    public Page<Leito> getLeitosOcupadosTeste(Pageable pageable) {

        Page<Leito> pageLeitos = this.leitoRepository.getLeitosTestePagina(pageable);
        return this.leitoRepository.getLeitosTestePagina(pageable);
    }

    public Page<LeitoProjectionDTO>findLeitosLivresPorEspecialidade(Pageable pageable) {
        Page<LeitoProjection> leitoProjections = this.leitoRepository.findLeitosLivresPorEspecialidade(pageable);
        List<LeitoProjectionDTO> leitoProjectionDTOList = leitoProjections
                .getContent().stream().map(p -> {
                    return new LeitoProjectionDTO(p);
                }).toList();
        return new PageImpl<>(leitoProjectionDTOList, pageable, leitoProjections.getTotalElements());
    }




}
