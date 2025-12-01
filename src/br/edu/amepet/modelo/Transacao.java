package br.edu.amepet.modelo;
import br.edu.amepet.modelo.atendimento.Atendimento;
import br.edu.amepet.modelo.produto.Produto;
import br.edu.amepet.modelo.pessoa.Cliente;
import br.edu.amepet.modelo.pagamento.FormaDePagamento;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Contexto: Representa a venda final (Nota Fiscal/Carrinho).
 * Agrupa Atendimentos e Produtos para calcular o valor final.
 */
public class Transacao {

    private Cliente cliente;
    private List<Atendimento> atendimentos;
    private List<Produto> produtos;


    private FormaDePagamento formaPagamento;

    private String dataTransacao;

    public Transacao(Cliente cliente, String data) {
        this.cliente = cliente;
        this.dataTransacao = data;
        this.atendimentos = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.formaPagamento = null;
    }

    // --- Métodos de Gestão de Itens ---

    public void adicionarAtendimento(Atendimento a) {
        this.atendimentos.add(a);
    }

    public void adicionarProduto(Produto p) {
        this.produtos.add(p);
    }

    // --- Setter da Estratégia de Pagamento ---

    public void setFormaPagamento(FormaDePagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    // --- Métodos de Cálculo ---

    /**
     * Calcula o valor bruto somando o preço de todos os atendimentos e produtos.
     */
    public double calcularValorBruto() {
        double total = 0.0;

        // Soma dos Atendimentos
        for (Atendimento a : atendimentos) {
            total += a.getPreco();
        }

        // Soma dos Produtos
        for (Produto p : produtos) {
            total += p.getPreco();
        }

        return total;
    }

    /**
     * Retorna o valor final após aplicar o desconto/acréscimo da Forma de Pagamento.
     */
    public double calcularValorFinal() {
        double valorBruto = calcularValorBruto();

        if (formaPagamento == null) {
            System.err.println("Forma de pagamento não definida. Retornando valor bruto.");
            return valorBruto;
        }


        return formaPagamento.calcularValorFinal(valorBruto);
    }

}