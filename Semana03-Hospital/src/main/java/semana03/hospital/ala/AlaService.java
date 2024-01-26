package semana03.hospital.ala;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import semana03.hospital.DTOs.GerarAlaQuartosELeitosDTO;
import semana03.hospital.hospital.Hospital;
import semana03.hospital.hospital.HospitalService;
import semana03.hospital.leito.Leito;
import semana03.hospital.leito.LeitoRepository;
import semana03.hospital.leito.StatusLeito;
import semana03.hospital.quarto.Quarto;
import semana03.hospital.quarto.QuartoRepository;
import semana03.hospital.quarto.StatusQuarto;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlaService extends GerarAlaQuartosELeitosDTO {

    @Autowired
    private AlaRepository alaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private LeitoRepository leitoRepository;
    
    @Autowired
    private final HospitalService hospitalService;


    @Autowired
    public AlaService(AlaRepository alaRepository,
                      QuartoRepository quartoRepository,
                      LeitoRepository leitoRepository, HospitalService hospitalService) {
        this.alaRepository = alaRepository;
        this.quartoRepository=quartoRepository;
        this.leitoRepository=leitoRepository;
        this.hospitalService = hospitalService;
    }

    /*@Transactional
    public Ala gerarAlaQuartosELeitos(GerarAlaQuartosELeitosDTO dto) {
        Ala ala = this.alaRepository.findById(dto.getIdAla()).orElse(null);
        if (ala == null) {
            ala = new Ala();
            ala.setEspecialidade(dto.getEspecialidade());
            ala.setNome(dto.getNome());
        } else {
            ala.setNome(ala.getNome().substring(0, 3));
        }
            if (Objects.isNull(ala.getQuartos())) {
                ala.setQuartos(new ArrayList<>());
            }

            for (int i = 1; i <= dto.getQuantidadeQuartos(); i++) {
                Quarto quarto = new Quarto(ala.getNome() + i);
                ala.getQuartos().add(quarto);
            }

            for (Quarto quarto : ala.getQuartos()) {
                for (int j = 1; j <= dto.getQuantidadeLeitosPorQuarto(); j++) {
                    Leito leito = new Leito(quarto.getCodigo() + "-" + j);
                    leito.setQuarto(quarto);
                }
            }

            ala.setQuantidadeQuartos(ala.getQuantidadeQuartos() + dto.getQuantidadeQuartos());
            ala.setQuantidadeLeitos(ala.getQuantidadeLeitos() + dto.getQuantidadeLeitosPorQuarto() * dto.getQuantidadeQuartos());

            return this.alaRepository.save(ala);
    }*/

    @Transactional
    public List<Ala> GerarAlasQuartosELeitos(GerarAlaQuartosELeitosDTO dto) {
        Hospital hospital = this.hospitalService.getById(dto.getHospitalId());
        List<Ala> alas = new ArrayList<>();
        int numeroDeAlas = dto.getEspecialidade().size();
        for (int a = 1; a<= numeroDeAlas; a++){
            Ala ala = new Ala();
            String especialidade = (dto.getEspecialidade().get(a - 1));
            ala.setEspecialidade(especialidade);
            ala.setQuartos(this.gerarQuartos(dto, especialidade));
            alas.add(ala);
            
        }
        hospital.setAlas(alas);
        this.hospitalService.salvar(hospital);
        return alas;
    }

    @Transactional
    public List<Quarto> gerarQuartos(GerarAlaQuartosELeitosDTO dto, String especialidade) {
        List<Quarto> quartos = new ArrayList<>();
        for (int q = 1; q <= dto.getQuantidadeDeQuartos(); q++) {
            Quarto quarto = new Quarto();
            quarto.setStatus(StatusQuarto.DISPONIVEL);
            String sigla = especialidade.substring(0, 3).toUpperCase();
            String codigo = sigla.concat(String.valueOf(q));
            quarto.setCodigo(codigo);
            quarto.setLeitos(this.gerarLeitos(codigo,dto));
            quartos.add(quarto);
        }
        return quartos;
    }

    @Transactional
    public List<Leito> gerarLeitos(String codigo, GerarAlaQuartosELeitosDTO dto) {
        List<Leito> leitos = new ArrayList<>();
        for (int l = 1; l <=dto.getQuantidadeLeitosPorQuarto(); l++) {
            Leito leito = new Leito();
            leito.setStatus(StatusLeito.DISPONIVEL);
            String codigoLeito = codigo.concat(" - ").concat(String.valueOf(l));
            leito.setCodigo(codigoLeito);
        }
        return leitos;
    }

}


