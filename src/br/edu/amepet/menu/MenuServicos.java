package br.edu.amepet.menu;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import java.util.Scanner;

public class MenuServicos {

    public static void exibir(GerenciadorPetShop sistema, Scanner sc) {

        int opcao;

        do {
            System.out.print("\n");
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║                SERVIÇOS DO PETSHOP             ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Banho                                       ║");
            System.out.println("║ 2. Tosa                                        ║");
            System.out.println("║ 3. Exames                                      ║");
            System.out.println("║ 4. Consultas                                   ║");
            System.out.println("║ 5. Vacinas                                     ║");
            System.out.println("║ 6. Cirurgias                                   ║");
            System.out.println("║ 7. Internação                                  ║");
            System.out.println("║ 0. Voltar                                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                case 1 -> registrarBanho(sistema, sc);
                case 2 -> registrarTosa(sistema, sc);
                case 3 -> registrarExame(sistema, sc);
                case 4 -> registrarConsulta(sistema, sc);
                case 5 -> registrarVacina(sistema, sc);
                case 6 -> registrarCirurgia(sistema, sc);
                case 7 -> registrarInternacao(sistema, sc);
                case 0 -> System.out.println("Voltando ao menu anterior...\n");
                default -> System.out.println("Opção inválida! Tente novamente.\n");
            }

        } while (opcao != 0);
    }

    // =============================================================
    //                         BANHO
    // =============================================================
    private static void registrarBanho(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Banho ----");

        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        sistema.registrarBanho(cpf, nomePet);

        System.out.println("✔ Banho registrado com sucesso!");
    }

    // =============================================================
    //                         TOSA
    // =============================================================
    private static void registrarTosa(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Tosa ----");

        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        sistema.registrarTosa(cpf, nomePet);

        System.out.println("✔ Tosa registrada com sucesso!");
    }

    // =============================================================
    //                         EXAME
    // =============================================================
    private static void registrarExame(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Exame ----");

        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        sistema.registrarExame(cpf, nomePet);

        System.out.println("✔ Exame registrado com sucesso!");
    }

    // =============================================================
    //                         CONSULTA
    // =============================================================
    private static void registrarConsulta(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Consulta ----");

        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        sistema.registrarConsulta(cpf, nomePet);

        System.out.println("✔ Consulta registrada com sucesso!");
    }

    // =============================================================
    //                         VACINA
    // =============================================================
    private static void registrarVacina(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Vacina ----");

        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        sistema.registrarVacina(cpf, nomePet);

        System.out.println("✔ Vacina registrada com sucesso!");
    }

    // =============================================================
    //                         CIRURGIA
    // =============================================================
    private static void registrarCirurgia(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Cirurgia ----");

        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        sistema.registrarCirurgia(cpf, nomePet);

        System.out.println("✔ Cirurgia registrada com sucesso!");
    }

    // =============================================================
    //                         INTERNAÇÃO
    // =============================================================
    private static void registrarInternacao(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Internação ----");

        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        sistema.registrarInternacao(cpf, nomePet);

        System.out.println("✔ Internação registrada com sucesso!");
    }
}
