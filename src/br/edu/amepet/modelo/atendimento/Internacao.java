package br.edu.amepet.modelo.atendimento;

import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;

public class Internacao extends Atendimento {

    private String motivo;
    private int diasInternado;

    public Internacao(String codigo, double preco, Cliente cliente, Pet pet, String data, String motivo, int diasInternado) {
        super(codigo, "Internação", preco, cliente, pet, data);
        this.motivo = motivo;
        this.diasInternado = diasInternado;
    }

    public String getMotivo() {
        return motivo;
    }

    public int getDiasInternado() {
        return diasInternado;
    }

    @Override
    public String exibirInformacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔════════════════════════════════════════════════╗\n");
        sb.append("║                   INTERNAÇÃO                     ║\n");
        sb.append("╠════════════════════════════════════════════════╣\n");
        sb.append(informacoesBase()).append("\n");
        sb.append(String.format("  Motivo: %s\n", motivo));
        sb.append(String.format("  Dias internado: %d\n", diasInternado));
        sb.append("╚════════════════════════════════════════════════╝\n");
        return sb.toString();
    }
}
