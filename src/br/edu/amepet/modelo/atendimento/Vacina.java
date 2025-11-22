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
        return "=== Vacina ===\n" + informacoesBase() + "Tipo de Vacina: " + tipoVacina+ "\n";
    }
}
