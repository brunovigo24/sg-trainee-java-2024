package com.prova03.prova03.veiculo;

import com.prova03.prova03.helpers.EntityId;
import com.prova03.prova03.identificadores.IdentificadorDePeca;
import com.prova03.prova03.identificadores.IdentificadorDeVeiculo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "veiculo")
public class Veiculo extends EntityId {

    @Column(name ="modelo", nullable = false)
    private String modelo;

    @Column(name ="marca", nullable = false)
    private String marca;

    @Column(name ="anoDeFabricacao", nullable = false)
    private int anoDeFabricacao;

    @Column(name ="kmRodados", nullable = false)
    private int kmRodados;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "peca_id")
    private List<IdentificadorDeVeiculo> identificadorDeVeiculos = new ArrayList<>();

}
