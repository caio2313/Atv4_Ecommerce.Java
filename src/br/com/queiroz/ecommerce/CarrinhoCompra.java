package br.com.queiroz.ecommerce;

import br.com.queiroz.ecommerce.produto.Produto;
import br.com.queiroz.ecommerce.produto.Roupa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoCompra {

    private List<Produto> produtos;
    private double subtotal;
    private double frete;
    private double desconto;
    private double descontoEmCombo;
    private double descontoPrimeiraCompra;
    private double total;

    public CarrinhoCompra(){
        this.produtos = new ArrayList<>();
        this.subtotal = 0.0;
        this.frete = 0.0;
        this.desconto = 0.0;
        this.total = 0.0;
        this.descontoEmCombo = 0.0;
        this.descontoPrimeiraCompra = 0.0;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto item) {
        produtos.add(item);
        subtotal+= item.getPreco();
        System.out.println("Produto adicionado com sucesso.");
        System.out.println("Lista: " + produtos.size());
    }

    public void visualizarCarrinho() {
        if (produtos.isEmpty()) {
            System.out.println("Seu carrinho está vazio.");
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println("Produto: " + produtos.get(i).getNome() + ", Preço: " + produtos.get(i).getPreco());
            }
            System.out.println("Subtotal: " + subtotal);
        }
    }

    public void calcularFrete(String cep, CarrinhoCompra carrinhoCliente) {

        if(produtos.isEmpty()) {
            System.out.println("Seu carrinho está vazio.");
        }else {
            for (int i = 0; i < produtos.size(); i++) {
                frete += produtos.get(i).calcularFrete(cep, carrinhoCliente);
            }
        }
        System.out.println("Total do frete: R$" + frete);
    }

    public void freteGratis() {

        if(subtotal >= 200.00) {
            frete = 0.0;
            System.out.println("Muito bem! Compras acima de R$ 200,00 tem frete grátis!");
        }
    }

    public boolean primeiraCompra(int qnt) {

        boolean primeiraCompra;

        if(qnt == 0) {
            primeiraCompra = true;
            System.out.println("Muito bem! Para sua primeira compra receba 5% de desconto.");
            descontoPrimeiraCompra = subtotal * 0.05;
            System.out.println("Seu desconto será de: R$ " + Math.round(descontoPrimeiraCompra * 100.0) / 100.0);
        } else {
            primeiraCompra = false;
        }
        return primeiraCompra;
    }

    public boolean emCombo() {

        boolean emCombo;
        int roupa = 0;
        for(int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if(produto instanceof Roupa) {
                roupa++;
            }
        }

        if(roupa > 1) {
            emCombo = true;
            System.out.println("Muito bem! V0cê tem 10% de desconto ao comprar mais de uma peça de roupa.");
            descontoEmCombo = subtotal * 0.10;
            System.out.println("Seu desconto será de: R$ " + Math.round(descontoEmCombo * 100.0) / 100.0);

        } else {
            emCombo = false;
        }

        return emCombo;
    }

    public void calcularTotal() {
        total = subtotal + frete - desconto;
    }

    public void aplicarDesconto(int qnt) {

        if(emCombo()) {
            desconto += descontoEmCombo;
        }
        if(primeiraCompra(qnt)) {
            desconto += descontoPrimeiraCompra;
        }

        freteGratis();
    }

    public void revisarPedido() {
        System.out.println("Revise seu pedido: ");
        System.out.println("Subtotal: R$ " + subtotal);
        System.out.println("Descontos: R$ " + Math.round(desconto * 100.0) / 100.0);
        System.out.println("Frete: R$ " + frete);

        calcularTotal();

        System.out.println("Valor Total: R$ " + Math.round(total * 100.0) / 100.0);
    }

    public void confirmarPedido(Scanner scanner, Cliente clienteLogado ) {

        System.out.println("Confirmar pedido - 1/ Voltar para menu - 2");
        int num = scanner.nextInt();

        if(num == 1) {
            int pedido = clienteLogado.getNumeroPedido();
            System.out.println("Parabéns, seu pedido " + pedido +  " foi confirmado!");
        }

    }

}
