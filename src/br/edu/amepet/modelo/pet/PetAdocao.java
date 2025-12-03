package br.edu.amepet.modelo.pet;

// Representa um pet disponível para adoção
public class PetAdocao {
    private String nome;
    private String especie;
    private String raca;
    private int idade;

    // Construtor: cria um pet para adoção com dados básicos
    public PetAdocao(String nome, String especie, String raca, int idade) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    // Retorna uma representação formatada dos dados do pet para adoção
    public String detalhes() {
                StringBuilder sb = new StringBuilder();
                sb.append("\n╔══════════════════════════════════════════════════════╗\n");
                sb.append("║                  PET PARA ADOÇÃO                      ║\n");
                sb.append("╠══════════════════════════════════════════════════════ ╣\n");
                sb.append(String.format("║ Nome: %s\n", nome));
                sb.append(String.format("║ Espécie: %s\n", especie));
                sb.append(String.format("║ Raça: %s\n", raca));
                sb.append(String.format("║ Idade: %d\n", idade));
                sb.append("╚══════════════════════════════════════════════════════╝\n");
                return sb.toString();
    }
}