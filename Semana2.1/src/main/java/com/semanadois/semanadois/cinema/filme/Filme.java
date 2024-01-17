package com.semanadois.semanadois.cinema.filme;


import com.semanadois.semanadois.cinema.sessao.Sessao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "filme")
public class Filme {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "filme_id")
    private List<Sessao> sessoes;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name ="nome", nullable = false)
    private String nome;

    @Column(name ="datainicio", nullable = false)
    private LocalDate datainicio;

    @Column(name ="datafimcartaz", nullable = false)
    private LocalDate datafimcartaz;



}
