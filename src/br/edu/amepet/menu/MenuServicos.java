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

        // 1. CPF do dono
        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        // 2. Nome do pet
        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        // 3. Código
        System.out.print("Código do exame: ");
        String codigo = sc.nextLine();

        // 4. Preço
        System.out.print("Preço do exame: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        // 5. Data
        System.out.print("Data do exame (ex: 2025-11-26): ");
        String data = sc.nextLine();

        // 6. Tipo do exame
        System.out.print("Tipo do exame: ");
        String tipoExame = sc.nextLine();

        // Enviar para o sistema
        sistema.registrarExame(codigo, preco, cpf, nomePet, data, tipoExame);

        System.out.println("✔ Exame registrado com sucesso!");
    }

    // =============================================================
    //                         CONSULTA
    // =============================================================
    private static void registrarConsulta(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Consulta ----");

        // 1. CPF do dono
        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        // 2. Nome do pet
        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        // 3. Código
        System.out.print("Código da consulta: ");
        String codigo = sc.nextLine();

        // 4. Preço
        System.out.print("Preço da consulta: ");
        double preco = sc.nextDouble();
        sc.nextLine(); // limpar buffer

        // 5. Data
        System.out.print("Data da consulta (ex: 2025-11-26): ");
        String data = sc.nextLine();

        // 6. Veterinário
        System.out.print("Nome do veterinário: ");
        String veterinario = sc.nextLine();

        // Envia tudo para o sistema
        sistema.registrarConsulta(codigo, preco, cpf, nomePet, data, veterinario);

        System.out.println("✔ Consulta registrada com sucesso!");
    }

    // =============================================================
    //                         VACINA
    // =============================================================
    private static void registrarVacina(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Vacina ----");

        // 1. CPF do dono
        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        // 2. Nome do pet
        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        // 3. Código
        System.out.print("Código da vacina: ");
        String codigo = sc.nextLine();

        // 4. Preço
        System.out.print("Preço da vacina: ");
        double preco = sc.nextDouble();
        sc.nextLine(); // limpar buffer

        // 5. Data
        System.out.print("Data da vacinação (ex: 2025-11-26): ");
        String data = sc.nextLine();

        // 6. Tipo de vacina
        System.out.print("Tipo da vacina: ");
        String tipoVacina = sc.nextLine();

        // Envia tudo para o sistema
        sistema.registrarVacina(codigo, preco, cpf, nomePet, data, tipoVacina);

        System.out.println("✔ Vacina registrada com sucesso!");
    }


    // =============================================================
    //                         CIRURGIA
    // =============================================================
    private static void registrarCirurgia(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Cirurgia ----");

        // 1. CPF do dono
        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        // 2. Nome do pet
        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        // 3. Código da cirurgia
        System.out.print("Código da cirurgia: ");
        String codigo = sc.nextLine();

        // 4. Preço
        System.out.print("Preço da cirurgia: ");
        double preco = sc.nextDouble();
        sc.nextLine(); // limpar buffer

        // 5. Data
        System.out.print("Data da cirurgia (ex: 2025-11-26): ");
        String data = sc.nextLine();

        // 6. Nome do procedimento / tipo de cirurgia
        System.out.print("Procedimento realizado: ");
        String procedimento = sc.nextLine();

        // 7. Duração (horas)
        System.out.print("Duração da cirurgia (em horas): ");
        int duracaoHoras = sc.nextInt();
        sc.nextLine(); // limpar buffer

        // Enviar tudo para o sistema
        sistema.registrarCirurgia(codigo, preco, cpf, nomePet, data, procedimento, duracaoHoras);

        System.out.println("✔ Cirurgia registrada com sucesso!");
    }


    // =============================================================
    //                         INTERNAÇÃO
    // =============================================================
    private static void registrarInternacao(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Internação ----");

        // 1. CPF do dono
        System.out.print("CPF do dono do pet (ou '!sair' para voltar): ");
        String cpf = CancelarAcao.readLineAllowExit(sc);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        // 2. Nome do pet
        System.out.print("Nome do pet (ou '!sair' para voltar): ");
        String nomePet = CancelarAcao.readLineAllowExit(sc);
        if (nomePet == null) { System.out.println("Operação cancelada."); return; }

        // 3. Código
        System.out.print("Código da internação: ");
        String codigo = sc.nextLine();

        // 4. Preço
        System.out.print("Preço da internação: ");
        double preco = sc.nextDouble();
        sc.nextLine(); // limpar buffer

        // 5. Data de entrada
        System.out.print("Data de entrada (ex: 2025-11-26): ");
        String dataEntrada = sc.nextLine();

        // 6. Motivo da internação
        System.out.print("Motivo da internação: ");
        String motivo = sc.nextLine();

        // 7. Dias internado
        System.out.print("Quantidade de dias internado: ");
        int dias = sc.nextInt();
        sc.nextLine(); // limpar buffer

        // Enviar tudo para o sistema
        sistema.registrarInternacao(codigo, preco, cpf, nomePet, dataEntrada, motivo, dias);

        System.out.println("✔ Internação registrada com sucesso!");
    }

}
