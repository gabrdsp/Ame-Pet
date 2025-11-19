package br.edu.amepet.modelo.pessoa;
public abstract class Pessoa {
    
    // ENCAPSULAMENTO: Atributos privados
    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa(String nome, String cpf, String telefone) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTelefone(telefone);
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        }
        this.nome = nome.trim();
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio!");
        }
        this.cpf = cpf.trim();
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio!");
        }
        this.telefone = telefone.trim();
    }
    
    public abstract String exibirDetalhes();
    
    public String getInfoBasica() {
        return String.format("Nome: %s | CPF: %s | Tel: %s ", nome, cpf, telefone);
    }
}