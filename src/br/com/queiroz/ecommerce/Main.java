package br.com.queiroz.ecommerce;

import br.com.queiroz.ecommerce.produto.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean fecharSistema = false;

        LojaVirtual minhaLoja = new LojaVirtual();

        criaCatalogoProdutos(minhaLoja);

        System.out.println("-----Bem Vindo ao Ecommerce Já-----");

        while (!fecharSistema) {

            System.out.println("-----Menu-----");
            System.out.println("(Pressione '1', '2', ou '3', para as seguintes ações)");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Login");
            System.out.println("3 - Sair");
            System.out.println();

            System.out.print("-> ");
            int escolhaMenu = scanner.nextInt();
            scanner.nextLine();

            switch(escolhaMenu) {

                case 1 -> cadastrarCliente(minhaLoja, scanner);
                case 2 -> login(minhaLoja, scanner);
                case 3 -> {
                    System.out.println("Obrigado, até logo!");
                    fecharSistema = true;
                }
            }

        }

    }

    private static void cadastrarCliente(LojaVirtual minhaLoja, Scanner scanner) {

        System.out.print("Insira seu nome completo: ");
        String nome = scanner.nextLine();

        System.out.print("Insira seu CPF ");
        String cpf = scanner.nextLine();

        System.out.print("Insira seu endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Insira seu email: ");
        String email = scanner.nextLine();

        System.out.print("Insira sua senha: ");
        String senha = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, endereco, email, senha);
        minhaLoja.adicionarCliente(cliente);

        System.out.println();
        System.out.println("Cadastro realizado com sucesso!");
        System.out.println("Faça seu login utilizando seu e-mail e senha cadastrados.");

        System.out.println();
    }

    private static void login(LojaVirtual minhaLoja, Scanner scanner) {

        boolean loginCompleto = false;

        while (!loginCompleto) {

            System.out.println("---BEM VINDO!---");
            System.out.print("Insira seu email: ");
            String emailLogin = scanner.nextLine();
            System.out.print("Insira sua senha: ");
            String senhaLogin = scanner.nextLine();

            System.out.println();

            if (!minhaLoja.autenticarCliente(emailLogin, senhaLogin)) {
                System.out.println("Email ou senha incorreto(s).");
            } else {
                loginCompleto = true;
            }

            CarrinhoCompra carrinhoCliente = new CarrinhoCompra();

            while (loginCompleto) {

                System.out.println("MENU PRINCIPAL");
                System.out.println("Selecione a opção desejada: ");
                System.out.println("1 -> Ver catálogo de produtos.");
                System.out.println("2 -> Buscar produto por nome.");
                System.out.println("3 -> Adicionar produto ao carrinho.");
                System.out.println("4 -> Ver carrinho.");
                System.out.println("5 -> Finalizar compra.");
                System.out.println("6 -> Logout.");
                System.out.println();
                System.out.print("Sua opção: ");
                int escolhaMenuPrincipal = scanner.nextInt();
                scanner.nextLine();

                switch(escolhaMenuPrincipal) {

                    case 1 -> exibirCatalogoProdutos(minhaLoja);
                    case 2 -> buscarProdutoPorNome(minhaLoja, scanner);
                    case 3 -> adicionarProdutoCarrinho(minhaLoja, scanner, carrinhoCliente);
                    case 4 -> exibirCarrinho(carrinhoCliente);
                    case 5 -> finalizarCompra(carrinhoCliente, scanner, minhaLoja);
                    case 6 -> loginCompleto = false;
                }
            }
        }
    }

    private static void finalizarCompra(CarrinhoCompra carrinhoCliente, Scanner scanner, LojaVirtual minhaLoja) {

        System.out.print("Por favor, insira seu cep: ");
        String cepCliente = scanner.nextLine();

        carrinhoCliente.calcularFrete(cepCliente, carrinhoCliente);

        Cliente cLienteLogado = minhaLoja.getClienteLogado();

        int qnt = cLienteLogado.getCompras();

        carrinhoCliente.aplicarDesconto(qnt);

        System.out.println();

        carrinhoCliente.revisarPedido();

        carrinhoCliente.confirmarPedido(scanner, cLienteLogado);

    }

    private static void exibirCarrinho(CarrinhoCompra carrinhoCliente) {

        carrinhoCliente.visualizarCarrinho();
    }

    private static void adicionarProdutoCarrinho(LojaVirtual minhaLoja, Scanner scanner, CarrinhoCompra carrinhoCliente) {

            minhaLoja.visualizarProduto();

            System.out.print("Digite o número do seu produto: ");
            int itemEScolhido = scanner.nextInt();

            minhaLoja.escolherProduto(itemEScolhido, carrinhoCliente);

    }

    private static void buscarProdutoPorNome(LojaVirtual minhaLoja, Scanner scanner) {

        System.out.print("Por favor insira o nome do produto: ");
        String busca = scanner.nextLine();

        minhaLoja.buscaProduto(busca);

    }

    private static void exibirCatalogoProdutos(LojaVirtual minhaLoja) {

        minhaLoja.exibirCatalogo();
        System.out.println();
    }

    private static void criaCatalogoProdutos(LojaVirtual minhaLoja) {
        Eletronico foneDeOuvido = new Eletronico("Fone de Ouvido Bluetoth", 49.90, 7, 110, 1);

        minhaLoja.adicionarProduto(foneDeOuvido);

        Eletronico improssora = new Eletronico("Impressora", 420.10, 4, 110, 3);

        minhaLoja.adicionarProduto(improssora);

        Alimento chocotone = new Alimento("Chocotone", 21.30, 70, 1, LocalDate.of(2026,2,24));

        minhaLoja.adicionarProduto(chocotone);

        Alimento cafe = new Alimento("Café 100% Arábica", 49.90, 97, 1, LocalDate.of(2026, 11, 20));

        minhaLoja.adicionarProduto(cafe);

        Roupa calcaP = new Roupa("Calça Sarja Masculina Adulto P", 139.90, 14, "Preto", "P");

        minhaLoja.adicionarProduto(calcaP);

        Roupa calcaM = new Roupa("Calça Sarja Masculina Adulto M", 139.90, 27, "Preto", "M");

        minhaLoja.adicionarProduto(calcaM);

        Roupa calcaG = new Roupa("Calça Sarja Masculina Adulto G", 139.90, 44,"Preto", "G");

        minhaLoja.adicionarProduto(calcaG);

        Roupa calcaGG = new Roupa("Calça Sarja Masculina Adulto GG", 139.90, 0,"Preto", "GG");

        minhaLoja.adicionarProduto(calcaGG);

        Livro ego = new Livro("O ego é seu inimigo", 37.90, 42, 0, "Ryan Holiday");

        minhaLoja.adicionarProduto(ego);

        Livro habito = new Livro("Hábitos Atômicos", 53.10, 52, 0, "James CLear");

        minhaLoja.adicionarProduto(habito);
    }

}
