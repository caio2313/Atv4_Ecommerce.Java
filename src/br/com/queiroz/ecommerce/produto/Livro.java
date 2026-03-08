package br.com.queiroz.ecommerce.produto;

import br.com.queiroz.ecommerce.CarrinhoCompra;

public class Livro extends Produto {

    private int paginas;
    private String autor;

    public Livro(String nome, double preco, int estoque, int paginas, String autor) {
        super(nome, preco, estoque);
        this.paginas = paginas;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }

    @Override
    public double calcularFrete(String cep, CarrinhoCompra carrinhoCliente) {
        double frete = 10.00;

        for(int i = 0; i < carrinhoCliente.getProdutos().size(); i++) {
           Produto obj = carrinhoCliente.getProdutos().get(i);
           if(obj instanceof Livro) {
               double valorLivros = 0.0;
               valorLivros += obj.getPreco();

               if(valorLivros > 50) {
                   frete = 0.0;
               }
           }
        }

        return frete;
    }
}
