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

            Integer opcObj = CancelarAcao.readIntSafe(sc);
            opcao = (opcObj == null) ? 0 : opcObj;

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
        System.out.println("( * ) Cancelar");

        //1. CPF do dono do pet
        String cpf = CancelarAcao.readDigitsSafe(sc, "CPF do dono do pet");
        if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); return; }

        //2. Nome do pet
        String nomePet = CancelarAcao.readStringSafe(sc, "Nome do pet");
        if (CancelarAcao.isCancelado(nomePet)) { System.out.println("Operação cancelada."); return; }

        //3. Código
        System.out.print("Código do Banho: ");
        String codigo = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(codigo)) { System.out.println("Operação cancelada."); return; }

        //4. Preço
        Double preco = CancelarAcao.readDoubleSafe(sc, "Preço do Banho");
        if (preco == null) { System.out.println("Operação cancelada."); return; }

        //5. Data
        System.out.print("Data do procedimento (ex: 2025-12-01): ");
        String data = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(data)) { System.out.println("Operação cancelada."); return; }

        //6. Tipo de banho
        String tipoBanho = CancelarAcao.readStringSafe(sc, "Tipo de banho");
        if (CancelarAcao.isCancelado(tipoBanho)) { System.out.println("Operação cancelada."); return; }

        sistema.registrarBanho(codigo, preco, cpf, nomePet, data, tipoBanho);

        System.out.println("✔ Banho registrado com sucesso!");
    }

    // =============================================================
    //                         TOSA
    // =============================================================
    private static void registrarTosa(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Tosa ---");
        System.out.println("( * ) Cancelar");

        //1. CPF do dono do pet
        String cpf = CancelarAcao.readDigitsSafe(sc, "CPF do dono do pet");
        if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); return; }

        //2. Nome do pet
        String nomePet = CancelarAcao.readStringSafe(sc, "Nome do pet");
        if (CancelarAcao.isCancelado(nomePet)) { System.out.println("Operação cancelada."); return; }

        //3. Código
        System.out.print("Código da Tosa: ");
        String codigo = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(codigo)) { System.out.println("Operação cancelada."); return; }

        //4. Preço
        Double preco = CancelarAcao.readDoubleSafe(sc, "Preço da Tosa");
        if (preco == null) { System.out.println("Operação cancelada."); return; }

        //5. Data
        System.out.print("Data do procedimento (ex: 2025-12-01): ");
        String data = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(data)) { System.out.println("Operação cancelada."); return; }

        //6. Tipo de Tosa
        System.out.print("Tipo de tosa: ");
        String tipoTosa = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(tipoTosa)) { System.out.println("Operação cancelada."); return; }

        //Enviar para o sistema
        sistema.registrarTosa(codigo, preco, cpf, nomePet, data, tipoTosa);
        System.out.println("✔ Tosa registrada com sucesso!");
    }

    // =============================================================
    //                         EXAME
    // =============================================================
    private static void registrarExame(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Exame ---");
        System.out.println("( * ) Cancelar");

        // 1. CPF do dono
        System.out.print("CPF do dono do pet: ");
        String cpf = CancelarAcao.readDigitsSafe(sc);
        if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); return; }

        // 2. Nome do pet
        System.out.print("Nome do pet: ");
        String nomePet = CancelarAcao.readStringSafe(sc);
        if (CancelarAcao.isCancelado(nomePet)) { System.out.println("Operação cancelada."); return; }

        // 3. Código
        System.out.print("Código do exame: ");
        String codigo = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(codigo)) { System.out.println("Operação cancelada."); return; }

        // 4. Preço
        System.out.print("Preço do exame: ");
        Double preco = CancelarAcao.readDoubleSafe(sc);
        if (preco == null) { System.out.println("Operação cancelada."); return; }

        // 5. Data
        System.out.print("Data do exame (ex: 2025-11-26): ");
        String data = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(data)) { System.out.println("Operação cancelada."); return; }

        // 6. Tipo do exame
        System.out.print("Tipo do exame: ");
        String tipoExame = CancelarAcao.readStringSafe(sc);
        if (CancelarAcao.isCancelado(tipoExame)) { System.out.println("Operação cancelada."); return; }

        // Enviar para o sistema
        sistema.registrarExame(codigo, preco, cpf, nomePet, data, tipoExame);

        System.out.println("✔ Exame registrado com sucesso!");
    }

    // =============================================================
    //                         CONSULTA
    // =============================================================
    private static void registrarConsulta(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Consulta ---");
        System.out.println("( * ) Cancelar");

        // 1. CPF do dono
        System.out.print("CPF do dono do pet: ");
        String cpf = CancelarAcao.readDigitsSafe(sc);
        if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); return; }

        // 2. Nome do pet
        System.out.print("Nome do pet: ");
        String nomePet = CancelarAcao.readStringSafe(sc);
        if (CancelarAcao.isCancelado(nomePet)) { System.out.println("Operação cancelada."); return; }

        // 3. Código
        System.out.print("Código da consulta: ");
        String codigo = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(codigo)) { System.out.println("Operação cancelada."); return; }

        // 4. Preço
        System.out.print("Preço da consulta: ");
        Double preco = CancelarAcao.readDoubleSafe(sc);
        if (preco == null) { System.out.println("Operação cancelada."); return; }

        // 5. Data
        System.out.print("Data da consulta (ex: 2025-11-26): ");
        String data = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(data)) { System.out.println("Operação cancelada."); return; }

        // 6. Veterinário
        System.out.print("Nome do veterinário: ");
        String veterinario = CancelarAcao.readStringSafe(sc);
        if (CancelarAcao.isCancelado(veterinario)) { System.out.println("Operação cancelada."); return; }

        // Envia tudo para o sistema
        sistema.registrarConsulta(codigo, preco, cpf, nomePet, data, veterinario);

        System.out.println("✔ Consulta registrada com sucesso!");
    }

    // =============================================================
    //                         VACINA
    // =============================================================
    private static void registrarVacina(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Vacina ---");
        System.out.println("( * ) Cancelar");

        // 1. CPF do dono
        System.out.print("CPF do dono do pet: ");
        String cpf = CancelarAcao.readDigitsSafe(sc);
        if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); return; }

        // 2. Nome do pet
        System.out.print("Nome do pet: ");
        String nomePet = CancelarAcao.readStringSafe(sc);
        if (CancelarAcao.isCancelado(nomePet)) { System.out.println("Operação cancelada."); return; }

        // 3. Código
        System.out.print("Código da vacina: ");
        String codigo = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(codigo)) { System.out.println("Operação cancelada."); return; }

        // 4. Preço
        System.out.print("Preço da vacina: ");
        Double preco = CancelarAcao.readDoubleSafe(sc);
        if (preco == null) { System.out.println("Operação cancelada."); return; }

        // 5. Data
        System.out.print("Data da vacinação (ex: 2025-11-26): ");
        String data = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(data)) { System.out.println("Operação cancelada."); return; }

        // 6. Tipo de vacina
        System.out.print("Tipo da vacina: ");
        String tipoVacina = CancelarAcao.readStringSafe(sc);
        if (CancelarAcao.isCancelado(tipoVacina)) { System.out.println("Operação cancelada."); return; }

        // Envia tudo para o sistema
        sistema.registrarVacina(codigo, preco, cpf, nomePet, data, tipoVacina);

        System.out.println("✔ Vacina registrada com sucesso!");
    }


    // =============================================================
    //                         CIRURGIA
    // =============================================================
    private static void registrarCirurgia(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Cirurgia ---");
        System.out.println("( * ) Cancelar");

        // 1. CPF do dono
        System.out.print("CPF do dono do pet: ");
        String cpf = CancelarAcao.readDigitsSafe(sc);
        if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); return; }

        // 2. Nome do pet
        System.out.print("Nome do pet: ");
        String nomePet = CancelarAcao.readStringSafe(sc);
        if (CancelarAcao.isCancelado(nomePet)) { System.out.println("Operação cancelada."); return; }

        // 3. Código da cirurgia
        System.out.print("Código da cirurgia: ");
        String codigo = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(codigo)) { System.out.println("Operação cancelada."); return; }

        // 4. Preço
        System.out.print("Preço da cirurgia: ");
        Double preco = CancelarAcao.readDoubleSafe(sc);
        if (preco == null) { System.out.println("Operação cancelada."); return; }

        // 5. Data
        System.out.print("Data da cirurgia (ex: 2025-11-26): ");
        String data = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(data)) { System.out.println("Operação cancelada."); return; }

        // 6. Nome do procedimento / tipo de cirurgia
        System.out.print("Procedimento realizado: ");
        String procedimento = CancelarAcao.readStringSafe(sc);
        if (CancelarAcao.isCancelado(procedimento)) { System.out.println("Operação cancelada."); return; }

        // 7. Duração (horas)
        System.out.print("Duração da cirurgia (em horas): ");
        Integer duracaoHoras = CancelarAcao.readIntSafe(sc);
        if (duracaoHoras == null) { System.out.println("Operação cancelada."); return; }

        // Enviar tudo para o sistema
        sistema.registrarCirurgia(codigo, preco, cpf, nomePet, data, procedimento, duracaoHoras);

        System.out.println("✔ Cirurgia registrada com sucesso!");
    }


    // =============================================================
    //                         INTERNAÇÃO
    // =============================================================
    private static void registrarInternacao(GerenciadorPetShop sistema, Scanner sc) {

        System.out.println("---- Registro de Internação ---");
        System.out.println("( * ) Cancelar");

        // 1. CPF do dono
        System.out.print("CPF do dono do pet: ");
        String cpf = CancelarAcao.readDigitsSafe(sc);
        if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); return; }

        // 2. Nome do pet
        System.out.print("Nome do pet: ");
        String nomePet = CancelarAcao.readStringSafe(sc);
        if (CancelarAcao.isCancelado(nomePet)) { System.out.println("Operação cancelada."); return; }

        // 3. Código
        System.out.print("Código da internação: ");
        String codigo = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(codigo)) { System.out.println("Operação cancelada."); return; }

        // 4. Preço
        System.out.print("Preço da internação: ");
        Double preco = CancelarAcao.readDoubleSafe(sc);
        if (preco == null) { System.out.println("Operação cancelada."); return; }

        // 5. Data de entrada
        System.out.print("Data de entrada (ex: 2025-11-26): ");
        String dataEntrada = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(dataEntrada)) { System.out.println("Operação cancelada."); return; }

        // 6. Motivo da internação
        System.out.print("Motivo da internação: ");
        String motivo = CancelarAcao.readStringSafe(sc);
        if (CancelarAcao.isCancelado(motivo)) { System.out.println("Operação cancelada."); return; }

        // 7. Dias internado
        System.out.print("Quantidade de dias internado: ");
        Integer dias = CancelarAcao.readIntSafe(sc);
        if (dias == null) { System.out.println("Operação cancelada."); return; }

        // Enviar tudo para o sistema
        sistema.registrarInternacao(codigo, preco, cpf, nomePet, dataEntrada, motivo, dias);

        System.out.println("✔ Internação registrada com sucesso!");
    }

}
