package Aula02;

import javax.annotation.processing.Generated;
import java.util.SimpleTimeZone;


public class Produto  extends PadraoIdInteiro{
    private String nome;
    private Double preco;
    private Integer estoque;
    private SituacaoDeProduto status;


    public Produto(Integer id, String nome, double preco, int estoque,SituacaoDeProduto status) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {return estoque;}
    public void setEstoque(Integer estoque) {this.estoque = estoque;}
    public SituacaoDeProduto getStatus() {
        return status;
    }

    public void setStatus(SituacaoDeProduto status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                ", ativo=" + status +
                '}';
    }
}