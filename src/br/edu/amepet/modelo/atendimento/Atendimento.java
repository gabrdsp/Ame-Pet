package src.br.edu.amepet.modelo.atendimento;
import src.br.edu.amepet.modelo.pessoa.Cliente;
import src.br.edu.amepet.modelo.pessoa.Funcionario;
import src.br.edu.amepet.modelo.pet.Pet;


public abstract class  Atendimento {
   private String codigoAtendimento;
   private String nome;
   private double precoAtendimento;
   private String cpfCliente;
   private String nomePet;
   private String data;

    public Atendimento(String codigo, String nome, double preco, String cpfCliente, String nomePet, String data) {
        this.codigoAtendimento = codigo;
        this.nome = nome;
        this.precoAtendimento = preco;
        this.cpfCliente = cpfCliente;
        this.nomePet = nomePet;
        this.data = data;
    }

    public String getCodigoAtendimento() {
        return codigoAtendimento;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoAtendimento() {
        return precoAtendimento;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getNomePet() {
        return nomePet;
    }

    public String getData() {
        return data;
    }

    public abstract void exibirInfoAtendimento();
}
