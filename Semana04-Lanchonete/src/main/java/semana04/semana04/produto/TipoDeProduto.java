package semana04.semana04.produto;

public enum TipoDeProduto {

    FINAL ("Final"),
    INGREDIENTE ("Ingrediente");

    private final String descricao;


    TipoDeProduto(String descricao) {
        this.descricao = descricao;
    }

}
