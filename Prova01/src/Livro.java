import java.util.Date;

public class Livro extends PadraoIdInteiro {
    private String nome;
    private SituacaoDeLivro status;
    private Date DataDeCadastro;

    //Quantidade total
    private Integer estoque;




    public Livro(Integer id, String nome, SituacaoDeLivro status, Date DataDeCadastro, int estoque) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.DataDeCadastro = DataDeCadastro;
        this.estoque = estoque;
    }


    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public SituacaoDeLivro getStatus() {return status;}

    public void setStatus(SituacaoDeLivro status) {this.status = status;}

    public Date getDataDeCadastro() {return DataDeCadastro;}

    public void setDataDeCadastro(Date dataDeCadastro) {DataDeCadastro = dataDeCadastro;}


    public Integer getEstoque() {return estoque;}
    public void setEstoque(Integer estoque) {this.estoque = estoque;}



    @Override
    public String toString() {
        return "Livro{" +
                "Nome" + nome + '\'' +
                "ativo" + status +
                "Data de cadastro" + DataDeCadastro +
                "Quantidade total" + estoque +
                "}";

    }
}
