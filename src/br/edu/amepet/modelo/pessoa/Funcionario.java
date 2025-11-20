package br.edu.amepet.modelo.pessoa;

//Classe Funcionario - Subclasse de Pessoa.
// Demonstra HERANÇA e POLIMORFISMO.

public class Funcionario extends Pessoa {
    
    // ENCAPSULAMENTO: Atributos específicos privados
    private String cargo;
    private double salario;
    private String dataAdmissao;
    private int servicosRealizados;
    private String usuarioFuncionario;
    private String senhaFuncionario;
    
    // Construtor completo do Funcionário.
    public Funcionario(String nome, String cpf, String telefone, String cargo, double salario, String dataAdmissao, String usuarioFuncionario, String senhaFuncionario) {
        super(nome, cpf, telefone);
        this.setCargo(cargo);
        this.setSalario(salario);
        this.setDataAdmissao(dataAdmissao);
        this.usuarioFuncionario = usuarioFuncionario;
        this.senhaFuncionario = senhaFuncionario;
    }
    
    public String getUsuarioFuncionario()
    { return usuarioFuncionario; }

    public String getSenhaFuncionario()
    { return senhaFuncionario; }

    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("Cargo não pode ser vazio!");
        }
        this.cargo = cargo.trim();
    }
    
    public double getSalario() {
        return salario;
    }
    
    // Define o salário do funcionário.
    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que zero!");
        }
        this.salario = salario;
    }
    
    public String getDataAdmissao() {
        return dataAdmissao;
    }
    
    public void setDataAdmissao(String dataAdmissao) {
        if (dataAdmissao == null || dataAdmissao.trim().isEmpty()) {
            throw new IllegalArgumentException("Data de admissão não pode ser vazia!");
        }
        this.dataAdmissao = dataAdmissao.trim();
    }
    
    public int getServicosRealizados() {
        return servicosRealizados;
    }
    
    public void incrementarServicosRealizados() {
        this.servicosRealizados++;
    }
    
    // Implementação do método abstrato da superclasse.
    @Override
    public String exibirDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔════════════════════════════════════════════════╗\n");
        sb.append("║           DETALHES DO FUNCIONÁRIO              ║\n");
        sb.append("╠════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ %s\n", getInfoBasica()));
        sb.append(String.format("║ Cargo: %s\n", cargo));
        sb.append(String.format("║ Salário: R$ %.2f\n", salario));
        sb.append(String.format("║ Data Admissão: %s\n", dataAdmissao));
        sb.append(String.format("║ Serviços Realizados: %d\n", servicosRealizados));
        sb.append("╚════════════════════════════════════════════════╝\n");
        return sb.toString();
    }

    @Override
    public String getTipoPessoa() {
        return "Funcionário";
    }
}