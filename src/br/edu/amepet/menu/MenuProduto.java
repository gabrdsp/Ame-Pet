package src.br.edu.amepet.menu;

import java.util.Scanner;

import src.br.edu.amepet.gerenciador.GerenciadorPetShop;
import src.br.edu.amepet.modelo.pessoa.Cliente;
import src.br.edu.amepet.modelo.produto.Produto;

public class MenuProduto {
    private GerenciadorPetShop gerenciador;
    private Scanner scanner;

    public MenuProduto(GerenciadorPetShop gerenciador, Scanner scanner){
        this.gerenciador = gerenciador;
        this.scanner = scanner;
    }

    public void exibirMenu(){
        int opcao = -1;

        while (opcao != 0){
            System.out.println("\n╔═════════════════════════════════════════════════════════╗");
            System.out.println("║                     MENU DE PRODUTOS                      ║");
            System.out.println("╠═══════════════════════════════════════════════════════════╣");
            System.out.println("║  1. Cadastrar Produto                                     ║");
            System.out.println("║  2. Listar Produtos                                       ║");
            System.out.println("║  3. Comprar produto                                       ║");
            System.out.println("║  4. Buscar produto por código                             ║");
            System.out.println("║  0. Voltar ao Menu Principal                              ║");
            System.out.println("╚═══════════════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
            
            try{
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e){
                opcao = -1;
            }

            switch (opcao){
                case 1 -> adicionarProduto();
                case 2 -> listarProdutos();
                case 3 -> comprarProduto();
                case 4 -> buscarProdutoPorCodigo();
                case 0 -> System.out.println("Retornando ao Menu Principal...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private void adicionarProduto(){
        System.out.println("\n>>> CADASTRAR NOVO PRODUTO <<<");

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade em estoque: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        try{
            Produto produto = new Produto(codigo, nome, categoria, preco, quantidade);
            gerenciador.getProdutos(). add(produto);

            System.out.println("Produto cadastrado com sucesso!");
        } catch (Exception e){
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    private void listarProdutos(){
        System.out.println("\n>>> LISTA DE PRODUTOS <<<");
        gerenciador.listarProdutos();
    }

    private void comprarProduto(){
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = gerenciador.buscarClientePorCpf(cpf);

        if(cliente == null){
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Código do produto: ");
        String codigo = scanner.nextLine();

        Produto produto = gerenciador.buscarProdutoPorCodigo(codigo);

        if(produto == null){
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Quantidade desejada: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        boolean sucesso = gerenciador.venderProduto(cpf, codigo, quantidade);

        if(sucesso){
            System.out.println("Compra realizada!");
        } else {
            System.out.println("Falha na compra. Verifique saldo ou estoque.");
        }
    }

    private void buscarProdutoPorCodigo(){
        System.out.print("Código do produto: ");
        String codigo = scanner.nextLine();

        Produto p = gerenciador.buscarProdutoPorCodigo(codigo);

        if(p != null){
            System.out.println("\n " + p.exibirInformacoes());
        } else {
            System.out.println("\nProduto não encontrado.");
        }
    }
}
