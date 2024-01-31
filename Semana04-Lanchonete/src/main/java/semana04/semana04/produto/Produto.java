package semana04.semana04.produto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

import java.math.BigDecimal;
import java.util.Date;

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
