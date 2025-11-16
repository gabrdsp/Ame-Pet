package src.br.edu.amepet.modelo.atendimento;

public class Exame extends Atendimento{
    private String tipoExame;

    public Exame(String codigo, String nome, double preco, String cpfCliente, String nomePet, String data, String tipoExame){
        super(codigo,"Exame", preco, cpfCliente, nomePet, data);
        this.tipoExame = tipoExame;
    }

    @Override
    public void exibirInfoAtendimento() {
        System.out.println("Tipo de atendimento: Exame.");
        System.out.println("Tipo de exame: " + tipoExame);
        System.out.println("Pet: " + getNomePet());
        System.out.println("Data: " + getData());
        System.out.println("Preço: " + getPrecoAtendimento() );
    }
}
