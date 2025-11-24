package br.edu.amepet.modelo.atendimento;

import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;

public class Tosa extends Atendimento{

    private String tipoTosa;
    private int duracaoHoras;
    
    public Tosa(String codigo, String nome, double preco, Cliente cliente, Pet pet, String data, String tipoTosa, int duracaoHoras){
       super(codigo, nome, preco, cliente, pet, data);
       this.tipoTosa = tipoTosa;
       this.duracaoHoras = duracaoHoras;
    }

    public String getTipoTosa(){
        return tipoTosa;
    }

    @Override
    public String exibirInformacoes(){
        return "== Tosa ==\n" + informacoesBase() + "Procedimento: " + tipoTosa + "Duração: " + duracaoHoras + "\n";
    }

}
