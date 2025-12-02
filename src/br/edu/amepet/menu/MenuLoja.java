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
                    System.out.println("( * ) Cancelar");

                    System.out.print("Código do Produto: ");
                    String codigo = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(codigo)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Nome do Produto: ");
                    String nome = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(nome)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Categoria: ");
                    String categoria = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(categoria)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Preço: ");
                    String precoStr = CancelarAcao.readDouble(sc);
                    if (CancelarAcao.isCancelado(precoStr)) { System.out.println("Cadastro cancelado."); break; }
                    double preco = Double.parseDouble(precoStr);

                    System.out.print("Quantidade: ");
                    String qtdStr = CancelarAcao.readInt(sc);
                    if (CancelarAcao.isCancelado(qtdStr)) { System.out.println("Cadastro cancelado."); break; }
                    int quantidadeEstoque = Integer.parseInt(qtdStr);

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
                    System.out.println("---- Registrar Venda ----");
                    System.out.println("( * ) Cancelar");

                    System.out.print("Nome do produto: ");
                    String nomeProduto = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(nomeProduto)) { System.out.println("Operação cancelada."); break; }

                    System.out.print("Quantidade vendida: ");
                    String qtdStr = CancelarAcao.readInt(sc);
                    if (CancelarAcao.isCancelado(qtdStr)) { System.out.println("Operação cancelada."); break; }
                    int qtd = Integer.parseInt(qtdStr);

                    sistema.registrarVenda(nomeProduto, qtd);
                    break;
                }

                case 3 -> {
                    System.out.println("---- Atualizar Estoque ----");
                    System.out.println("( * ) Cancelar");

                    System.out.print("Nome do produto: ");
                    String nomeProduto = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(nomeProduto)) { System.out.println("Operação cancelada."); break; }

                    System.out.print("Quantidade adicionada: ");
                    String qtdStr = CancelarAcao.readInt(sc);
                    if (CancelarAcao.isCancelado(qtdStr)) { System.out.println("Operação cancelada."); break; }
                    int qtd2 = Integer.parseInt(qtdStr);

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
