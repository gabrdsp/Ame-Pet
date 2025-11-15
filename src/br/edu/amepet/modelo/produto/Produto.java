package src.br.edu.amepet.modelo.produto;

public class Produto {
    private String codigo;
    private String nome;
    private String categoria;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String codigo, String nome, String categoria, double preco, int quantidadeEstoque){
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setPreco(preco);
        setQuantidadeEstoque(quantidadeEstoque);
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("O código do produto não pode ser vazio!");
        }
        this.codigo = codigo.trim();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome do produto não pode ser vazio!");
        }
        this.nome = nome.trim();
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCategoria(String categoria){
        if(categoria == null || categoria.trim().isEmpty()){
            throw new IllegalArgumentException("A categoria do produto não pode ser vaia!");
        }
        this.categoria = categoria.trim();
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        if(preco < 0){
            throw new IllegalArgumentException("O preço deve ser maior do que zero!");
        }
        this.preco = preco;
    }

    public int getQuantidadeEstoque(){
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque){
        if(quantidadeEstoque < 0){
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa!");
        }
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean reduzirEstoque(int quantidade){
        if(quantidade <= 0){
            return false;
        } else if(quantidade > quantidadeEstoque){
            return false;
        } else {
            quantidadeEstoque -= quantidade;
            return true;
        }
    }

    public void adicionarEstoque(int quantidade){
        if(quantidade <= 0){
            throw new IllegalArgumentException("A quantidade adicionada deve ser maior do que zero.");
        }
        quantidadeEstoque += quantidade;
    }

    public String exibirInformacoes(){
        return String.format("Código: %s | Nome: %s | Categoria: %s | Preço: R$ %.2f | Estoque: %d",
                codigo, nome, categoria, preco, quantidadeEstoque);
    }
}
