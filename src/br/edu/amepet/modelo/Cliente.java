package src.br.edu.amepet.modelo;

import java.util.ArrayList;
import java.util.List;

// Classe Cliente - Subclasse de Pessoa.
// Demonstra HERANÇA e POLIMORFISMO.
// Representa um cliente do PetShop com seus pets e histórico.

public class Cliente extends Pessoa {
    
    // ENCAPSULAMENTO: Atributos específicos privados
    private String endereco;
    private List<Pet> pets;
    
    // Construtor completo do Cliente.
    public Cliente(String nome, String cpf, String telefone, String endereco) {
        super(nome, cpf, telefone); // Chama construtor da superclasse
        this.setEndereco(endereco);
        this.pets = new ArrayList<>();
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio!");
        }
        this.endereco = endereco.trim();
    }
    
    public List<Pet> getPets() {
        return new ArrayList<>(pets); // Retorna cópia para proteger encapsulamento
    }
    
    public void adicionarPet(Pet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("Pet não pode ser nulo!");
        }
        this.pets.add(pet);
    }

    // Implementação do método abstrato da superclasse.
    // Demonstra POLIMORFISMO - cada subclasse implementa de forma diferente.
    
    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔════════════════════════════════════════════════╗\n");
        sb.append("║            DETALHES DO CLIENTE                 ║\n");
        sb.append("╠════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ %s\n", getInfoBasica()));
        sb.append(String.format("║ Endereço: %s\n", endereco));
        sb.append(String.format("║ Quantidade de Pets: %d\n", pets.size()));
        sb.append("╚════════════════════════════════════════════════╝\n");
        return sb.toString();
    }
}