package pecas;

public abstract class Peca {
    private String codigo;
    private String nome;
    private String marca;
    private String modeloVeiculo;
    private double preco;
    private int quantidadeEstoque;

    // Construtor
    public Peca(String codigo, String nome, String marca, String modeloVeiculo, double preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.modeloVeiculo = modeloVeiculo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Getters e Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModeloVeiculo() { return modeloVeiculo; }
    public void setModeloVeiculo(String modeloVeiculo) { this.modeloVeiculo = modeloVeiculo; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    public String toString() {
        return String.format(
            "Código: %s | Nome: %s\nMarca: %s | Modelo: %s\nPreço: R$%.2f | Estoque: %d",
            codigo, nome, marca, modeloVeiculo, preco, quantidadeEstoque
        );
    }
}