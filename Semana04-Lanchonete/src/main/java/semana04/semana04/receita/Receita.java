package semana04.semana04.receita;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import semana04.semana04.helpers.EntityId;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "receita")
public class Receita extends EntityId{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "receita_id")
    private List<Ingrediente> ingredientes;


}
