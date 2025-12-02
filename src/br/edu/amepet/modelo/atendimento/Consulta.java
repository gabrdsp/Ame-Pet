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
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔════════════════════════════════════════════════╗\n");
        sb.append("║                    CONSULTA                      ║\n");
        sb.append("╠════════════════════════════════════════════════╣\n");
        sb.append(informacoesBase()).append("\n");
        sb.append(String.format("  Veterinário: %s\n", veterinario));
        sb.append("╚════════════════════════════════════════════════╝\n");
        return sb.toString();
    }
}
