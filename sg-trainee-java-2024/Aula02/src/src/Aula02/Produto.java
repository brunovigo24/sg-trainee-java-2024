package Aula02;

import java.util.SimpleTimeZone;

public class Produto {

    private String nome;
    private double preco;
    private int quantidade;
    private SituacaoDeProduto status;

    // private boolean ativo;

    public SituacaoDeProduto getStatus() {
        return status;
    }

    public void setStatus(SituacaoDeProduto status) {
        this.status = status;
    }

    public Produto(String nome, double preco, int quantidade, SituacaoDeProduto status) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.status = status;
        // this.ativo = ativo;
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

   /* public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    } */

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

