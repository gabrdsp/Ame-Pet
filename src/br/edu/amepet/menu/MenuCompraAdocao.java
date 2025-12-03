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
        // Guarda referências do sistema e do scanner recebidos
        sistemaAtual = sistema;
        scanner = sc;
        int op;
        // Loop do menu: volta após cada operação até escolher 0
        do {
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║            MENU COMPRAR / ADOTAR PETS          ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Cadastrar Pets para Compra                  ║");
            System.out.println("║ 2. Cadastrar Pets para Adoção                  ║");
            System.out.println("║ 3. Comprar Pets                                ║");
            System.out.println("║ 4. Adotar Pets                                 ║");
            System.out.println("║ 0. Voltar                                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
            op = lerOpcao();

            switch(op){
                case 1:
                    // Cadastra pet disponível para compra
                    cadastrarPetVenda();
                    break;
                case 2:
                    // Cadastra pet disponível para adoção
                    cadastrarPetAdocao();
                    break;
                case 3:
                    // Realiza compra de um pet já cadastrado para venda
                    comprarPetsVenda();
                    break;
                case 4:
                    // Realiza adoção de um pet já cadastrado para adoção
                    adotarPet();
                    break;
                case 0:
                    System.out.println("Voltando ao menu anterior...\n");
                    break;
                default:
                    System.out.println("Opção inválida!\n");
            }
        } while (op != 0);
    }

    private static int lerOpcao() {
        // Tenta converter a entrada para número; retorna -1 em caso de erro
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public static void cadastrarPetVenda(){
        // Fluxo de cadastro de pet para venda
        System.out.println("Cadastrando Pet para Venda...");
        System.out.println("( * ) Cancelar");

        String nome = CancelarAcao.readStringSafe(scanner, "Nome");
        if (nome == null || CancelarAcao.isCancelado(nome)) { System.out.println("Cadastro cancelado."); return; }

        String especie = CancelarAcao.readStringSafe(scanner, "Especie");
        if (CancelarAcao.isCancelado(especie)) { System.out.println("Cadastro cancelado."); return; }

        String raca = CancelarAcao.readStringSafe(scanner, "Raca");
        if (CancelarAcao.isCancelado(raca)) { System.out.println("Cadastro cancelado."); return; }

        Integer idade = CancelarAcao.readIntSafe(scanner, "Idade");
        if (idade == null) { System.out.println("Cadastro cancelado."); return; }

        Double preco = CancelarAcao.readDoubleSafe(scanner, "Preco");
        if (preco == null) { System.out.println("Cadastro cancelado."); return; }

        PetsVenda petVenda = new PetsVenda(nome, especie, raca, idade, preco);
        sistemaAtual.cadastrarPetVenda(petVenda);
    }

    private static void cadastrarPetAdocao(){
        // Fluxo de cadastro de pet para adoção
        System.out.println("Cadastrando Pet para Adoção...");
        System.out.println("( * ) Cancelar");

        String nome = CancelarAcao.readStringSafe(scanner, "Nome");
        if (nome == null || CancelarAcao.isCancelado(nome)) { System.out.println("Cadastro cancelado."); return; }

        String especie = CancelarAcao.readStringSafe(scanner, "Espécie");
        if (CancelarAcao.isCancelado(especie)) { System.out.println("Cadastro cancelado."); return; }

        String raca = CancelarAcao.readStringSafe(scanner, "Raça");
        if (CancelarAcao.isCancelado(raca)) { System.out.println("Cadastro cancelado."); return; }

        Integer idade = CancelarAcao.readIntSafe(scanner, "Idade");
        if (idade == null) { System.out.println("Cadastro cancelado."); return; }

        PetAdocao petAdocao = new PetAdocao(nome, especie, raca, idade);
        sistemaAtual.cadastrarPetParaAdoção(petAdocao);
    }

    private static void comprarPetsVenda(){
        // Fluxo de compra de pet (aplica desconto/taxa pela forma de pagamento)
        System.out.println("Comprando Pet para Venda...");
        sistemaAtual.listarpetsvenda();
        System.out.println("( * ) Cancelar");

        String nome = CancelarAcao.readStringSafe(scanner, "Digite o nome do pet que deseja comprar");
        if (CancelarAcao.isCancelado(nome)) { System.out.println("Operação cancelada."); return; }

        PetsVenda pet = sistemaAtual.obterPetVendaPorNome(nome);
        if (pet == null) {
            System.out.println("Pet não encontrado.");
            return;
        }

        System.out.printf("Preço do pet: R$%.2f%n", pet.getPreco());
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║          ESCOLHA A FORMA DE PAGAMENTO          ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ 1. Pix (5% desconto)                           ║");
        System.out.println("║ 2. Dinheiro (10% desconto)                     ║");
        System.out.println("║ 3. Cartão Débito (2% taxa)                     ║");
        System.out.println("║ 4. Cartão Crédito (4.5% taxa)                  ║");
        System.out.println("╚════════════════════════════════════════════════╝");
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

        String cpf = CancelarAcao.readDigitsSafe(scanner, "Digite o CPF do comprador");
        if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); return; }

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
        // Fluxo de adoção de pet
        System.out.println("Adotando Pet...");
        sistemaAtual.listarPetsadocao();
        System.out.println("( * ) Cancelar");

        String nomePet = CancelarAcao.readStringSafe(scanner, "Digite o nome do pet que deseja adotar");
        if (CancelarAcao.isCancelado(nomePet)) { System.out.println("Operação cancelada."); return; }

        // Formulário de adoção
        System.out.println("\n==== FORMULÁRIO DE ADOÇÃO ====");
        System.out.println("Por favor, preencha as informações abaixo:");
        
        String nomeAdotante = CancelarAcao.readStringSafe(scanner, "Nome completo do adotante");
        if (CancelarAcao.isCancelado(nomeAdotante)) { System.out.println("Operação cancelada."); return; }
        
        String cpf = CancelarAcao.readDigitsSafe(scanner, "CPF");
        if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); return; }
        
        String telefone = CancelarAcao.readDigitsSafe(scanner, "Telefone");
        if (CancelarAcao.isCancelado(telefone)) { System.out.println("Operação cancelada."); return; }
        
        String endereco = CancelarAcao.readLineSafe(scanner, "Endereço completo");
        if (CancelarAcao.isCancelado(endereco)) { System.out.println("Operação cancelada."); return; }
        
        Double renda = CancelarAcao.readDoubleSafe(scanner, "Renda mensal (R$)");
        if (renda == null) { System.out.println("Operação cancelada."); return; }
        
        String temOutrosPets = CancelarAcao.readLineSafe(scanner, "Possui outros pets em casa? (sim/não)");
        if (CancelarAcao.isCancelado(temOutrosPets)) { System.out.println("Operação cancelada."); return; }
        
        String motivoAdocao = CancelarAcao.readLineSafe(scanner, "Motivo da adoção");
        if (CancelarAcao.isCancelado(motivoAdocao)) { System.out.println("Operação cancelada."); return; }

        // Confirmação
        System.out.println("\n==== RESUMO DA ADOÇÃO ====");
        System.out.println("Pet: " + nomePet);
        System.out.println("Adotante: " + nomeAdotante);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
        System.out.printf("Renda mensal: R$%.2f%n", renda);
        System.out.println("Possui outros pets: " + temOutrosPets);
        System.out.println("Motivo: " + motivoAdocao);
        
        System.out.print("\nConfirmar adoção? (s/n): ");
        String confirma = scanner.nextLine();
        
        if (confirma.equalsIgnoreCase("s")) {
            sistemaAtual.adotarPet(nomePet, nomeAdotante, cpf, telefone, endereco, renda, temOutrosPets, motivoAdocao);
        } else {
            System.out.println("Adoção cancelada.");
        }
    }
}
