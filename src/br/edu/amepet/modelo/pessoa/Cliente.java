package br.edu.amepet.modelo.pessoa;

public class Cliente extends Pessoa {

    private String endereco;

    // Contagem estatística geral (para relatórios)
    private int totalServicosContratados;

    // ============================
    //       CONSTRUTOR
    // ============================

    public Cliente(String nome, String cpf, String telefone, String endereco) {
        super(nome, cpf, telefone);
        setEndereco(endereco);
        this.totalServicosContratados = 0;
    }

    // ============================
    //       GETTERS E SETTERS
    // ============================

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio!");
        }
        this.endereco = endereco.trim();
    }

    public int getTotalServicosContratados() {
        return totalServicosContratados;
    }

    public void incrementarServicosContratados() {
        this.totalServicosContratados++;
    }

    // ============================
    //         EXIBIR DETALHES
    // ============================

    @Override
    public String exibirDetalhes() {
        return  "\nCliente: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nTelefone: " + getTelefone() +
                "\nEndereço: " + endereco +
                "\nServiços contratados: " + totalServicosContratados + "\n";
    }

    @Override
    public String getTipoPessoa() {
        return "Cliente";
    }
}
