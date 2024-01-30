package semana04.semana04.movimentacaoestoque;


public enum TipoMovimentacao {
    VENDA("Venda"),
    ENTRADA_ESTOQUE("Entrada de Estoque"),
    SAIDA_ESTOQUE("Saída de Estoque"),
    ENTRADA_PRODUCAO_ESTOQUE("Entrada por Produção de Estoque"),
    SAIDA_PRODUCAO_ESTOQUE("Saída para Produção de Estoque");

    private final String descricao;

    TipoMovimentacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
