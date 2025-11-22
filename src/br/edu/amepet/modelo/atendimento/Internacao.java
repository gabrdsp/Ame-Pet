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
        return "=== Internação ===\n" + informacoesBase() + "Motivo: " + motivo+ "Dias internado: " + diasInternado + "\n";
    }
}
