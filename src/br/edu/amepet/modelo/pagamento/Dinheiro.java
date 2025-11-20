package src.br.edu.amepet.modelo.pagamento;

/**
 * Estratégia Concreta para pagamento em Dinheiro.
 * Aplica um desconto fixo de 10%.
 */
public class Dinheiro implements FormaDePagamento {
    private static final double DESCONTO_PERCENTUAL = 0.10;

    @Override
    public double calcularValorFinal(double valorBruto) {
        // Fórmula: Valor Bruto * (1 - Porcentagem de Desconto)
        return valorBruto * (1 - DESCONTO_PERCENTUAL);
    }
}