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
        sb.append("\n╔════════════════════════════════════════════════╗\n");
        sb.append("║                    CIRURGIA                      ║\n");
        sb.append("╠════════════════════════════════════════════════╣\n");
        sb.append(informacoesBase()).append("\n");
        sb.append(String.format("  Procedimento: %s\n", procedimento));
        sb.append(String.format("  Duração: %d horas\n", duracaoHoras));
        sb.append("╚════════════════════════════════════════════════╝\n");
        return sb.toString();
    }
}
