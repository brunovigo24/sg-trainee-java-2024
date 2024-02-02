package semana04.semana04.movimentacaoestoque;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "movimentacaoestoque")
public class MovimentacaoEstoque extends EntityId {

    private Integer produtoId;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private Date data;
    private double quantidade;
    @Enumerated(EnumType.STRING)
    private TipoMovimento tipoMovimento;
}