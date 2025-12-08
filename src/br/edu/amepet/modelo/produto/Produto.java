package br.edu.amepet.modelo.produto;

import java.util.Objects;

public class Produto {

    private String codigo;
    private String nome;
    private String categoria;
    private double preco;
    private int quantidadeEstoque;

    // ============================
    //       CONSTRUTOR
    // ============================

    public Produto(
            final String codigo,
            final String nome,
            final String categoria,
            final double preco,
            final int quantidadeEstoque
    ) {
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setPreco(preco);
        setQuantidadeEstoque(quantidadeEstoque);
    }

    // ============================
    //       GETTERS E SETTERS
    // ============================

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(final String codigo) {
        this.codigo = validarStringNaoVazia(codigo, "código do produto");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = validarStringNaoVazia(nome, "nome do produto");
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(final String categoria) {
        this.categoria = validarStringNaoVazia(categoria, "categoria do produto");
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(final double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço deve ser maior ou igual a zero.");
        }
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(final int quantidadeEstoque) {
        if (quantidadeEstoque < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // ============================
    //       MÉTODOS DE ESTOQUE
    // ============================

    /**
     * Reduz o estoque em uma quantidade específica.
     *
     * @param quantidade quantidade a ser removida do estoque
     * @return true se foi possível reduzir, false caso contrário
     */
    public boolean reduzirEstoque(final int quantidade) {
        if (quantidade <= 0) {
            return false;
        }

        if (quantidadeEstoque >= quantidade) {
            quantidadeEstoque -= quantidade;
            return true;
        }

        return false;
    }

    /**
     * Adiciona uma quantidade ao estoque, se a quantidade for positiva.
     *
     * @param quantidade quantidade a ser adicionada ao estoque
     */
    public void adicionarEstoque(final int quantidade) {
        if (quantidade <= 0) {
            return;
        }
        quantidadeEstoque += quantidade;
    }

    // ============================
    //         EXIBIR DADOS
    // ============================

    public String exibirInformacoes() {
        return String.format(
                "Código: %s | Nome: %s | Categoria: %s | Preço: R$ %.2f | Estoque: %d",
                codigo,
                nome,
                categoria,
                preco,
                quantidadeEstoque
        );
    }

    @Override
    public String toString() {
        return exibirInformacoes();
    }

    // ============================
    //       MÉTODOS PRIVADOS
    // ============================

    private String validarStringNaoVazia(final String valor, final String nomeCampo) {
        Objects.requireNonNull(valor, "O " + nomeCampo + " não pode ser nulo.");

        final String valorTrim = valor.trim();
        if (valorTrim.isEmpty()) {
            throw new IllegalArgumentException("O " + nomeCampo + " não pode ser vazio.");
        }

        return valorTrim;
    }
}