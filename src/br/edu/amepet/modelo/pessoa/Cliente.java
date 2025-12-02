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
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔════════════════════════════════════════════════╗\n");
        sb.append("║                   CLIENTE                       ║\n");
        sb.append("╠════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Nome: %-40s║\n", getNome()));
        sb.append(String.format("║ CPF: %-41s║\n", getCpf()));
        sb.append(String.format("║ Telefone: %-36s║\n", getTelefone()));
        sb.append(String.format("║ Endereço: %-36s║\n", endereco));
        sb.append(String.format("║ Serviços Contratados: %-26d║\n", totalServicosContratados));
        sb.append("╚════════════════════════════════════════════════╝\n");
        return sb.toString();
    }

    @Override
    public String getTipoPessoa() {
        return "Cliente";
    }
}
