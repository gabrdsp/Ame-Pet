package src.br.edu.amepet.modelo;
public class Pet {

    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private double peso;
    private String cpfDono;

    public Pet(String nome, String especie, String raca, int idade, double peso, String cpfDono) {
        this.setNome(nome);
        this.setEspecie(especie);
        this.setRaca(raca);
        this.setIdade(idade);
        this.setPeso(peso);
        this.setCpfDono(cpfDono);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do pet não pode ser vazio!");
        }
        this.nome = nome.trim();
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        if (especie == null || especie.trim().isEmpty()) {
            throw new IllegalArgumentException("A espécie do pet não pode ser vazio!");
        }
        this.especie = especie.trim();
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        if (raca == null || raca.trim().isEmpty()) {
            throw new IllegalArgumentException("A raça do pet não pode ser vazio!");
        }
        this.raca = raca.trim();
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade do pet não pode ser negativa!");
        }
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("O peso do pet deve ser maior que zero!");
        }
        this.peso = peso;
    }

    public String getCpfDono() {
        return cpfDono;
    }

    public void setCpfDono(String cpfDono) {
        if (cpfDono == null || cpfDono.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF do dono não pode ser vazio!");
        }
        this.cpfDono = cpfDono.trim();
    }

    public String exibirInformacoes() {
        return String.format("Pet: %S | Espécie: %S | Raça: %S | Idade: %d anos | Peso: %.2f kg" , nome, especie, raca, idade, peso);
    }
}
