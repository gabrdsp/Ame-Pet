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

            Integer opcObj = CancelarAcao.readIntSafe(sc);
            opcao = (opcObj == null) ? 0 : opcObj;

            switch (opcao) {
                case 1:
                    System.out.println("\n---- Cadastro de Funcionário ----");
                    System.out.println("( * ) Cancelar");

                    String nome = CancelarAcao.readStringSafe(sc, "Nome");
                    if (CancelarAcao.isCancelado(nome)) { System.out.println("Cadastro cancelado."); break; }

                    String cpf = CancelarAcao.readDigitsSafe(sc, "CPF");
                    if (CancelarAcao.isCancelado(cpf)) { System.out.println("Cadastro cancelado."); break; }

                    String telefone = CancelarAcao.readDigitsSafe(sc, "Telefone");
                    if (CancelarAcao.isCancelado(telefone)) { System.out.println("Cadastro cancelado."); break; }

                    String cargo = CancelarAcao.readStringSafe(sc, "Cargo");
                    if (CancelarAcao.isCancelado(cargo)) { System.out.println("Cadastro cancelado."); break; }

                    Double salario = CancelarAcao.readDoubleSafe(sc, "Salário");
                    if (salario == null) { System.out.println("Cadastro cancelado."); break; }

                    String dataAdmissao = CancelarAcao.readLineSafe(sc, "Data de Admissão");
                    if (CancelarAcao.isCancelado(dataAdmissao)) { System.out.println("Cadastro cancelado."); break; }

                    String usuario = CancelarAcao.readLineSafe(sc, "Usuário");
                    if (CancelarAcao.isCancelado(usuario)) { System.out.println("Cadastro cancelado."); break; }

                    String senha = CancelarAcao.readLineSafe(sc, "Senha");
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
                    String cpfRemover = CancelarAcao.readDigitsSafe(sc, "CPF do funcionário");
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