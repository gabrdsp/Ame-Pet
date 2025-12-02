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
            sc.nextLine();

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
                    System.out.println("( * ) Cancelar");

                    System.out.print("Nome: ");
                    String nome = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(nome)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("CPF: ");
                    String cpf = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(cpf)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Telefone: ");
                    String telefone = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(telefone)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Endereço: ");
                    String endereco = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(endereco)) { System.out.println("Cadastro cancelado."); break; }

                    Cliente c = new Cliente(nome, cpf, telefone, endereco);
                    sistema.adicionarCliente(c);

                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("---- Lista de Clientes ----");
                    sistema.listarClientes();
                    break;
                case 3:
                    System.out.println("---- Remover Cliente ---");
                    System.out.println("( * ) Cancelar");
                    System.out.print("CPF do cliente: ");
                    String cpfRemover = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(cpfRemover)) { System.out.println("Operação cancelada."); break; }

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
                    System.out.println("( * ) Cancelar");

                    System.out.print("Nome do Pet: ");
                    String nomePet = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(nomePet)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Espécie: ");
                    String especie = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(especie)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Raça: ");
                    String raca = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(raca)) { System.out.println("Cadastro cancelado."); break; }

                    System.out.print("Idade (anos): ");
                    String idadeStr = CancelarAcao.readInt(sc);
                    if (CancelarAcao.isCancelado(idadeStr)) { System.out.println("Cadastro cancelado."); break; }
                    int idade = Integer.parseInt(idadeStr);

                    System.out.print("Peso (kg): ");
                    String pesoStr = CancelarAcao.readDouble(sc);
                    if (CancelarAcao.isCancelado(pesoStr)) { System.out.println("Cadastro cancelado."); break; }
                    double peso = Double.parseDouble(pesoStr);

                    String cpfDono;
                    while (true) {
                        System.out.print("CPF do Dono: ");
                        cpfDono = CancelarAcao.readLine(sc);
                        if (CancelarAcao.isCancelado(cpfDono)) { System.out.println("Cadastro cancelado."); break; }
                        if (sistema.buscarClientePorCpf(cpfDono) != null) break;
                        System.out.println("Cliente não encontrado. Digite um CPF cadastrado ou * para cancelar.");
                    }
                    if (CancelarAcao.isCancelado(cpfDono)) break;

                    Pet pet = new Pet(nomePet, especie, raca, idade, peso, cpfDono);
                    sistema.adicionarPet(cpfDono, pet);

                    System.out.println("Pet cadastrado com sucesso!\n");
                    break;

                case 2:
                    System.out.println("\n---- Lista de Pets ----");
                    sistema.listarPets();
                    break;
                case 3:
                    System.out.println("---- Remover Pet ---");
                    System.out.println("( * ) Cancelar");
                    System.out.print("CPF do dono do pet: ");
                    String cpf = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(cpf)) { System.out.println("Operação cancelada."); break; }

                    System.out.print("Nome do pet a remover: ");
                    String nomePetR = CancelarAcao.readLine(sc);
                    if (CancelarAcao.isCancelado(nomePetR)) { System.out.println("Operação cancelada."); break; }

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