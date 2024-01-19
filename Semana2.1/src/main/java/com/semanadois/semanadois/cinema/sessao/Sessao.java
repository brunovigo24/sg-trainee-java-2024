package com.semanadois.semanadois.cinema.sessao;

import com.semanadois.semanadois.cinema.Entity.EntityId;
import com.semanadois.semanadois.cinema.assentos.Assentos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sessao")
public class Sessao extends EntityId {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sessao_id")
    private List<Assentos> assentos;


    @Column(name = "numeroSessao", nullable = false)
    private int numemoSessao;

    @Column(name ="horarioinicio", nullable = false)
    private Date horarioinicio;

    @Column(name ="horariotermino", nullable = false)
    private Date horariotermino;


}
