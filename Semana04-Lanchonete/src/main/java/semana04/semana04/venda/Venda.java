package semana04.semana04.venda;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "venda")
public class Venda extends EntityId {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id")
    private List<ItemVenda> itens = new ArrayList<>();

    private Integer clienteId;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "datavenda")
    private Date dataVenda;
}
