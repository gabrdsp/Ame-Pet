package src.br.edu.amepet.modelo.pagamento;

/**
 * Estratégia Concreta para pagamento via PIX.
 * Aplica um desconto de 5% para incentivar o uso (custo zero de taxa).
 */
public class Pix implements FormaDePagamento {
    // 5% de desconto
    private static final double DESCONTO_PERCENTUAL = 0.05;

    @Override
    public double calcularValorFinal(double valorBruto) {
        // Fórmula: Valor Bruto * (1 - Porcentagem de Desconto)
        return valorBruto * (1 - DESCONTO_PERCENTUAL);
    }
}