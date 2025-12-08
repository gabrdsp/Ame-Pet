package br.edu.amepet.menu;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import br.edu.amepet.modelo.produto.Produto;

import java.util.Scanner;

public class MenuLoja {

    public static void exibir(GerenciadorPetShop sistema, Scanner sc) {

        int opcao;
        do {
            mostrarMenuPrincipal();
            opcao = lerOpcao(sc);

            switch (opcao) {
                case 1 -> menuEstoque(sistema, sc);
                case 2 -> menuVendas(sistema, sc);
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // ============================================================================
    //                       MÉTODOS AUXILIARES DE EXIBIÇÃO
    // ============================================================================

    private static void mostrarMenuPrincipal() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║                     MENU LOJA                  ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ 1. Controle de Estoque                         ║");
        System.out.println("║ 2. Processo de Compra/Venda                    ║");
        System.out.println("║ 0. Voltar                                      ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

    private static void mostrarMenuEstoque() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║                 CONTROLE DE ESTOQUE            ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ 1. Listar Produtos                             ║");
        System.out.println("║ 2. Cadastrar Produto                           ║");
        System.out.println("║ 3. Atualizar Preço                             ║");
        System.out.println("║ 4. Remover Produto                             ║");
        System.out.println("║ 0. Voltar                                      ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

    private static void mostrarMenuVendas() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║                 COMPRA / VENDA                 ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ 1. Selecionar Produto                          ║");
        System.out.println("║ 2. Registrar Venda                             ║");
        System.out.println("║ 3. Atualizar Estoque                           ║");
        System.out.println("║ 4. Emitir Recibo                               ║");
        System.out.println("║ 0. Voltar                                      ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

    // ============================================================================
    //                            LEITURA DE OPÇÃO
    // ============================================================================

    private static int lerOpcao(Scanner sc) {
        Integer opcao = CancelarAcao.readIntSafe(sc);
        return (opcao == null) ? 0 : opcao;
    }

    // ============================================================================
    //                             SUBMENU ESTOQUE
    // ============================================================================

    private static void menuEstoque(GerenciadorPetShop sistema, Scanner sc) {

        int opcao;
        do {
            mostrarMenuEstoque();
            opcao = lerOpcao(sc);

            switch (opcao) {
                case 1 -> sistema.listarProdutos();

                case 2 -> cadastrarProduto(sistema, sc);

                case 3 -> atualizarPreco(sistema, sc);

                case 4 -> removerProduto(sistema, sc);

                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private static void cadastrarProduto(GerenciadorPetShop sistema, Scanner sc) {
        System.out.println("---- Cadastro de Produto ----");
        System.out.println("( * ) Cancelar");

        String codigo = CancelarAcao.readLine(sc);
        if (CancelarAcao.isCancelado(codigo)) return;

        String nome = CancelarAcao.readStringSafe(sc, "Nome do Produto");
        if (CancelarAcao.isCancelado(nome)) return;

        String categoria = CancelarAcao.readStringSafe(sc, "Categoria");
        if (CancelarAcao.isCancelado(categoria)) return;

        Double preco = CancelarAcao.readDoubleSafe(sc, "Preço");
        if (preco == null) return;

        Integer estoque = CancelarAcao.readIntSafe(sc, "Quantidade");
        if (estoque == null) return;

        sistema.cadastrarProduto(new Produto(codigo, nome, categoria, preco, estoque));
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void atualizarPreco(GerenciadorPetShop sistema, Scanner sc) {
        String nome = CancelarAcao.readStringSafe(sc, "Nome do produto");
        Double novoPreco = CancelarAcao.readDoubleSafe(sc, "Novo preço");
        if (novoPreco == null) return;

        sistema.atualizarPrecoProduto(nome, novoPreco);
    }

    private static void removerProduto(GerenciadorPetShop sistema, Scanner sc) {
        String nome = CancelarAcao.readStringSafe(sc, "Nome do produto");
        sistema.removerProduto(nome);
    }

    // ============================================================================
    //                             SUBMENU VENDAS
    // ============================================================================

    private static void menuVendas(GerenciadorPetShop sistema, Scanner sc) {

        int opcao;
        do {
            mostrarMenuVendas();
            opcao = lerOpcao(sc);

            switch (opcao) {
                case 1 -> sistema.listarProdutos();
                case 2 -> registrarVenda(sistema, sc);
                case 3 -> atualizarEstoque(sistema, sc);
                case 4 -> sistema.emitirRecibo();
                case 0 -> System.out.println("Voltando...\n");
                default -> System.out.println("Opção inválida!\n");
            }

        } while (opcao != 0);
    }

    private static void registrarVenda(GerenciadorPetShop sistema, Scanner sc) {
        System.out.println("---- Registrar Venda ----");
        System.out.println("( * ) Cancelar");

        String nome = CancelarAcao.readStringSafe(sc, "Nome do produto");
        if (CancelarAcao.isCancelado(nome)) return;

        Integer qtd = CancelarAcao.readIntSafe(sc, "Quantidade vendida");
        if (qtd == null) return;

        sistema.registrarVenda(nome, qtd);
    }

    private static void atualizarEstoque(GerenciadorPetShop sistema, Scanner sc) {
        System.out.println("---- Atualizar Estoque ----");
        System.out.println("( * ) Cancelar");

        String nome = CancelarAcao.readStringSafe(sc, "Nome do produto");
        if (CancelarAcao.isCancelado(nome)) return;

        Integer qtd = CancelarAcao.readIntSafe(sc, "Quantidade adicionada");
        if (qtd == null) return;

        sistema.atualizarEstoque(nome, qtd);
    }
}
