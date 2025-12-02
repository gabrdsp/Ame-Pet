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
                    System.out.println("( * ) Cancelar");

                    System.out.print("Nome: ");
                    String nome = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(nome)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("CPF: ");
                    String cpf = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(cpf)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Telefone: ");
                    String telefone = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(telefone)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Cargo: ");
                    String cargo = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(cargo)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Salário: ");
                    String salarioStr = CancelarAcao.readDouble(sc);
                    if (CancelarAcao.isCancelado(salarioStr)) { System.out.println("Cadastro cancelado."); break; }
                    double salario = Double.parseDouble(salarioStr);

                    System.out.print("Data de Admissão: ");
                    String dataAdmissao = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(dataAdmissao)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Usuário: ");
                    String usuario = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(usuario)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Senha: ");
                    String senha = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(senha)) { System.out.println("Cadastro cancelado."); break; }

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
                    System.out.println("( * ) Cancelar");
                    System.out.print("CPF do funcionário: ");
                    String cpfRemover = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(cpfRemover)) { System.out.println("Operação cancelada."); break; }

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