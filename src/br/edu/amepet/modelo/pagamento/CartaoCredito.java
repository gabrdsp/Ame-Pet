package src.br.edu.amepet.modelo.pagamento;

public class CartaoCredito implements FormaDePagamento {
    // Taxa de crédito (ex: 4.5%)
    private static final double TAXA_PERCENTUAL = 0.045;

    @Override
    public double calcularValorFinal(double valorBruto) {
        // Aplica o acréscimo da taxa
        return valorBruto * (1 + TAXA_PERCENTUAL);
    }
}
