package br.edu.amepet.modelo.venda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venda {
    private String id;
    private String cpfCliente;
    private String nomePet;
    private double precoOriginal;
    private String formaPagamento;
    private double valorFinal;
    private LocalDateTime dataHora;
    private String status; // ex: PAGO, PENDENTE, CANCELADO

    public Venda(String id, String cpfCliente, String nomePet, double precoOriginal, String formaPagamento, double valorFinal, LocalDateTime dataHora, String status) {
        this.id = id;
        this.cpfCliente = cpfCliente;
        this.nomePet = nomePet;
        this.precoOriginal = precoOriginal;
        this.formaPagamento = formaPagamento;
        this.valorFinal = valorFinal;
        this.dataHora = dataHora;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getNomePet() {
        return nomePet;
    }

    public double getPrecoOriginal() {
        return precoOriginal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String gerarRecibo() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "--- Recibo ---\n" +
                "Pedido: " + id + "\n" +
                "Data: " + dataHora.format(fmt) + "\n" +
                "Cliente (CPF): " + cpfCliente + "\n" +
                "Pet: " + nomePet + "\n" +
                String.format("Preço: R$%.2f\n", precoOriginal) +
                "Forma de pagamento: " + formaPagamento + "\n" +
                String.format("Valor pago: R$%.2f\n", valorFinal) +
                "Status: " + status + "\n" +
                "----------------\n";
    }
}
