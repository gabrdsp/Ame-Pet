package br.edu.amepet;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import br.edu.amepet.modelo.atendimento.Cirurgia;
import br.edu.amepet.modelo.atendimento.Consulta;
import br.edu.amepet.modelo.atendimento.Exame;
import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pessoa.Funcionario;
import br.edu.amepet.modelo.pessoa.Pessoa;
import br.edu.amepet.modelo.pet.Pet;
import br.edu.amepet.modelo.produto.Produto.MenuProduto;
import java.util.Scanner;

public class Main {

    private static GerenciadorPetShop gerenciador;
    private static Scanner scanner;
    private static Pessoa usuarioLogado = null;

    public static void main(String[] args) {
        gerenciador = new GerenciadorPetShop();
        scanner = new Scanner(System.in);

        exibirBoasVindas();

        boolean continuar = true;
        while (continuar) {
            exibirMenuPrincipal();
            int opcao = lerOpcao();
            continuar = processarMenuPrincipal(opcao);
        }

        scanner.close();
        System.out.println("\nSistema encerrado. Até logo!");
    }

    // ------------------------------------------------------------
    //  BOAS-VINDAS
    // ------------------------------------------------------------
    private static void exibirBoasVindas() {
        System.out.println("🐾 BEM-VINDO AO AME PET 🐾");
        System.out.println("Sistema de Gerenciamento do PetShop");
    }

