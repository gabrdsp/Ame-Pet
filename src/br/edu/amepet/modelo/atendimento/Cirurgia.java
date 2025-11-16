package src.br.edu.amepet.modelo.atendimento;

public class Cirurgia extends Atendimento{

    private String procedimento;
    private int duracaoHoras;

    public Cirurgia(String codigo, String nome, double preco, String cpfCliente, String nomePet, String data, String procedimento, int duracaoHoras) {
        super(codigo, nome, preco, cpfCliente, nomePet, data);
        this.procedimento = procedimento;
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public void exibirInfoAtendimento() {
        System.out.println("Tipo de atendimento: Cirugia.");
        System.out.println("Procedimento: " + procedimento);
        System.out.println("Duração: " + duracaoHoras);
        System.out.println("Pet: " + getNomePet());
        System.out.println("Data: " + getData());
        System.out.println("Preço: " + getPrecoAtendimento() );
    }
}
