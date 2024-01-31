package semana04.semana04.venda;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "venda")
public class Venda extends EntityId {


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id")
    private List<ItemVenda> itens;

    //Implementar vendas DTO
    private Integer clienteId;
    private BigDecimal valor;
    private Date data;


    // Implemente a lógica dentro do API e Service
    public void verificarDisponibilidadeProduto() {
    }

    public boolean verificarCreditosCliente() {
        return true;
    }

}
