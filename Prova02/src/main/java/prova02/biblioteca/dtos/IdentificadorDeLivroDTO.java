package prova02.biblioteca.dtos;

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
@Entity(name = "identificadordelivro")
public class IdentificadorDeLivroDTO  {


    @Column(name = "numero")
    Integer numero;
    @Column(name = "pessoaId")
    private Integer pessoaId;



}
