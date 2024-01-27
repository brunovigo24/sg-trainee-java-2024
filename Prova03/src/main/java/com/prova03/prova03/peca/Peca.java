package com.prova03.prova03.peca;

import com.prova03.prova03.helpers.EntityId;
import com.prova03.prova03.identificadores.IdentificadorDePeca;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "peca")
public class Peca extends EntityId {

    @Column(name ="nome", nullable = false)
    private String nome;

    @Column(name ="fabricante", nullable = false)
    private String fabricante;

    @Column(name ="quantidadeDeEstoque", nullable = false)
    private int quantidadeDeEstoque;

    @Column(name ="quantidadeDisponivel", nullable = false)
    private int quantidadeDisponivel;

    @Column(name ="precoUnitario", nullable = false)
    private int precoUnitario;

    @Column(name ="dataDeCadastro")
    private Date dataDeCadastro;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "peca_id")
    private List<IdentificadorDePeca> identificadorDePecas = new ArrayList<>();

}
