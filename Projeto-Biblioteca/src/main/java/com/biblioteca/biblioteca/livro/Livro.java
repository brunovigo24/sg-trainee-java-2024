package com.biblioteca.biblioteca.livro;

import com.biblioteca.biblioteca.helpers.EntityId;
import com.biblioteca.biblioteca.identificadordelivro.IdentificadorDeLivro;
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
@Entity(name = "livro")
public class Livro extends EntityId {
    @Column(name = "nome")
    private String nome;
    @Column(name = "situacao")
    private SituacaoLivro situacao;
    @Enumerated(EnumType.STRING)
    @Column(name = "situacao_string")
    private SituacaoLivro situacaoString;
    @Column(name = "date")
    private Date date;
    @Column(name = "quantidade_total")
    private int quantidadeTotal;
    @Column(name = "quantidade_disponivel")
    private int quantidadeDisponivel;
    @Column(name = "quantidade_alugada")
    private int quantidadeAlugada;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "livro_id")
    private List<IdentificadorDeLivro> identificadorDeLivros = new ArrayList<>();

    public void alteraQuantidadeDeAluguel(int quantidade) {
        this.quantidadeAlugada += quantidade;
        this.quantidadeDisponivel -= quantidade;
    }

    public void alteraQuantidadeDeDevolucao(int quantidade) {
        this.quantidadeAlugada -= quantidade;
        this.quantidadeDisponivel += quantidade;
    }
}
