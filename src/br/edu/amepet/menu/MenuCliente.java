package br.edu.amepet.menu;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;
import java.util.Scanner;

public class MenuCliente {
    public static void exibir(GerenciadorPetShop sistema, Scanner sc) {
        int opcao;

        do{
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║                  MENU CLIENTE                  ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Cadastro de Cliente                         ║");
            System.out.println("║ 2. Cadastro de Pet                             ║");
            System.out.println("║ 3. Serviços do Petshop                         ║");
            System.out.println("║ 4. Histórico do Pet                            ║");
            System.out.println("║ 5. Comprar ou adotar Pets                      ║");
            System.out.println("║ 0. Voltar                                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> menuCadastroCliente(sistema, sc);
                case 2 -> menuCadastroPet(sistema, sc);
                case 3 -> MenuServicos.exibir(sistema, sc);
                case 4 -> MenuHistorico.exibir(sistema, sc);
                case 5 -> MenuCompraAdocao.exibir(sistema, sc);
                case 0 -> System.out.println("Voltando ao menu anterior...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
    }

    private static void menuCadastroCliente(GerenciadorPetShop sistema, Scanner sc) {
        int opcao;

        do {
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║             CADASTRO DO CLIENTE                ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Cadastrar Cliente                           ║");
            System.out.println("║ 2. Lista Clientes                              ║");
            System.out.println("║ 3. Remover Cliente                             ║");
            System.out.println("║ 0. Voltar                                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("---- Cadastro do Cliente ----");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();

                    Cliente c = new Cliente(nome, cpf, telefone, endereco);
                    sistema.adicionarCliente(c);

                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("---- Lista de Clientes ----");
                    sistema.listarClientes();
                    break;
                case 3:
                    System.out.println("---- Remover Cliente ----");
                    System.out.println("CPF do cliente: ");
                    String cpfRemover = sc.nextLine();

                    sistema.removerCliente(cpfRemover);
                    break;
                case 0:
                    System.out.println("Voltando ao menu anterior...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
           
        } while (opcao != 0);
    }

    private static void menuCadastroPet(GerenciadorPetShop sistema, Scanner sc) {
        int opcao;

        do {
            System.out.print("\n");
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║                CADASTRO DE PET                 ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1. Cadastrar Pet                               ║");
            System.out.println("║ 2. Listar Pets                                 ║");
            System.out.println("║ 3. Remover Pet                                 ║");
            System.out.println("║ 0. Voltar                                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n---- Cadastro do Pet ----");

                    System.out.print("Nome do Pet: ");
                    String nomePet = sc.nextLine();

                    System.out.print("Espécie: ");
                    String especie = sc.nextLine();

                    System.out.print("Raça: ");
                    String raca = sc.nextLine();

                    System.out.print("Idade (anos): ");
                    int idade = Integer.parseInt(sc.nextLine());

                    System.out.print("Peso (kg): ");
                    double peso = Double.parseDouble(sc.nextLine());

                    System.out.print("CPF do Dono: ");
                    String cpfDono = sc.nextLine();

                    Pet pet = new Pet(nomePet, especie, raca, idade, peso, cpfDono);
                    sistema.adicionarPet(cpfDono, pet);

                    System.out.println("Pet cadastrado com sucesso!\n");
                    break;

                case 2:
                    System.out.println("\n---- Lista de Pets ----");
                    sistema.listarPets();
                    break;
                case 3:
                    System.out.println("---- Remover Pet ----");
                    System.out.print("CPF do dono do pet: ");
                    String cpf = sc.nextLine();

                    System.out.print("Nome do pet a remover: ");
                    String nomePetR = sc.nextLine();

                    sistema.removerPet(cpf, nomePetR);
                    break;
                case 0:
                    System.out.println("Voltando ao menu anterior...\n");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
            }

        } while (opcao != 0);
    }
}
