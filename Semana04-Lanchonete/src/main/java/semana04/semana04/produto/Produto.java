package semana04.semana04.produto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "produto")
public class Produto extends EntityId {

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private TipoDeProduto tipo;





}
