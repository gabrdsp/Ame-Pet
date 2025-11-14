package src.br.edu.amepet.gerenciador;

import java.util.ArrayList;
import java.util.List;
import src.br.edu.amepet.modelo.*;
public class GerenciadorPetShop {
    
    // POLIMORFISMO: Lista da Superclasse abstrata (Requisito 4.2)
    private List<Pessoa> pessoas;
    private List<Pet> pets;
    
    //  Construtor do Gerenciador.
    // Inicializa todas as coleções e adiciona dados de exemplo.
    public GerenciadorPetShop() {
        this.pessoas = new ArrayList<>();
        this.pets = new ArrayList<>();
        
        // Inicializa com dados de exemplo
        inicializarDadosExemplo();
    }
    
    // Inicializa o sistema com dados de exemplo para testes.
    private void inicializarDadosExemplo() {
        // Clientes de exemplo
        try {
            Cliente c1 = new Cliente(
                "Bruno",
                "123.456.789-00",
                "(84) 99999-9999",
                "Rua dos Digimons, 123"
            );
            pessoas.add(c1);
            
            Cliente c2 = new Cliente(
                "Alexandre",
                "987.654.321-00",
                "(84) 98888-2222",
                "Av. Principal, 777"
            );
            pessoas.add(c2);
            
            // Funcionários de exemplo
            Funcionario f1 = new Funcionario(
                "Gabriel",
                "111.222.333-44",
                "(84) 97777-3333",
                "Veterinário",
                5000.0,
                "01/01/2023"
            );
            pessoas.add(f1);
            
            Funcionario f2 = new Funcionario(
                "Ikaro",
                "555.666.777-88",
                "(84) 96666-4444",
                "Tosador",
                2500.0,
                "15/03/2023"
            );
            pessoas.add(f2);
            
            // Pets de exemplo
            Pet pet1 = new Pet("Zoe", "Cão", "Poodle", 7, 13.0, "123.456.789-00");
            Pet pet2 = new Pet("Kira", "Gato", "Siamês", 3, 4.2, "123.456.789-00");
            Pet pet3 = new Pet("Dante", "Cão", "Husky", 5, 20.5, "987.654.321-00");
            
            pets.add(pet1);
            pets.add(pet2);
            pets.add(pet3);
            
            // Adiciona pets aos clientes
            c1.adicionarPet(pet1);
            c1.adicionarPet(pet2);
            c2.adicionarPet(pet3);

        } catch (Exception e) {
            System.err.println("Erro ao inicializar dados: " + e.getMessage());
        }
    }

// ========== MÉTODOS DE GERENCIAMENTO DE PESSOAS ==========

// Adiciona uma pessoa (Cliente ou Funcionário) ao sistema. 
public void adicionarPessoa(Pessoa pessoa) {
    if (pessoa != null) {
        pessoas.add(pessoa);
    }
}

// Busca uma pessoa pelo CPF.
public Pessoa buscarPessoaPorCpf(String cpf) {
    for (Pessoa p : pessoas) {
        if (p.getCpf().equals(cpf)) {
            return p;
        }
    }
    return null;
}

public Cliente buscarClientePorCpf(String cpf) {
    Pessoa p = buscarPessoaPorCpf(cpf);
    if (p instanceof Cliente) {
        return (Cliente) p;
    }
    return null;
}

public void listarTodasPessoas() {
    System.out.println("LISTAGEM DE TODAS AS PESSOAS (POLIMORFISMO)");
    
    
    if (pessoas.isEmpty()) {
        System.out.println("Nenhuma pessoa cadastrada.");
        return;
    }
    
    // Cada objeto executa sua própria versão de exibirDetalhes()
    // Sem necessidade de verificar se é Cliente ou Funcionário
    for (Pessoa pessoa : pessoas) {
        System.out.println(pessoa.exibirDetalhes());
    }
    
    System.out.println("=".repeat(60));
    System.out.println("Total: " + pessoas.size() + " pessoa(s)");
}

// Lista apenas clientes.
public void listarClientes() {
    System.out.println("\n>>> CLIENTES CADASTRADOS <<<");
    int count = 0;
    for (Pessoa p : pessoas) {
        if (p instanceof Cliente) {
            System.out.println(p.exibirDetalhes());
            count++;
        }
    }
    System.out.println("Total: " + count + " cliente(s)");
}

// Lista apenas funcionários.
public void listarFuncionarios() {
    System.out.println("\n>>> FUNCIONÁRIOS CADASTRADOS <<<");
    int count = 0;
    for (Pessoa p : pessoas) {
        if (p instanceof Funcionario) {
            System.out.println(p.exibirDetalhes());
            count++;
        }
    }
    System.out.println("Total: " + count + " funcionário(s)");
}

// ========== MÉTODOS DE GERENCIAMENTO DE PETS ==========

// Adiciona um pet ao sistema.
public void adicionarPet(Pet pet) {
    if (pet != null) {
        pets.add(pet);
    }
}

// Busca pets de um cliente pelo CPF do dono.
public List<Pet> buscarPetsPorDono(String cpfDono) {
    List<Pet> petsDoDono = new ArrayList<>();
    for (Pet pet : pets) {
        if (pet.getCpfDono().equals(cpfDono)) {
            petsDoDono.add(pet);
        }
    }
    return petsDoDono;
}

public Pet buscarPetPorNome(String nomePet, String cpfDono) {
    for (Pet pet : pets) {
        if (pet.getNome().equalsIgnoreCase(nomePet) && 
            pet.getCpfDono().equals(cpfDono)) {
            return pet;
        }
    }
    return null;
}

// Lista todos os pets cadastrados.
public void listarPets() {
    System.out.println("\n>>> PETS CADASTRADOS <<<");
    if (pets.isEmpty()) {
        System.out.println("Nenhum pet cadastrado.");
        return;
    }
    
    for (Pet pet : pets) {
        System.out.println(pet.exibirInformacoes());
    }
    System.out.println("Total: " + pets.size() + " pet(s)");
}

// ========== GETTERS PARA ACESSO ÀS COLEÇÕES ==========

public List<Pessoa> getPessoas() {
    return new ArrayList<>(pessoas);
}

public List<Pet> getPets() {
    return new ArrayList<>(pets);
}
}
