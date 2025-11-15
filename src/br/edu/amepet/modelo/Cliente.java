package src.br.edu.amepet.modelo;

import java.util.ArrayList;
import java.util.List;

// Classe Cliente - Subclasse de Pessoa.
// Demonstra HERANÇA e POLIMORFISMO.
// Representa um cliente do PetShop com seus pets e histórico.

public class Cliente extends Pessoa {
    
    // ENCAPSULAMENTO: Atributos específicos privados
    private String endereco;
    private double saldoCredito;
    private List<Pet> pets;
    private int totalServicosContratados;
    
    // Construtor completo do Cliente.
    public Cliente(String nome, String cpf, String telefone, String endereco) {
        super(nome, cpf, telefone); // Chama construtor da superclasse
        this.setEndereco(endereco);
        this.saldoCredito = 0.0;
        this.pets = new ArrayList<>();
        this.totalServicosContratados = 0;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        if (endereco != null || !endereco.trim().isEmpty()) {
            this.endereco = endereco.trim();
        } else {
            throw new IllegalArgumentException("Endereço não pode ser vazio!");
        }
    }
    
    public double getSaldoDoCliente(){
        return this.saldoCredito;
    }

    public void setSaldoDoCliente(double valor){
        if(valor < 0.0){
            throw new IllegalArgumentException("Saldo não pode ser negativo!");
        } else {
            this.saldoCredito = valor;
        }
    }

    public List<Pet> getPets() {
        return new ArrayList<>(pets); // Retorna cópia para proteger encapsulamento
    }
    
    public void adicionarPet(Pet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("Pet não pode ser nulo!");
        } else {
            this.pets.add(pet);
        }
        
    }

    public int getTotalServicosContratados(){
        return this.totalServicosContratados;
    }

    public void incrementarServicosContratados(){
        ++this.totalServicosContratados;
    }

    public void adicionarCredito(double valor){
        if(valor > 0.0){
            this.saldoCredito += valor;
        }
    }

    public boolean debitarCredito(double valor){
        if(valor > 0.0 && this.saldoCredito >= valor){
            this.saldoCredito -= valor;
            return true;
        } else {
            return false;
        }
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
        sb.append(String.format("║ Saldo de Crédito: R$ %.2f\n", this.saldoCredito));
        sb.append(String.format("║ Quantidade de Pets: %d\n", pets.size()));
        sb.append(String.format("║ Total de Serviços Contratados: %d\n", totalServicosContratados));
        sb.append("╚════════════════════════════════════════════════╝\n");
        return sb.toString();
    }
}