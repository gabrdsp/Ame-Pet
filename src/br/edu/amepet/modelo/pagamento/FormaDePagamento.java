package br.edu.amepet.modelo.pagamento;

public interface FormaDePagamento {
    // Método para calcular o valor final com base na forma de pagamento
    double calcularValorFinal(double valorBruto);
}
