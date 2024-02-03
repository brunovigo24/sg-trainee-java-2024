package semana04.semana04.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.adicional.ItemAdicional;
import semana04.semana04.helpers.EntityId;
import semana04.semana04.ingrediente.Ingrediente;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "produto")
public class Produto extends EntityId {

    @Column(name = "nome")
    private String nome;

    @Column(name = "precoCusto")
    private BigDecimal precoCusto;

    @Column(name = "precoVenda")
    private BigDecimal precoVenda;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "dataCadastro")
    private Date dataCadastro;

    @Enumerated(EnumType.STRING)
    private TipoProduto tipo;

    @Enumerated(EnumType.STRING)
    private Formato formato;

}
