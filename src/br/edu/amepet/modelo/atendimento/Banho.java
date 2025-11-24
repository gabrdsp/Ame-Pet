package br.edu.amepet.modelo.atendimento;

import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;

public class Banho extends Atendimento{
    private String tipoBanho;
    private int tempoBanho;

    public Banho(String codigo, String nome, double preco, Cliente cliente, Pet pet, String data, String tipoBanho, int tempoBanho){
        super(codigo, nome, preco, cliente, pet, data);
        this.tipoBanho = tipoBanho;
        this.tempoBanho = tempoBanho;
    }

    public String getTipoBanho(){
        return tipoBanho;
    }

    @Override
    public String exibirInformacoes(){
        return "== Banho ==\n" + informacoesBase() + "Procedimento: " + tipoBanho + "Duração: " + tempoBanho + "n";
    }
}
