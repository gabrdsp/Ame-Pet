package br.edu.amepet.modelo.atendimento;

import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;

public class Cirurgia extends Atendimento {
    private String procedimento;
    private int duracaoHoras;

    public Cirurgia(String codigo, double preco, Cliente cliente, Pet pet, String data, String procedimento, int duracaoHoras) {
        super(codigo, "Cirurgia", preco, cliente, pet, data);
        this.procedimento = procedimento;
        this.duracaoHoras = duracaoHoras;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    @Override
    public String exibirInformacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Cirurgia ===\n");
        sb.append("Código: ").append(getCodigo()).append("\n");
        sb.append("Cliente: ").append(getCliente().getNome()).append(" (").append(getCliente().getCpf()).append(")\n");
        sb.append("Pet: ").append(getPet().getNome()).append("\n");
        sb.append("Procedimento: ").append(procedimento).append("\n");
        sb.append("Duração (h): ").append(duracaoHoras).append("\n");
        sb.append("Data: ").append(getData()).append("\n");
        sb.append("Preço: R$ ").append(getPreco()).append("\n");
        return sb.toString();
    }
}
