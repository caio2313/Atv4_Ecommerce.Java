package br.com.queiroz.ecommerce.produto;

import br.com.queiroz.ecommerce.CarrinhoCompra;

import java.time.LocalDate;

public class Alimento extends Produto {

    private double peso;
    private LocalDate validade;

    public Alimento(String nome, double preco, int estoque, double peso, LocalDate validade) {
        super(nome, preco, estoque);
        this.peso = peso;
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "peso=" + peso +
                ", validade=" + validade +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }

    @Override
    public double calcularFrete(String cep, CarrinhoCompra carrinhoCliente) {

        double frete = 5.00;

        double pesoTotal = Math.floor(this.peso);

        if (pesoTotal > 1) {
            frete *= pesoTotal;
        }
        return frete;
    }
}
