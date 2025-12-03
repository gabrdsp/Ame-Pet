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

            Integer opcObj = CancelarAcao.readIntSafe(sc);
            opcao = (opcObj == null) ? 0 : opcObj;

            switch (opcao) {

                case 1 -> exibirHistoricoServicos(sistema, sc);
                case 2 -> exibirHistoricoMedico(sistema, sc);
                case 0 -> System.out.println("Voltando ao menu anterior...\n");
                default -> System.out.println("Opção inválida! Tente novamente.\n");
            }

        } while (opcao != 0);
    }

    private static void exibirHistoricoServicos(GerenciadorPetShop sistema, Scanner sc) {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║          HISTÓRICO DE SERVIÇOS               ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("( * ) Cancelar");

        String cpf = CancelarAcao.readDigitsSafe(sc, "CPF do dono");
        if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); return; }

        String nomePet = CancelarAcao.readStringSafe(sc, "Nome do pet");
        if (CancelarAcao.isCancelado(nomePet)) { System.out.println("Operação cancelada."); return; }
        System.out.println("╚════════════════════════════════════════════════╝");

        sistema.mostrarHistoricoServicos(cpf, nomePet);
    }

    private static void exibirHistoricoMedico(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Histórico Médico ----");
        System.out.println("( * ) Cancelar");

        String cpf = CancelarAcao.readDigitsSafe(sc, "CPF do dono");
        if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); return; }

        String nomePet = CancelarAcao.readStringSafe(sc, "Nome do pet");
        if (CancelarAcao.isCancelado(nomePet)) { System.out.println("Operação cancelada."); return; }

        sistema.mostrarHistoricoServicos(cpf, nomePet); // método esperado no sistema
    }
}
