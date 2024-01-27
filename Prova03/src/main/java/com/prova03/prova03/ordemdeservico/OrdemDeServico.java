package com.prova03.prova03.ordemdeservico;

import com.prova03.prova03.helpers.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ordemdeservico")
public class OrdemDeServico extends EntityId {

    @Column(name ="identificadorDoServico", nullable = false)
    private String identificadorDoServico;

    private String identificadorDaPeca;

    private int quantidadeDaPeca;

    @Column(name ="identificadorDoVeiculo", nullable = false)
    private String identificadorDoVeiculo;

    @Column(name ="identificadorDoCliente", nullable = false)
    private String identificadorDoCliente;

    @Column(name ="dataDeInicio", nullable = false)
    private Date dataDeInicio;

    private Date dataDeFinalizacao;
}
