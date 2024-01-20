package prova02.biblioteca.livro;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "livroid")
    private List<Alugar> alugarList;

    private String nome;

    private Date dataDeCadastro;

    private String quantidadeTotal;

    private String quantidadeDisponivel;

    private String quantidadeAlugada;

}
