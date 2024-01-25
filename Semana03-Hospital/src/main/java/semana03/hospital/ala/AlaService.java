package semana03.hospital.ala;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import semana03.hospital.DTOs.GerarAlaQuartosELeitosDTO;
import semana03.hospital.leito.Leito;
import semana03.hospital.leito.LeitoRepository;
import semana03.hospital.quarto.Quarto;
import semana03.hospital.quarto.QuartoRepository;

@Service
public class AlaService extends GerarAlaQuartosELeitosDTO {
    @Autowired
    private AlaRepository alaRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private LeitoRepository leitoRepository;


    @Autowired
    public AlaService(AlaRepository alaRepository) {
        this.alaRepository = alaRepository;
    }

    @Transactional
    public Ala criarAla(GerarAlaQuartosELeitosDTO dto) {
        Ala ala = new Ala();
        ala.setEspecialidade(dto.getEspecialidade());

        ala.setNome(dto.getNome().substring(0, 3));

        gerarAlaQuartosELeitos(ala, dto.getQuantidadeQuartos(), dto.getQuantidadeLeitosPorQuarto());

        return alaRepository.save(ala);
    }
    private void gerarAlaQuartosELeitos(Ala ala, int quantidadeQuartos, int quantidadeLeitosPorQuarto) {
        for (int i = 1; i <= quantidadeQuartos; i++) {
            Quarto quarto = new Quarto(ala.getNome() + i);
            quartoRepository.save(quarto);
            for (int j = 1; j <= quantidadeLeitosPorQuarto; j++) {
                Leito leito = new Leito(quarto.getCodigo() + "-" + j);
                leito.setQuarto(quarto);
                leitoRepository.save(leito);
            }
        }
    }

}
