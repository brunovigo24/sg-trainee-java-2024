public enum SituacaoDeLivro {

    ATIVO("ativo"),

    INATIVO("inativo");

    private final String label;

    SituacaoDeLivro(String label) {this.label = label;}

    public String getLabel() {return this.label;}

}
