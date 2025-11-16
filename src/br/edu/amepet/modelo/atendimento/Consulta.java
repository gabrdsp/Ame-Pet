package src.br.edu.amepet.modelo.atendimento;

public class Consulta extends Atendimento{
    private String veterinario;
    public Consulta (String codigo, String nome, double preco, String cpfCliente, String nomePet, String data,String veterinario){
        super(codigo,"Consulta", preco, cpfCliente, nomePet, data);
        this.veterinario = veterinario;
    }

    @Override
    public void exibirInfoAtendimento() {
        System.out.println("Tipo de atendimento: Consulta.");
        System.out.println("Pet: " + getNomePet());
        System.out.println("Veterinário: " + veterinario);
        System.out.println("Data: " + getData());
        System.out.println("Preço: " + getPrecoAtendimento() );
    }
}
