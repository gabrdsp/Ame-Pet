package src.br.edu.amepet;
import src.br.edu.amepet.gerenciador.GerenciadorPetShop;
import src.br.edu.amepet.modelo.*;
import src.br.edu.amepet.modelo.Pet;

import java.util.Scanner;

public class Main {
    
    private static GerenciadorPetShop gerenciador;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        gerenciador = new GerenciadorPetShop();
        scanner = new Scanner(System.in);
        
        exibirBoasVindas();
        
        boolean continuar = true;
        while (continuar) {
            exibirMenuPrincipal();
            int opcao = lerOpcao();
            continuar = processarOpcao(opcao);
        }
        
        scanner.close();
        System.out.println("\n Sistema encerrado. Até logo!");
    }
    
    /**
     * Exibe mensagem de boas-vindas.
     */
    private static void exibirBoasVindas() {
        System.out.println("🐾 BEM-VINDO AO AME PET 🐾");
        System.out.println("Sistema de Gerenciamento Completo para PetShop");
    }
    
    /**
     * Exibe o menu principal do sistema.
     */
    private static void exibirMenuPrincipal() {
        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
        System.out.println("║                    MENU PRINCIPAL                     ║");
        System.out.println("╠═══════════════════════════════════════════════════════╣");
        System.out.println("║  1. Cadastrar Cliente                                 ║");
        System.out.println("║  2. Cadastrar Funcionário                             ║");
        System.out.println("║  3. Cadastrar Pet                                     ║");
        System.out.println("║  4. Listar Todas as Pessoas (Polimorfismo)            ║");
        System.out.println("║  5. Buscar Pessoa por CPF                             ║");
        System.out.println("║  6. Listar Clientes                                   ║");
        System.out.println("║  7. Listar Funcionários                               ║");
        System.out.println("║  8. Listar Pets                                       ║");
        System.out.println("║  0. Sair                                              ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }
    
    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static boolean processarOpcao(int opcao) {
        try {
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    cadastrarPet();
                    break;
                case 4:
                    gerenciador.listarTodasPessoas();
                    break;
                case 5:
                    buscarPessoa();
                    break;
                case 6:
                    gerenciador.listarClientes();
                    break;
                case 7:
                    gerenciador.listarFuncionarios();
                    break;
                case 8:
                    gerenciador.listarPets();
                    break;
                case 0:
                    return false;
                default:
                    System.out.println("\n Opção inválida! Tente novamente.");
            }
        } catch (Exception e) {
            System.err.println("\n Erro: " + e.getMessage());
        }
        
        pausar();
        return true;
    }
    
    /* Cadastra um novo cliente no sistema.*/
    private static void cadastrarCliente() {
        System.out.println("\n>>> CADASTRAR NOVO CLIENTE <<<");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        
        try {
            Cliente cliente = new Cliente(nome, cpf, telefone, endereco);
            gerenciador.adicionarPessoa(cliente);
            System.out.println("\n Cliente cadastrado com sucesso!");
            System.out.println(cliente.exibirDetalhes());
        } catch (IllegalArgumentException e) {
            System.err.println("\n Erro ao cadastrar: " + e.getMessage());
        }
    }
    
    /*Cadastra um novo funcionário no sistema.*/
    private static void cadastrarFuncionario() {
        System.out.println("\n>>> CADASTRAR NOVO FUNCIONÁRIO <<<");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        
        System.out.print("Salário: ");
        double salario = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Data de Admissão (dd/mm/aaaa): ");
        String dataAdmissao = scanner.nextLine();
        
        try {
            Funcionario funcionario = new Funcionario(nome, cpf, telefone, cargo, salario, dataAdmissao);
            gerenciador.adicionarPessoa(funcionario);
            System.out.println("\n Funcionário cadastrado com sucesso!");
            System.out.println(funcionario.exibirDetalhes());
        } catch (IllegalArgumentException e) {
            System.err.println("\n Erro ao cadastrar: " + e.getMessage());
        }
    }
    
    /* Cadastra um novo pet no sistema. */
    private static void cadastrarPet() {
        System.out.println("\n>>> CADASTRAR NOVO PET <<<");
        
        System.out.print("CPF do dono: ");
        String cpfDono = scanner.nextLine();
        
        Cliente cliente = gerenciador.buscarClientePorCpf(cpfDono);
        if (cliente == null) {
            System.out.println("\n Cliente não encontrado!");
            return;
        }
        
        System.out.print("Nome do pet: ");
        String nome = scanner.nextLine();
        
        System.out.print("Espécie (Cão, Gato, etc): ");
        String especie = scanner.nextLine();
        
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        
        System.out.print("Idade (anos): ");
        int idade = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Peso (kg): ");
        double peso = Double.parseDouble(scanner.nextLine());
        
        try {
            Pet pet = new Pet(nome, especie, raca, idade, peso, cpfDono);
            gerenciador.adicionarPet(pet);
            cliente.adicionarPet(pet);
            System.out.println("\n Pet cadastrado com sucesso!");
            System.out.println(pet.exibirInformacoes());
        } catch (IllegalArgumentException e) {
            System.err.println("\n Erro ao cadastrar: " + e.getMessage());
        }
    }
    
    /* Busca e exibe informações de uma pessoa pelo CPF. */
    private static void buscarPessoa() {
        System.out.println("\n>>> BUSCAR PESSOA POR CPF <<<");
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        
        Pessoa pessoa = gerenciador.buscarPessoaPorCpf(cpf);
        if (pessoa != null) {
            System.out.println(pessoa.exibirDetalhes());
        } else {
            System.out.println("\n Pessoa não encontrada!");
        }
    }
    
    private static void pausar() {
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}