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

            opcao = sc.nextInt();

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

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> sistema.listarProdutos();

                case 2 -> {
                    System.out.println("---- Cadastro de Produto ----");

                    System.out.print("Código do Produto (ou '!sair' para cancelar): ");
                    String codigo = CancelarAcao.readLineAllowExit(sc);
                    if (codigo == null) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Nome do Produto (ou '!sair' para cancelar): ");
                    String nome = CancelarAcao.readLineAllowExit(sc);
                    if (nome == null) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Categoria (ou '!sair' para cancelar): ");
                    String categoria = CancelarAcao.readLineAllowExit(sc);
                    if (categoria == null) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Preço (ou '!sair' para cancelar): ");
                    Double precoObj = CancelarAcao.readDoubleAllowExit(sc);
                    if (precoObj == null) { System.out.println("Cadastro cancelado ou preço inválido."); break; }
                    double preco = precoObj;

                    System.out.print("Quantidade (ou '!sair' para cancelar): ");
                    Integer qtdObj = CancelarAcao.readIntAllowExit(sc);
                    if (qtdObj == null) { System.out.println("Cadastro cancelado ou quantidade inválida."); break; }
                    int quantidadeEstoque = qtdObj;

                    Produto p = new Produto(codigo, nome, categoria, preco, quantidadeEstoque);

                    sistema.cadastrarProduto(p);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                }

                case 3 -> {
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();

                    System.out.print("Novo preço: ");
                    double preco = sc.nextDouble();

                    sistema.atualizarPrecoProduto(nome, preco);
                    break;
                }

                case 4 -> {
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();

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

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> sistema.listarProdutos();

                case 2 -> {
                    System.out.print("Nome do produto (ou '!sair' para cancelar): ");
                    String nomeProduto = CancelarAcao.readLineAllowExit(sc);
                    if (nomeProduto == null) { System.out.println("Operação cancelada."); break; }

                    System.out.print("Quantidade vendida (ou '!sair' para cancelar): ");
                    Integer qtdObj = CancelarAcao.readIntAllowExit(sc);
                    if (qtdObj == null) { System.out.println("Operação cancelada ou quantidade inválida."); break; }
                    int qtd = qtdObj;

                    sistema.registrarVenda(nomeProduto, qtd);
                    break;
                }

                case 3 -> {
                    System.out.print("Nome do produto (ou '!sair' para cancelar): ");
                    String nomeProduto = CancelarAcao.readLineAllowExit(sc);
                    if (nomeProduto == null) { System.out.println("Operação cancelada."); break; }

                    System.out.print("Quantidade adicionada (ou '!sair' para cancelar): ");
                    Integer qtdObj2 = CancelarAcao.readIntAllowExit(sc);
                    if (qtdObj2 == null) { System.out.println("Operação cancelada ou quantidade inválida."); break; }
                    int qtd2 = qtdObj2;

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
