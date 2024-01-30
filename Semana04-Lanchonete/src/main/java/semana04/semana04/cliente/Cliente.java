package semana04.semana04.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "cliente")
public class Cliente extends EntityId {
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "valorCreditos")
    private BigDecimal valorCreditos;

    public boolean adicionarCreditos(BigDecimal valor) {
        // Implemente a lógica conforme necessário
        return true;
    }


}
