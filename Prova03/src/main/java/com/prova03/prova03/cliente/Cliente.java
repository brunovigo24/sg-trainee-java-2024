package com.prova03.prova03.cliente;

import com.prova03.prova03.helpers.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "cliente")
public class Cliente extends EntityId {


    @Column(name ="nome", nullable = false)
    private String nomeCliente;

    @Column(name ="cpf", nullable = false)
    private int cpf;
}
