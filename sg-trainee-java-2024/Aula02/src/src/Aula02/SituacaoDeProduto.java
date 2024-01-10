package Aula02;

public enum SituacaoDeProduto {

    ATIVO("ativo"),

    INATIVO("inativo");

    private final String label;

    SituacaoDeProduto(String label) {this.label = label;}

    public String getLabel() { return this.label; }

}
