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
        sb.append("=== Consulta ===\n");
        sb.append("Código: ").append(getCodigo()).append("\n");
        sb.append("Cliente: ").append(getCliente().getNome()).append(" (").append(getCliente().getCpf()).append(")\n");
        sb.append("Pet: ").append(getPet().getNome()).append("\n");
        sb.append("Veterinário: ").append(veterinario).append("\n");
        sb.append("Data: ").append(getData()).append("\n");
        sb.append("Preço: R$ ").append(getPreco()).append("\n");
        return sb.toString();
    }
}
