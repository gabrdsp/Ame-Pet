package src.br.edu.amepet.modelo.pagamento;

public class CartaoDebito implements FormaDePagamento{
    // Taxa de débito (ex: 2%)
    private static final double TAXA_PERCENTUAL = 0.02;

    @Override
    public double calcularValorFinal(double valorBruto) {
        // Aplica o acréscimo da taxa
        return valorBruto * (1 + TAXA_PERCENTUAL);
    }
}
