package br.com.queiroz.ecommerce.produto;

import br.com.queiroz.ecommerce.CarrinhoCompra;

public class Eletronico extends Produto {

    private int voltagem;
    private int garantia;

    public Eletronico(String nome, double preco, int estoque, int voltagem, int garantia ) {
        super(nome, preco, estoque);
        this.voltagem = voltagem;
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return "Eletronico{" +
                "voltagem=" + voltagem +
                ", garantia=" + garantia +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }

    @Override
    public double calcularFrete(String cep, CarrinhoCompra carrinhoCliente) {

        double frete = 0.0;
        String num = cep.substring(0,2);
        int numero = Integer.parseInt(num);

        if(numero < 40) {
            frete = 20.00;
        } else if(numero >= 80 && numero <= 99) {
            frete = 25.00;
        } else if(numero >= 70 && numero <= 76) {
            frete = 30.00;
        } else if(numero < 66) {
            frete = 35.00;
        } else if(numero == 68 || numero == 69 || numero >= 76 && numero <= 78) {
            frete = 40.00;
        }

        return frete;
    }
}
