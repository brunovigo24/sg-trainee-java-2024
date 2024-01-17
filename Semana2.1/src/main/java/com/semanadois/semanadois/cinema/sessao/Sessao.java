package com.semanadois.semanadois.cinema.sessao;

import com.semanadois.semanadois.cinema.assentos.Assentos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sessao")
public class Sessao {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "assentos_id")
    private List<Assentos> assentos;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    @Id
    @Column(name = "numsessao", nullable = false)
    private int numsessao;

    @Column(name ="horarioinicio", nullable = false)
    private SimpleDateFormat horarioinicio;

    @Column(name ="horariotermino", nullable = false)
    private SimpleDateFormat horariotermino;
}
