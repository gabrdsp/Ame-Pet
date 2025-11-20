package br.edu.amepet.menu;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import br.edu.amepet.modelo.pessoa.Funcionario;

import java.util.Scanner;

public class MenuFuncionario {
    public static void exibir(GerenciadorPetShop sistema, Scanner sc) {
        int opcao;

        do {
            System.out.print("\n");
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║                MENU FUNCIONÁRIO                ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Cadastrar Funcionáro                        ║");
            System.out.println("║ 2. Listar funcionários                         ║");
            System.out.println("║ 3. Remover funcionários                        ║");
            System.out.println("║ 0. Sair                                        ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n---- Cadastro de Funcionário ----");

                    sc.nextLine(); // Limpa buffer

                    System.out.print("\nNome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();

                    System.out.print("Salário: ");
                    double salario = Double.parseDouble(sc.nextLine());

                    System.out.print("Data de Admissão: ");
                    String dataAdmissao = sc.nextLine();

                    System.out.print("Usuário: ");
                    String usuario = sc.nextLine();

                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    Funcionario f = new Funcionario(nome, cpf, telefone, cargo, salario, dataAdmissao, usuario, senha);
                    sistema.adicionarFuncionario(f);

                    System.out.println("\nFuncionário cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("\n---- Lista de Funcionários ----");
                    sistema.listarFuncionarios();
                    break;
                case 3:
                    System.out.println("\n---- Remover Funcionário ----");
                    System.out.println("CPF do funcionário: ");
                    String cpfRemover = sc.nextLine();
                    
                    sistema.removerFuncionario(cpfRemover);
                    break;
                case 0:
                    System.out.println("Voltando ao menu anterior...\n");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
                    break;
            }
        } while (opcao != 0);
    }
}