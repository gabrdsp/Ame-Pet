package br.edu.amepet.menu;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import br.edu.amepet.modelo.pagamento.CartaoCredito;
import br.edu.amepet.modelo.pagamento.CartaoDebito;
import br.edu.amepet.modelo.pagamento.Dinheiro;
import br.edu.amepet.modelo.pagamento.FormaDePagamento;
import br.edu.amepet.modelo.pagamento.Pix;
import br.edu.amepet.modelo.pet.PetAdocao;
import br.edu.amepet.modelo.pet.PetsVenda;
import java.util.Scanner;

public class MenuCompraAdocao {
    private static Scanner scanner = new Scanner(System.in);
    private static GerenciadorPetShop sistemaAtual;

    public static void exibir(GerenciadorPetShop sistema, Scanner sc) {
        int opcao;
        // use the GerenciadorPetShop and Scanner passed from Main
        sistemaAtual = sistema;
        scanner = sc;
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║                  MENU CLIENTE                  ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Cadastrar Pets para Compra                  ║");
            System.out.println("║ 2. Cadastrar Pets para Adoção                  ║");
            System.out.println("║ 3. Comprar Pets                                ║");
            System.out.println("║ 4. Adotar Pets                                 ║");
            System.out.println("║ 0. Voltar                                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
            int op = lerOpcao();

            switch(op){
                case 1:
                    cadastrarPetVenda();
                    break;
                case 2:
                    cadastrarPetAdocao();
                    break;
                case 3:
                    comprarPetsVenda();
                    break;
                case 4:
                    adotarPet();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public static void cadastrarPetVenda(){
        System.out.println("Cadastrando Pet para Venda...");
        System.out.print("Nome (ou '!sair' para cancelar): ");
        String nome = CancelarAcao.readLineAllowExit(scanner);
        if (nome == null) { System.out.println("Cadastro cancelado."); return; }

        System.out.print("Especie (ou '!sair' para cancelar): ");
        String especie = CancelarAcao.readLineAllowExit(scanner);
        if (especie == null) { System.out.println("Cadastro cancelado."); return; }

        System.out.print("Raca (ou '!sair' para cancelar): ");
        String raca = CancelarAcao.readLineAllowExit(scanner);
        if (raca == null) { System.out.println("Cadastro cancelado."); return; }

        System.out.print("Idade (ou '!sair' para cancelar): ");
        Integer idadeObj = CancelarAcao.readIntAllowExit(scanner);
        if (idadeObj == null) { System.out.println("Cadastro cancelado ou idade inválida."); return; }
        int idade = idadeObj;

        System.out.print("Preco (ou '!sair' para cancelar): ");
        Double precoObj = CancelarAcao.readDoubleAllowExit(scanner);
        if (precoObj == null) { System.out.println("Cadastro cancelado ou preço inválido."); return; }
        double preco = precoObj;

        PetsVenda petVenda = new PetsVenda(nome, especie, raca, idade, preco);
        sistemaAtual.cadastrarPetVenda(petVenda);
    }

    private static void cadastrarPetAdocao(){
        System.out.println("Cadastrando Pet para Adoção...");
        System.out.print("Nome (ou '!sair' para cancelar): ");
        String nome = CancelarAcao.readLineAllowExit(scanner);
        if (nome == null) { System.out.println("Cadastro cancelado."); return; }

        System.out.print("Espécie (ou '!sair' para cancelar): ");
        String especie = CancelarAcao.readLineAllowExit(scanner);
        if (especie == null) { System.out.println("Cadastro cancelado."); return; }

        System.out.print("Raça (ou '!sair' para cancelar): ");
        String raca = CancelarAcao.readLineAllowExit(scanner);
        if (raca == null) { System.out.println("Cadastro cancelado."); return; }

        System.out.print("Idade (ou '!sair' para cancelar): ");
        Integer idadeObj = CancelarAcao.readIntAllowExit(scanner);
        if (idadeObj == null) { System.out.println("Cadastro cancelado ou idade inválida."); return; }
        int idade = idadeObj;

        PetAdocao petAdocao = new PetAdocao(nome, especie, raca, idade);
        sistemaAtual.cadastrarPetParaAdoção(petAdocao);
    }

    private static void comprarPetsVenda(){
        System.out.println("Comprando Pet para Venda...");
        sistemaAtual.listarpetsvenda();
        System.out.print("Digite o nome do pet que deseja comprar (ou '!sair' para voltar): ");
        String nome = CancelarAcao.readLineAllowExit(scanner);
        if (nome == null) { System.out.println("Operação cancelada."); return; }

        PetsVenda pet = sistemaAtual.obterPetVendaPorNome(nome);
        if (pet == null) {
            System.out.println("Pet não encontrado.");
            return;
        }

        System.out.printf("Preço do pet: R$%.2f%n", pet.getPreco());
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1 - Pix (5% desconto)");
        System.out.println("2 - Dinheiro (10% desconto)");
        System.out.println("3 - Cartão Débito (2% taxa)");
        System.out.println("4 - Cartão Crédito (4.5% taxa)");
        System.out.print("Opção: ");
        int opc = lerOpcao();

        FormaDePagamento forma;
        switch (opc) {
            case 1: forma = new Pix(); break;
            case 2: forma = new Dinheiro(); break;
            case 3: forma = new CartaoDebito(); break;
            case 4: forma = new CartaoCredito(); break;
            default:
                System.out.println("Opção inválida. Operação cancelada.");
                return;
        }

        double valorFinal = forma.calcularValorFinal(pet.getPreco());
        System.out.printf("Valor final a pagar: R$%.2f%n", valorFinal);

        System.out.print("Digite o CPF do comprador (ou '!sair' para cancelar): ");
        String cpf = CancelarAcao.readLineAllowExit(scanner);
        if (cpf == null) { System.out.println("Operação cancelada."); return; }

        String formaStr;
        switch (opc) {
            case 1: formaStr = "PIX"; break;
            case 2: formaStr = "Dinheiro"; break;
            case 3: formaStr = "Cartao Debito"; break;
            case 4: formaStr = "Cartao Credito"; break;
            default: formaStr = "Desconhecida"; break;
        }

        System.out.print("Confirmar compra? (s/n): ");
        String confirma = scanner.nextLine();
        if (confirma.equalsIgnoreCase("s")) {
            sistemaAtual.comprarPetComVenda(nome, cpf, formaStr, valorFinal);
            System.out.println("Pagamento realizado. Obrigado pela compra!");
        } else {
            System.out.println("Compra cancelada.");
        }
    }

    private static void adotarPet(){
        System.out.println("Adotando Pet...");
        sistemaAtual.listarPetsadocao();
        System.out.print("Digite o nome do pet que deseja adotar (ou '!sair' para voltar): ");
        String nome = CancelarAcao.readLineAllowExit(scanner);
        if (nome == null) { System.out.println("Operação cancelada."); return; }

        sistemaAtual.adotarPet(nome);
    }
}
