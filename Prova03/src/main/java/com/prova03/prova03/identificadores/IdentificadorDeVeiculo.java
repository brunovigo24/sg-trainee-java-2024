package com.prova03.prova03.identificadores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "identificador_de_veiculo")
public class IdentificadorDeVeiculo {

    @Column(name = "ordemdeservicoId")
    private Integer ordemdeservicoId;

    @Column(name = "numero")
    private Integer numero;

    public IdentificadorDeVeiculo(Integer numero) {
        this.numero = numero;
    }
}
