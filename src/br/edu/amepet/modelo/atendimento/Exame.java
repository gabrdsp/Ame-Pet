package br.edu.amepet.modelo.atendimento;

import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;

public class Exame extends Atendimento {
    private String tipoExame;

    public Exame(String codigo, double preco, Cliente cliente, Pet pet, String data, String tipoExame) {
        super(codigo, "Exame", preco, cliente, pet, data);
        this.tipoExame = tipoExame;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    @Override
    public String exibirInformacoes() {
        return "=== Exame ===\n" + informacoesBase() + "Tipo de exame: " + tipoExame+ "\n";
    }
}
