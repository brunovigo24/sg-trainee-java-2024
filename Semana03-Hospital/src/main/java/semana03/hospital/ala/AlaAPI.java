package semana03.hospital.ala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import semana03.hospital.DTOs.GerarAlaQuartosELeitosDTO;
import semana03.hospital.hospital.HospitalService;

@RestController
@RequestMapping("/alas")
public class AlaAPI {

    private final AlaService alaService;

    @Autowired
    public AlaAPI(AlaService alaService) {
        this.alaService =  alaService;
    }


    /*@PostMapping
    public ResponseEntity criarAla(@RequestBody GerarAlaQuartosELeitosDTO dto) {
        return ResponseEntity.ok(this.alaService.GerarAlasQuartosELeitos(dto));
    }*/

    @PostMapping("/gerar")
    public ResponseEntity GerarAlasQuartosELeitos(@RequestBody GerarAlaQuartosELeitosDTO dto) {
        this.alaService.GerarAlasQuartosELeitos(dto);
        return ResponseEntity.ok().build();
    }



    //Hospital > Alas
    //Alas > Quartos
    //Quartos > Leitos
    //Leitos > Paciente
    //
    //
    //Preciso de uma classe com a função GerarAlaQuartosELeitosDTO
    //Ao cadastrar uma ala, informar a sua especialidade, quantidade de quartos e quantidade de leitos por quarto;
    //Os quartos e leitos deverão ser gerados automaticamente após a requisição para gerar as alas;
    //Os quartos deverão ter um código conforme o exemplo:
    //	Ala Cardiologia - quarto número 1 => CAR1
    //	Ala Cardiologia - quarto número 2 => CAR2
    //	Ala Pediatria - quarto número 1 => PED1
    //Os leitos também deverão ter um código conforme o exemplo:
    //	Ala Cardiologia - quarto número 1 - leito número 1 = > CAR1-1
    //	Ala Cardiologia - quarto número 1 - leito número 2 = > CAR1-2
    //	Ala Neurologia - quarto número 3 - leito número 2 = > NEU3-2
    //
    //Opção de aumentar ou diminuir quartos
    //
    //string especialidade
    //
    //dto
    //nome ala
    //quantidade de quartos
    //quantidade de leitos
    //
    //Regra, se todos os quartos estão ocupados,
    //não tem nenhum leito disponível

    //https://dontpad.com/semanatressgcloud


}
