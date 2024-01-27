package com.prova03.prova03.identificadores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "identificador_do_servico")
public class IdentificadorDeServico {

    @Column(name = "ordemdeservicoId")
    private Integer ordemdeservicoId;

    @Column(name = "clienteId")
    private Integer clienteId;

    @Column(name = "numero")
    private Integer numero;

    public IdentificadorDeServico(Integer numero) {
        this.numero = numero;
    }

}