    // ------------------------------------------------------------
    //  MENU PRINCIPAL — APENAS 3 OPÇÕES
    // ------------------------------------------------------------
    private static void exibirMenuPrincipal() {
        System.out.println("\n==================== MENU PRINCIPAL ====================");
        System.out.println("1. Login");
        System.out.println("2. Cadastro");
        System.out.println("3. Listagem");
        System.out.println("4. Atendimento (restrito a logados)");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    // ------------------------------------------------------------
    // PROCESSA MENU PRINCIPAL
    // ------------------------------------------------------------
    private static boolean processarMenuPrincipal(int opcao) {
        switch (opcao) {
            case 1 -> menuLogin();
            case 2 -> exibirMenuCadastro();
            case 3 -> exibirMenuListagem();

            case 4 -> {
                if (usuarioLogado == null) {
                    System.out.println("\n⚠ Você precisa estar logado para acessar o menu de atendimento.");
                } else {
                    menuAtendimento(); // já existe no seu código
                }
            }

            case 5 -> {
                return false;
            }

            default -> System.out.println("Opção inválida.");
        }
        return true;
    }

    // ------------------------------------------------------------
    //  MENU DE CADASTRO
    // ------------------------------------------------------------
    private static void exibirMenuCadastro() {
        int opc;

        do {
            System.out.println("\n=========== MENU DE CADASTRO ===========");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Cadastrar Pet");
            System.out.println("4. Comprar Produtos");
            System.out.println("5. Voltar");
            System.out.print("Escolha: ");

            opc = lerOpcao();

            switch (opc) {
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarFuncionario();
                case 3 -> cadastrarPet();
                case 4 -> new MenuProduto(gerenciador, scanner).exibirMenu();
                case 5 -> { return; }
                default -> System.out.println("Opção inválida!");
            }

            pausar();

        } while (opc != 5);
    }

    // ------------------------------------------------------------
    //  MENU DE LISTAGEM
    // ------------------------------------------------------------
    private static void exibirMenuListagem() {
        int opc;

        do {
            System.out.println("\n=========== MENU DE LISTAGEM ===========");
            System.out.println("1. Listar Todos (Polimorfismo)");
            System.out.println("2. Buscar Pessoa por CPF");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Listar Funcionários");
            System.out.println("5. Listar Pets");
            System.out.println("6. Voltar");
            System.out.print("Escolha: ");

            opc = lerOpcao();

            switch (opc) {
                case 1 -> gerenciador.listarTodasPessoas();
                case 2 -> buscarPessoa();
                case 3 -> gerenciador.listarClientes();
                case 4 -> gerenciador.listarFuncionarios();
                case 5 -> gerenciador.listarPets();
                case 6 -> { return; }
                default -> System.out.println("Opção inválida!");
            }

            pausar();

        } while (opc != 6);
    }

    // ------------------------------------------------------------
    //  FUNÇÕES DE CADASTRO
    // ------------------------------------------------------------
    private static void cadastrarCliente() {
        System.out.println("\n>>> CADASTRAR CLIENTE <<<");

        System.out.print("Usuário para login: ");
        String usuario = scanner.nextLine();

        System.out.print("Senha para login: ");
        String senha = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        try {
            Cliente c = new Cliente(nome, cpf, telefone, endereco, usuario, senha);
            gerenciador.adicionarPessoa(c);
            System.out.println("\nCliente cadastrado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n>>> CADASTRAR FUNCIONÁRIO <<<");

        System.out.print("Usuário para login: ");
        String usuario = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        System.out.print("Salário: ");
        double salario = Double.parseDouble(scanner.nextLine());

        System.out.print("Data de Admissão: ");
        String data = scanner.nextLine();

        try {
            Funcionario f = new Funcionario(nome, cpf, telefone, cargo, salario, data, usuario, senha);
            gerenciador.adicionarPessoa(f);
            System.out.println("\nFuncionário cadastrado!");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
    private static void menuLogin() {
        System.out.println("\n=========== LOGIN ===========");

        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        usuarioLogado = gerenciador.login(usuario, senha);

        if (usuarioLogado == null) {
            System.out.println("\n Login falhou. Usuário ou senha inválidos.");
        } else {
            System.out.println("\n✔ Login realizado! Bem-vindo, " + usuarioLogado.getNome());
        }
    }

    private static void menuLoginFuncionario() {
        System.out.println("\n=========== LOGIN ===========");

        System.out.print("Usuário: ");
        String usuarioFuncionario = scanner.nextLine();

        System.out.print("Senha: ");
        String senhaFuncionario = scanner.nextLine();

        usuarioLogado = gerenciador.login(usuarioFuncionario, senhaFuncionario);

        if (usuarioLogado == null) {
            System.out.println("\n Login falhou. Usuário ou senha inválidos.");
        } else {
            System.out.println("\n✔ Login realizado! Bem-vindo, " + usuarioLogado.getNome());
        }
    }
    
private static void menuAtendimento() {
    int opc;

    do {
        System.out.println("\n========= MENU DE ATENDIMENTO =========");
        System.out.println("1. Registrar Consulta");
        System.out.println("2. Registrar Exame");
        System.out.println("3. Registrar Cirurgia");
        System.out.println("4. Listar Atendimentos");
        System.out.println("5. Voltar");
        System.out.print("Escolha: ");

        opc = lerOpcao();

        switch (opc) {
            case 1 -> registrarConsulta();
            case 2 -> registrarExame();
            case 3 -> registrarCirurgia();
            case 4 -> gerenciador.listarAtendimentos();
            case 5 -> { return; }
            default -> System.out.println("Opção inválida!");
        }

        pausar();

    } while (opc != 5);
    }

    private static void registrarConsulta() {
        System.out.println("\n>>> REGISTRAR CONSULTA <<<");
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = gerenciador.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        java.util.List<Pet> pets = gerenciador.buscarPetsPorDono(cpf);
        if (pets.isEmpty()) {
            System.out.println("Este cliente não possui pets cadastrados.");
            return;
        }

        System.out.println("\nPets do cliente:");
        for (int i = 0; i < pets.size(); i++) {
            System.out.println((i + 1) + ". " + pets.get(i).getNome());
        }
        System.out.print("Escolha o pet (número): ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= pets.size()) {
            System.out.println("Pet inválido.");
            return;
        }
        Pet pet = pets.get(idx);

        System.out.print("Data (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        System.out.print("Preço (R$): ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Código do atendimento: ");
        String codigo = scanner.nextLine();
        System.out.print("Veterinário responsável: ");
        String vet = scanner.nextLine();

        Consulta atendimento = new Consulta(codigo, preco, cliente, pet, data, vet);
        gerenciador.adicionarAtendimento(atendimento);
        System.out.println("\nAtendimento registrado com sucesso!");
        System.out.println(atendimento.exibirInformacoes());
    }

    private static void registrarExame() {
        System.out.println("\n>>> REGISTRAR EXAME <<<");
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = gerenciador.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        java.util.List<Pet> pets = gerenciador.buscarPetsPorDono(cpf);
        if (pets.isEmpty()) {
            System.out.println("Este cliente não possui pets cadastrados.");
            return;
        }

        System.out.println("\nPets do cliente:");
        for (int i = 0; i < pets.size(); i++) {
            System.out.println((i + 1) + ". " + pets.get(i).getNome());
        }
        System.out.print("Escolha o pet (número): ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= pets.size()) {
            System.out.println("Pet inválido.");
            return;
        }
        Pet pet = pets.get(idx);

        System.out.print("Data (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        System.out.print("Preço (R$): ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Código do atendimento: ");
        String codigo = scanner.nextLine();
        System.out.print("Tipo de exame: ");
        String tipoExame = scanner.nextLine();

        Exame atendimento = new Exame(codigo, preco, cliente, pet, data, tipoExame);
        gerenciador.adicionarAtendimento(atendimento);
        System.out.println("\nAtendimento registrado com sucesso!");
        System.out.println(atendimento.exibirInformacoes());
    }

    private static void registrarCirurgia() {
        System.out.println("\n>>> REGISTRAR CIRURGIA <<<");
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = gerenciador.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        java.util.List<Pet> pets = gerenciador.buscarPetsPorDono(cpf);
        if (pets.isEmpty()) {
            System.out.println("Este cliente não possui pets cadastrados.");
            return;
        }

        System.out.println("\nPets do cliente:");
        for (int i = 0; i < pets.size(); i++) {
            System.out.println((i + 1) + ". " + pets.get(i).getNome());
        }
        System.out.print("Escolha o pet (número): ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= pets.size()) {
            System.out.println("Pet inválido.");
            return;
        }
        Pet pet = pets.get(idx);

        System.out.print("Data (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        System.out.print("Preço (R$): ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Código do atendimento: ");
        String codigo = scanner.nextLine();
        System.out.print("Procedimento: ");
        String procedimento = scanner.nextLine();
        System.out.print("Duração (horas): ");
        int duracao = Integer.parseInt(scanner.nextLine());

        Cirurgia atendimento = new Cirurgia(codigo, preco, cliente, pet, data, procedimento, duracao);
        gerenciador.adicionarAtendimento(atendimento);
        System.out.println("\nAtendimento registrado com sucesso!");
        System.out.println(atendimento.exibirInformacoes());
    }

    private static void cadastrarPet() {
        System.out.println("\n>>> CADASTRAR PET <<<");

        System.out.print("CPF do Dono: ");
        String cpf = scanner.nextLine();

        Cliente dono = gerenciador.buscarClientePorCpf(cpf);
        if (dono == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.print("Nome do Pet: ");
        String nome = scanner.nextLine();

        System.out.print("Espécie: ");
        String especie = scanner.nextLine();

        System.out.print("Raça: ");
        String raca = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Peso: ");
        double peso = Double.parseDouble(scanner.nextLine());

        try {
            Pet p = new Pet(nome, especie, raca, idade, peso, cpf);
            gerenciador.adicionarPet(p);
            dono.adicionarPet(p);
            System.out.println("\nPet cadastrado!");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    // ------------------------------------------------------------
    // BUSCA
    // ------------------------------------------------------------
    private static void buscarPessoa() {
        System.out.print("\nDigite o CPF: ");
        String cpf = scanner.nextLine();

        Pessoa p = gerenciador.buscarPessoaPorCpf(cpf);

        if (p != null)
            System.out.println(p.exibirDetalhes());
        else
            System.out.println("Pessoa não encontrada.");
    }

    // ------------------------------------------------------------
    // PAUSA
    // ------------------------------------------------------------
    private static void pausar() {
        System.out.print("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}