package com.semanadois.semanadois.cinema.assentos;

import com.semanadois.semanadois.cinema.Entity.EntityId;
import com.semanadois.semanadois.cinema.pessoa.PessoaService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "assentos")
public class Assentos extends EntityId {

    @Column(name = "numeroassento")
    private Integer numeroassento;

    @Column(name = "pessoaId")
    private Integer pessoaId;

}
