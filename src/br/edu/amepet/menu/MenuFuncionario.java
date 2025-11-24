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
            System.out.println("║ 3. Remover funcionário                         ║");
            System.out.println("║ 0. Sair                                        ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n---- Cadastro de Funcionário ----");

                    System.out.print("\nNome (ou '!sair' para cancelar): ");
                    String nome = CancelarAcao.readLineAllowExit(sc);
                    if (nome == null) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("CPF (ou '!sair' para cancelar): ");
                    String cpf = CancelarAcao.readLineAllowExit(sc);
                    if (cpf == null) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Telefone (ou '!sair' para cancelar): ");
                    String telefone = CancelarAcao.readLineAllowExit(sc);
                    if (telefone == null) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Cargo (ou '!sair' para cancelar): ");
                    String cargo = CancelarAcao.readLineAllowExit(sc);
                    if (cargo == null) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Salário (ou '!sair' para cancelar): ");
                    Double salarioObj = CancelarAcao.readDoubleAllowExit(sc);
                    if (salarioObj == null) { System.out.println("Cadastro cancelado ou valor inválido."); break; }
                    double salario = salarioObj;

                    System.out.print("Data de Admissão (ou '!sair' para cancelar): ");
                    String dataAdmissao = CancelarAcao.readLineAllowExit(sc);
                    if (dataAdmissao == null) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Usuário (ou '!sair' para cancelar): ");
                    String usuario = CancelarAcao.readLineAllowExit(sc);
                    if (usuario == null) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Senha (ou '!sair' para cancelar): ");
                    String senha = CancelarAcao.readLineAllowExit(sc);
                    if (senha == null) { System.out.println("Cadastro cancelado."); break; }

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
                    System.out.print("CPF do funcionário (ou '!sair' para voltar): ");
                    String cpfRemover = CancelarAcao.readLineAllowExit(sc);
                    if (cpfRemover == null) { System.out.println("Operação cancelada."); break; }

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