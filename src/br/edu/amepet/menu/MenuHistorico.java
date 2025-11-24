package br.edu.amepet.menu;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import java.util.Scanner;

public class MenuHistorico {

    public static void exibir(GerenciadorPetShop sistema, Scanner sc) {

        int opcao;

        do {
            System.out.print("\n");
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║                HISTÓRICO DO PET                ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Histórico de Serviços                       ║");
            System.out.println("║ 2. Histórico Médico                             ║");
            System.out.println("║ 0. Voltar                                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> exibirHistoricoServicos(sistema, sc);
                case 2 -> exibirHistoricoMedico(sistema, sc);
                case 0 -> System.out.println("Voltando ao menu anterior...\n");
                default -> System.out.println("Opção inválida! Tente novamente.\n");
            }

        } while (opcao != 0);
    }

    private static void exibirHistoricoServicos(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Histórico de Serviços ----");

        System.out.print("CPF do dono (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        sistema.mostrarHistoricoServicos(cpf, nomePet); // método esperado no sistema
    }

    private static void exibirHistoricoMedico(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Histórico Médico ----");

        System.out.print("CPF do dono (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        sistema.mostrarHistoricoMedico(cpf, nomePet); // método esperado no sistema
    }
}
