package br.edu.amepet.menu;

import br.edu.amepet.gerenciador.GerenciadorPetShop;

public class MenuRelatorios {

    public static void exibir(GerenciadorPetShop sistema) {
        
        System.out.print("\n");
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║                 MENU RELATÓRIOS                ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ 1. Relatório de Clientes                       ║");
        System.out.println("║ 2. Relatório de Pets                           ║");
        System.out.println("║ 3. Relatório de Serviços                       ║");
        System.out.println("║ 4. Relatório de Vendas                         ║");
        System.out.println("║ 0. Voltar                                      ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        sistema.relatorioClientes();
        sistema.relatorioPets();
        sistema.relatorioServicos();
        sistema.relatorioVendas();
    }
}
