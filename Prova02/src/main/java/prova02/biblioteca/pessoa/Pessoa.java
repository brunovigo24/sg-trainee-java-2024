package prova02.biblioteca.pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import prova02.biblioteca.Entity.EntityId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pessoa")
public class Pessoa extends EntityId {

    @Column(name = "nome")
    private String nome;

}
