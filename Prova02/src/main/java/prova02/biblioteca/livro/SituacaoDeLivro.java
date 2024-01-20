package prova02.biblioteca.livro;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Entity(name = "situacaodelivro")
public enum SituacaoDeLivro {

    ATIVO("ativo"),

    INATIVO("inativo");

    private final String label;

}