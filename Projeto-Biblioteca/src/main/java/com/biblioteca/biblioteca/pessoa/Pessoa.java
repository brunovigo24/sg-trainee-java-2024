package com.biblioteca.biblioteca.pessoa;

import com.biblioteca.biblioteca.helpers.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "pessoa")
public class Pessoa extends EntityId {
    @Column(name = "nome")
    private String nome;
}
