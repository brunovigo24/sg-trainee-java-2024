package prova02.biblioteca.livro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import prova02.biblioteca.Entity.EntityId;
import prova02.biblioteca.aluguel.Alugar;
import prova02.biblioteca.dtos.IdentificadorDeLivroDTO;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "livro")
public class Livro extends EntityId {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "livroid")
    private List<IdentificadorDeLivroDTO> identificadorDeLivroDTOS;

    @Column(name = "nome")
    private String nome;

    @Column(name = "situacao")
    private SituacaoDeLivro situacao;

    @Column(name = "dataDeCadastro")
    private Date dataDeCadastro;

    @Column(name = "quantidadeTotal")
    private int quantidadeTotal;

    @Column(name = "quantidadeDisponivel")
    private int quantidadeDisponivel;

    @Column(name = "quantidadeAlugada")
    private int quantidadeAlugada;

}
