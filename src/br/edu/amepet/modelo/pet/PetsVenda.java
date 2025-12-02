package br.edu.amepet.modelo.pet;


public class PetsVenda {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private double preco;

    public PetsVenda(String nome, String especie, String raca, int idade, double preco) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String detalhes() {
        return "\n╔════════════════════════════════════════════════╗\n" +
                "║              PET PARA COMPRA                  ║\n" +
                "╠════════════════════════════════════════════════╣\n" +
                String.format("║ Nome: %-40s║\n", nome) +
                String.format("║ Espécie: %-37s║\n", especie) +
                String.format("║ Raça: %-39s║\n", raca) +
                String.format("║ Idade: %-38d║\n", idade) +
                String.format("║ Preço: R$%-33.2f║\n", preco) +
                "╚════════════════════════════════════════════════╝\n";
    }
}