package br.com.queiroz.ecommerce.produto;

import br.com.queiroz.ecommerce.CarrinhoCompra;

public abstract class Produto {

    protected String nome;
    protected double preco;
    protected int estoque;

    protected Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public int getEstoque() {
        return estoque;
    }


    public abstract double calcularFrete(String cep, CarrinhoCompra carrinhoCliente);

}
