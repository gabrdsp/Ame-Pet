package br.edu.amepet.modelo.atendimento;

import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;

public class Consulta extends Atendimento {
    private String veterinario;

    public Consulta(String codigo, double preco, Cliente cliente, Pet pet, String data, String veterinario) {
        super(codigo, "Consulta", preco, cliente, pet, data);
        this.veterinario = veterinario;
    }

    public String getVeterinario() {
        return veterinario;
    }

    @Override
    public String exibirInformacoes() {
        return "=== Consulta ===\n" + informacoesBase() + "Veterinário: " + veterinario + "\n";
    }
}
