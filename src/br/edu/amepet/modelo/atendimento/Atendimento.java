package br.edu.amepet.modelo.atendimento;

import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pet.Pet;

/**
 * Classe abstrata Atendimento que referencia Cliente e Pet.
 * Subclasses representam tipos concretos: Consulta, Exame, Cirurgia.
 */
public abstract class Atendimento {
    private String codigo;
    private String nome; // ex: "Consulta", "Exame", "Cirurgia"
    private double preco;
    private Cliente cliente;
    private Pet pet;
    private String data; // dd/mm/aaaa

    public Atendimento(String codigo, String nome, double preco, Cliente cliente, Pet pet, String data) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.cliente = cliente;
        this.pet = pet;
        this.data = data;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pet getPet() {
        return pet;
    }

    public String getData() {
        return data;
    }

    /**
     * Deve retornar uma string com as informações do atendimento.
     * Usado pelo gerenciador para exibição/listagem.
     */
    protected String informacoesBase() {
        return String.format("  Código: %s\n", getCodigo()) +
                String.format("  Cliente: %s (%s)\n", getCliente().getNome(), getCliente().getCpf()) +
                String.format("  Pet: %s\n", getPet().getNome()) +
                String.format("  Data: %s\n", getData()) +
                String.format("  Preço: R$ %.2f", getPreco());
    }

    public abstract String exibirInformacoes();

    /**
     * Método de conveniência que imprime as informações no console.
     */
    public void imprimir() {
        System.out.println(exibirInformacoes());
    }
}