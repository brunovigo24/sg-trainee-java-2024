package com.semanadois.semanadois.cinema.assentos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "assentos")
public class Assentos {

    @Id
    @Column(name = "numassento")
    private Integer numero;


    private int fileira;

}
