package com.prova03.prova03.servico;

import com.prova03.prova03.helpers.EntityId;
import com.prova03.prova03.identificadores.IdentificadorDePeca;
import com.prova03.prova03.identificadores.IdentificadorDeServico;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "servico")
public class Servico extends EntityId {

    @Column(name ="nome", nullable = false)
    private String nome;

    @Column(name ="precoDaMaoDeObra", nullable = false)
    private int precoDaMaoDeObra;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "servico_id")
    private List<IdentificadorDeServico> identificadorDeServicos = new ArrayList<>();

}
