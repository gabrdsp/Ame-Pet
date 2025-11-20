package br.edu.amepet.menu;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import java.util.Scanner;

public class MenuBuscar {

    public static void exibir(GerenciadorPetShop sistema, Scanner sc) {

        int opcao;

        do {
            System.out.print("\n");
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║                  MENU BUSCAR                   ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Buscar Cliente                              ║");
            System.out.println("║ 2. Buscar Pet                                  ║");
            System.out.println("║ 3. Buscar Produto                              ║");
            System.out.println("║ 4. Buscar Serviços                             ║");
            System.out.println("║ 0. Voltar                                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.print("CPF do cliente: ");
                    String cpf = sc.nextLine();
                    sistema.buscarClientePorCpf(cpf);
                    break;
                }

                case 2 -> {
                    System.out.print("Nome do pet: ");
                    String nome = sc.nextLine();
                    sistema.buscarPetPorNome(nome);
                    break;
                }

                case 3 -> {
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    sistema.buscarProduto(nome);
                    break;
                }

                case 4 -> {
                    System.out.print("CPF do dono do pet: ");
                    String cpf = sc.nextLine();

                    System.out.print("Nome do pet: ");
                    String nome = sc.nextLine();

                    sistema.buscarServicos(cpf, nome);
                    break;
                }

                case 0 -> System.out.println("Voltando...\n");
                default -> System.out.println("Opção inválida!\n");

            }

        } while (opcao != 0);
    }
}
