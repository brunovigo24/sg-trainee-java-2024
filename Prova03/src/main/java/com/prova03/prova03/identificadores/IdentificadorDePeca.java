package com.prova03.prova03.identificadores;

import com.prova03.prova03.helpers.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "identificador_de_peca")
public class IdentificadorDePeca extends EntityId {

    @Column(name = "ordemdeservicoId")
    private Integer ordemdeservicoId;

    @Column(name = "numero")
    private Integer numero;

    public IdentificadorDePeca(Integer numero) {
        this.numero = numero;
    }
}
