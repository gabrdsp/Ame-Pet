package br.edu.amepet.modelo.pet;

public class PetAdocao {
    private String nome;
    private String especie;
    private String raca;
    private int idade;

    public PetAdocao(String nome, String especie, String raca, int idade) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String detalhes() {
        return "| Nome: " + nome + "| Espécie: " + especie + "| Raça: " + raca + "| Idade: " + idade + " anos";
    }
}