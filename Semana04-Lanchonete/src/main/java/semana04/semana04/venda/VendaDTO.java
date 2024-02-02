package semana04.semana04.venda;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class VendaDTO {
    private Integer clienteId;

    private List<Integer> produtoId;
    private List<Integer> quantidades;
}
