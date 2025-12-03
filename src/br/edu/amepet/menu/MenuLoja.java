package br.edu.amepet.menu;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import br.edu.amepet.modelo.produto.Produto;
import java.util.Scanner;

public class MenuLoja {

    public static void exibir(GerenciadorPetShop sistema, Scanner sc) {

        int opcao;

        do {
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║                     MENU LOJA                  ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Controle de Estoque                         ║");
            System.out.println("║ 2. Processo de Compra/Venda                    ║");
            System.out.println("║ 0. Voltar                                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            Integer opcObj = CancelarAcao.readIntSafe(sc);
            opcao = (opcObj == null) ? 0 : opcObj;

            switch (opcao) {
                case 1 -> menuEstoque(sistema, sc);
                case 2 -> menuVendas(sistema, sc);
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // ============================================================================
    //                             SUBMENU ESTOQUE
    // ============================================================================
    private static void menuEstoque(GerenciadorPetShop sistema, Scanner sc) {

        int opcao;

        do {
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

            Integer opcObj2 = CancelarAcao.readIntSafe(sc);
            opcao = (opcObj2 == null) ? 0 : opcObj2;

            switch (opcao) {

                case 1 -> sistema.listarProdutos();

                case 2 -> {
                    System.out.println("---- Cadastro de Produto ----");
                    System.out.println("( * ) Cancelar");

                    String codigo = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(codigo)) { System.out.println("Cadastro cancelado."); break; }

                    String nome = CancelarAcao.readStringSafe(sc, "Nome do Produto");
                    if (CancelarAcao.isCancelado(nome)) { System.out.println("Cadastro cancelado."); break; }

                    String categoria = CancelarAcao.readStringSafe(sc, "Categoria");
                    if (CancelarAcao.isCancelado(categoria)) { System.out.println("Cadastro cancelado."); break; }

                    Double preco = CancelarAcao.readDoubleSafe(sc, "Preço");
                    if (preco == null) { System.out.println("Cadastro cancelado."); break; }

                    Integer quantidadeEstoque = CancelarAcao.readIntSafe(sc, "Quantidade");
                    if (quantidadeEstoque == null) { System.out.println("Cadastro cancelado."); break; }

                    Produto p = new Produto(codigo, nome, categoria, preco, quantidadeEstoque);

                    sistema.cadastrarProduto(p);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                }

                case 3 -> {
                    String nome = CancelarAcao.readStringSafe(sc, "Nome do produto");

                    Double preco = CancelarAcao.readDoubleSafe(sc, "Novo preço");
                    if (preco == null) { System.out.println("Operação cancelada."); break; }

                    sistema.atualizarPrecoProduto(nome, preco);
                    break;
                }

                case 4 -> {
                    String nome = CancelarAcao.readStringSafe(sc, "Nome do produto");

                    sistema.removerProduto(nome);
                    break;
                }

                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // ============================================================================
    //                           SUBMENU VENDAS
    // ============================================================================
    private static void menuVendas(GerenciadorPetShop sistema, Scanner sc) {
        int opcao;

        do {
            System.out.print("\n");
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║                 COMPRA / VENDA                 ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Selecionar Produto                          ║");
            System.out.println("║ 2. Registrar Venda                              ║");
            System.out.println("║ 3. Atualizar Estoque                           ║");
            System.out.println("║ 4. Emitir Recibo                               ║");
            System.out.println("║ 0. Voltar                                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            Integer opcObj3 = CancelarAcao.readIntSafe(sc);
            opcao = (opcObj3 == null) ? 0 : opcObj3;

            switch (opcao) {

                case 1 -> sistema.listarProdutos();

                case 2 -> {
                    System.out.println("---- Registrar Venda ----");
                    System.out.println("( * ) Cancelar");

                    String nomeProduto = CancelarAcao.readStringSafe(sc, "Nome do produto");
                    if (CancelarAcao.isCancelado(nomeProduto)) { System.out.println("Operação cancelada."); break; }

                    Integer qtd = CancelarAcao.readIntSafe(sc, "Quantidade vendida");
                    if (qtd == null) { System.out.println("Operação cancelada."); break; }

                    sistema.registrarVenda(nomeProduto, qtd);
                    break;
                }

                case 3 -> {
                    System.out.println("---- Atualizar Estoque ----");
                    System.out.println("( * ) Cancelar");

                    String nomeProduto = CancelarAcao.readStringSafe(sc, "Nome do produto");
                    if (CancelarAcao.isCancelado(nomeProduto)) { System.out.println("Operação cancelada."); break; }

                    Integer qtd2 = CancelarAcao.readIntSafe(sc, "Quantidade adicionada");
                    if (qtd2 == null) { System.out.println("Operação cancelada."); break; }

                    sistema.atualizarEstoque(nomeProduto, qtd2);
                    break;
                }

                case 4 -> sistema.emitirRecibo();

                case 0 -> System.out.println("Voltando...\n");
                default -> System.out.println("Opção inválida!\n");

            }

        } while (opcao != 0);
    }
}
