package prova02.biblioteca.aluguel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "alugar")
public class Alugar {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "alugarid")
    private List<Alugar> alugar;

    @Column(name = "numeroaluguel")
    private Integer numeroaluguel;

    @Column(name ="inicioaluguel", nullable = false)
    private Date inicioaluguel;

    @Column(name ="terminoaluguel", nullable = false)
    private Date terminoaluguel;

    @Column(name = "pessoaId")
    private Integer pessoaId;

}
