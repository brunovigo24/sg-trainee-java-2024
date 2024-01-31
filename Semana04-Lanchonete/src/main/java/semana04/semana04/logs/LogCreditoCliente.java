package semana04.semana04.logs;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "logcreditocliente")
public class LogCreditoCliente extends EntityId {

    private Integer clienteId;
    private BigDecimal valor;
    private Date data;
    @Enumerated(EnumType.STRING)
    private MovimentoCredito movimento;
}


