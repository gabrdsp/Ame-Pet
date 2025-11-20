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

    public String detalhes() {
        return "Nome: " + nome + ", Espécie: " + especie + ", Raça: " + raca + ", Idade: " + idade + " anos, Preço: R$" + preco;
    }
}