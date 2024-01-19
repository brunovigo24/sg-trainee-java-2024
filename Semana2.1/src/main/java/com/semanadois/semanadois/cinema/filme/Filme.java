package com.semanadois.semanadois.cinema.filme;


import com.semanadois.semanadois.cinema.Entity.EntityId;
import com.semanadois.semanadois.cinema.sessao.Sessao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "filme")
public class Filme extends EntityId {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "filme_id")
    private List<Sessao> sessaoList;

    @Column(name ="nomeFilme", nullable = false)
    private String nomeFilme;

    @Column(name ="inicio_cartaz", nullable = false)
    private Date inicio_cartaz;

    @Column(name ="termino_cartaz", nullable = false)
    private Date termino_cartaz;
}
