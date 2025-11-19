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
        StringBuilder sb = new StringBuilder();
        sb.append("=== Exame ===\n");
        sb.append("Código: ").append(getCodigo()).append("\n");
        sb.append("Cliente: ").append(getCliente().getNome()).append(" (").append(getCliente().getCpf()).append(")\n");
        sb.append("Pet: ").append(getPet().getNome()).append("\n");
        sb.append("Tipo de exame: ").append(tipoExame).append("\n");
        sb.append("Data: ").append(getData()).append("\n");
        sb.append("Preço: R$ ").append(getPreco()).append("\n");
        return sb.toString();
    }
}
