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
        return "\n╔════════════════════════════════════════════════╗\n" +
                "║                      RECIBO                     ║\n" +
                "╠════════════════════════════════════════════════╣\n" +
                String.format("║ Pedido: %-38s ║\n", id) +
                String.format("║ Data: %-39s ║\n", dataHora.format(fmt)) +
                String.format("║ Cliente (CPF): %-33s ║\n", cpfCliente) +
                String.format("║ Pet: %-40s ║\n", nomePet) +
                String.format("║ Preço: R$ %-35.2f ║\n", precoOriginal) +
                String.format("║ Forma de pagamento: %-25s ║\n", formaPagamento) +
                String.format("║ Valor pago: R$ %-31.2f ║\n", valorFinal) +
                String.format("║ Status: %-38s ║\n", status) +
                "║                                                ║\n" +
                "║           Obrigado pela compra!                ║\n" +
                "║              Volte sempre!                     ║\n" +
                "╚════════════════════════════════════════════════╝\n";
    }
}
