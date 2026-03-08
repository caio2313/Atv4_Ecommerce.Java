package br.com.queiroz.ecommerce.produto;

import br.com.queiroz.ecommerce.CarrinhoCompra;

public class Roupa extends Produto {

    private String cor;
    private String tamanho;

    public Roupa(String nome, double preco, int estoque, String cor, String tamanho) {
        super(nome, preco, estoque);
        this.cor = cor;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Roupa{" +
                "cor='" + cor + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }

    @Override
    public double calcularFrete(String cep, CarrinhoCompra carrinhoCliente) {

        return 15.00;
    }
}
