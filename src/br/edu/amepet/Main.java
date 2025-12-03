package br.edu.amepet;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import br.edu.amepet.menu.*;
import br.edu.amepet.modelo.pessoa.Funcionario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GerenciadorPetShop gerenciador = new GerenciadorPetShop();

        int opcao;
        Funcionario logado = null;

        do {
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║            AME PET - MENU PRINCIPAL            ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Cadastrar Funcionáro                        ║");
            System.out.println("║ 2. Login (Funcionário)                         ║");
            System.out.println("║ 3. Cliente                                     ║");
            System.out.println("║ 4. Loja                                        ║");
            System.out.println("║ 5. Relatórios                                  ║");
            System.out.println("║ 6. Buscar                                      ║");
            System.out.println("║ 0. Sair                                        ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            Integer opcObj = CancelarAcao.readIntSafe(scanner);
            opcao = (opcObj == null) ? 0 : opcObj;

            switch (opcao) {

                case 1:
                    MenuFuncionario.exibir(gerenciador, scanner);
                    break;

                case 2:
                    logado = MenuLogin.exibirLogin(gerenciador, scanner);
                    break;

                case 3:
                    if (logado != null) {
                        MenuCliente.exibir(gerenciador, scanner);
                    } else {
                        System.out.println("Por favor, faça login como funcionário primeiro.\n");
                    }
                    break;

                case 4:
                    if (logado != null) {
                        MenuLoja.exibir(gerenciador, scanner);
                    } else {
                        System.out.println("Por favor, faça login como funcionário primeiro.\n");
                    }
                    break;

                case 5:
                    if (logado != null) {
                        MenuRelatorios.exibir(gerenciador);
                    } else {
                        System.out.println("Por favor, faça login como funcionário primeiro.\n");
                    }
                    break;

                case 6:
                    if (logado != null) {
                        MenuBuscar.exibir(gerenciador, scanner);
                    } else {
                        System.out.println("Por favor, faça login como funcionário primeiro.\n");
                    }
                    break;

                case 0:
                    System.out.println("\nSaindo do sistema. Até logo!");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
