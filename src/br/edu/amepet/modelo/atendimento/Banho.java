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
        return "== Banho ==\n" + informacoesBase() + "Procedimento: " + tipoBanho + "\n";
    }
}
