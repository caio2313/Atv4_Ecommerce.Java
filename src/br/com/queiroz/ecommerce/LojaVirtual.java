package br.com.queiroz.ecommerce;

import br.com.queiroz.ecommerce.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class LojaVirtual {

    private List<Produto> produtos;
    private List<Cliente> clientes;
    private Cliente clienteLogado;

    public LojaVirtual() {
        this.produtos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void adicionarProduto(Produto item) {
        produtos.add(item);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void exibirCatalogo() {

        System.out.println("Catálogo de Produtos:");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i));
        }
    }

    public boolean autenticarCliente(String email, String senha) {

        boolean result = false;

        for (int i = 0; i < clientes.size(); i++) {

            Cliente cliente = clientes.get(i);
            if (cliente.getEmail().equalsIgnoreCase(email) && cliente.getSenha().equals(senha)) {
                clienteLogado = cliente;
                result = true;
                break;
            }
        }
        return result;
    }

    public void buscaProduto(String busca) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().toLowerCase().contains(busca.toLowerCase())) {
                System.out.println(produtos.get(i));
            }
        }
    }

    public void visualizarProduto() {
        System.out.println("Adicione produtos ao seu carrinho!!");

        System.out.println("Escolha o Número correspondente ao seu produto e ele será adicionado ao seu carrinho.");

        for (int i = 0; i < produtos.size(); i++) {
            System.out.print(i + 1 + " -> ");
            System.out.println(produtos.get(i).getNome());
        }
    }

    public void escolherProduto(int itemEscolhido, CarrinhoCompra carrinhoCliente) {
        if (produtos.get(itemEscolhido - 1).getEstoque() > 0) {
            carrinhoCliente.adicionarProduto(produtos.get(itemEscolhido - 1));
        } else {
            System.out.println("Desculpe. Estoque indisponível no momento.");
        }
    }

}
