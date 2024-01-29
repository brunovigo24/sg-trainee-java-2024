package com.biblioteca.biblioteca.identificadordelivro;

import com.biblioteca.biblioteca.helpers.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "identificador_de_livro")
public class IdentificadorDeLivro extends EntityId {
    @Column(name = "pessoa_id")
    private Integer pessoaId;
    @Column(name = "numero")
    private Integer numero;

    public IdentificadorDeLivro(Integer numero) {
        this.numero = numero;
    }
}
