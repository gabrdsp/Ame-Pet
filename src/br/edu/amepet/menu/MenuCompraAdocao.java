package br.edu.amepet.menu;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import br.edu.amepet.modelo.pet.PetAdocao;
import br.edu.amepet.modelo.pet.PetsVenda;
import java.util.Scanner;

public class MenuCompraAdocao {
    private static Scanner scanner = new Scanner(System.in);
    private static GerenciadorPetShop gerenciador = new GerenciadorPetShop();

    public static void exibir(GerenciadorPetShop sistema, Scanner sc) {
        int opcao;
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

        System.out.print("nome: ");
        String nome = scanner.nextLine();

        System.out.print("especie: ");
        String especie = scanner.nextLine();

        System.out.print("raca: ");
        String raca = scanner.nextLine();

        System.out.print("idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("preco: ");
        double preco = Double.parseDouble(scanner.nextLine());

        PetsVenda petVenda = new PetsVenda(nome, especie, raca, idade, preco);
        gerenciador.cadastrarPetVenda(petVenda);
    }

    private static void cadastrarPetAdocao(){
        System.out.println("Cadastrando Pet para Adoção...");

        System.out.print("nome: ");
        String nome = scanner.nextLine();

        System.out.print("especie: ");
        String especie = scanner.nextLine();

        System.out.print("raca: ");
        String raca = scanner.nextLine();

        System.out.print("idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        PetAdocao petAdocao = new PetAdocao(nome, especie, raca, idade);
        gerenciador.cadastrarPetParaAdoção(petAdocao);
    }

    private static void comprarPetsVenda(){
        System.out.println("Comprando Pet para Venda...");
        gerenciador.listarpetsvenda();

        System.out.print("Digite o nome do pet que deseja comprar: ");
        String nome = scanner.nextLine();

        gerenciador.comprarPet(nome);
    }

    private static void adotarPet(){
        System.out.println("Adotando Pet...");
        gerenciador.listarPetsadocao();

        System.out.print("Digite o nome do pet que deseja adotar: ");
        String nome = scanner.nextLine();

        gerenciador.adotarPet(nome);
    }
}
