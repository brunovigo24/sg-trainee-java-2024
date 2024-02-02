package semana04.semana04.receita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import semana04.semana04.venda.Venda;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
}
