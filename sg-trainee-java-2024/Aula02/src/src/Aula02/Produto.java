package Aula02;

import javax.annotation.processing.Generated;
import java.util.SimpleTimeZone;


public class Produto {
    private Integer id;

    private String nome;
    private Double preco;
    private Integer quantidade;
    private SituacaoDeProduto status;


    public Produto(Integer id, String nome, double preco, int quantidade, SituacaoDeProduto status) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.status = status;
    }

    public Integer getId() {
        return id;
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
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
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
                ", quantidade=" + quantidade +
                ", ativo=" + status +
                '}';
    }
}