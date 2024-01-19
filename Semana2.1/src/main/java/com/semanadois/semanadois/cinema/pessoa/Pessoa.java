package com.semanadois.semanadois.cinema.pessoa;

import com.semanadois.semanadois.cinema.Entity.EntityId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pessoa")
public class Pessoa extends EntityId {

    @Column(nullable = false, unique = true)
    private String nome;

}
