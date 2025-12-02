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
        return "\n╔════════════════════════════════════════════════╗\n" +
                "║              PET PARA ADOÇÃO                 ║\n" +
                "╠════════════════════════════════════════════════╣\n" +
                String.format("║ Nome: %-40s║\n", nome) +
                String.format("║ Espécie: %-37s║\n", especie) +
                String.format("║ Raça: %-39s║\n", raca) +
                String.format("║ Idade: %-38d║\n", idade) +
                "╚════════════════════════════════════════════════╝\n";
    }
}