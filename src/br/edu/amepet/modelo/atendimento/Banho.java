package br.edu.amepet.modelo.atendimento;

import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;

public class Banho extends Atendimento{
    private String tipoBanho;

    public Banho(String codigo, double preco, Cliente cliente, Pet pet, String data, String tipoBanho){
        super(codigo, "Banho", preco, cliente, pet, data);
        this.tipoBanho = tipoBanho;
    }

    public String getTipoBanho(){
        return tipoBanho;
    }

    @Override
    public String exibirInformacoes(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔════════════════════════════════════════════════╗\n");
        sb.append("║                     BANHO                        ║\n");
        sb.append("╠════════════════════════════════════════════════╣\n");
        sb.append(informacoesBase()).append("\n");
        sb.append(String.format("  Procedimento: %s\n", tipoBanho));
        sb.append("╚════════════════════════════════════════════════╝\n");
        return sb.toString();
    }
}
