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

            Integer opcObj = CancelarAcao.readIntSafe(sc);
            opcao = (opcObj == null) ? 0 : opcObj;

            switch (opcao) {

                case 1 -> {
                    String cpf = CancelarAcao.readDigitsSafe(sc, "CPF do cliente");
                    sistema.buscarClientePorCpf(cpf);
                    break;
                }

                case 2 -> {
                    String nome = CancelarAcao.readStringSafe(sc, "Nome do pet");
                    sistema.buscarPetPorNome(nome);
                    break;
                }

                case 3 -> {
                    String nome = CancelarAcao.readStringSafe(sc, "Nome do produto");
                    sistema.buscarProduto(nome);
                    break;
                }

                case 4 -> {
                    String cpf = CancelarAcao.readDigitsSafe(sc, "CPF do dono do pet");

                    String nome = CancelarAcao.readStringSafe(sc, "Nome do pet");

                    sistema.buscarServicos(cpf, nome);
                    break;
                }

                case 0 -> System.out.println("Voltando...\n");
                default -> System.out.println("Opção inválida!\n");

            }

        } while (opcao != 0);
    }
}
