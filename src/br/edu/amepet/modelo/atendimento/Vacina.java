package br.edu.amepet.modelo.atendimento;
import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;

public class Vacina extends Atendimento{
    private String tipoVacina;
    public Vacina(String codigo, double preco, Cliente cliente, Pet pet, String data, String tipoVacina){
        super(codigo,"Vacina",preco,cliente,pet,data);
        this.tipoVacina = tipoVacina;
    }

    public String getTipoVacina() {
        return tipoVacina;
    }

    @Override
    public String exibirInformacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔════════════════════════════════════════════════╗\n");
        sb.append("║                     VACINA                       ║\n");
        sb.append("╠════════════════════════════════════════════════╣\n");
        sb.append(informacoesBase()).append("\n");
        sb.append(String.format("  Tipo de Vacina: %s\n", tipoVacina));
        sb.append("╚════════════════════════════════════════════════╝\n");
        return sb.toString();
    }
}
