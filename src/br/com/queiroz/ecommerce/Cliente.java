package br.com.queiroz.ecommerce;

import java.util.Random;

public class Cliente {

    Random random = new Random();

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String senha;
    private int compras;
    private int numeroPedido;

    public Cliente(String nome, String cpf, String endereco, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.compras = 0;
        this.numeroPedido = random.nextInt(1000);
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getCompras() {
        return compras;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeCliente='" + nome + '\'' +
                ", cpfCliente='" + cpf + '\'' +
                ", enderecoCLiente='" + endereco + '\'' +
                ", emailCliente='" + email + '\'' +
                ", senhaCLiente='" + senha + '\'' +
                '}';
    }
}
