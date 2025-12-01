package br.edu.amepet.modelo.atendimento;

import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;

public class Tosa extends Atendimento{

    private String tipoTosa;
    
    public Tosa(String codigo, double preco, Cliente cliente, Pet pet, String data, String tipoTosa){
       super(codigo, "Tosa", preco, cliente, pet, data);
       this.tipoTosa = tipoTosa;
    }

    public String getTipoTosa(){
        return tipoTosa;
    }

    @Override
    public String exibirInformacoes(){
        return "== Tosa ==\n" + informacoesBase() + "Procedimento: " + tipoTosa + "Duração: ";
    }

}
