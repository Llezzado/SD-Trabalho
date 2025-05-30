package pecas;
public class Amortecedor extends Peca {
    private int durabilidade; // Em meses

    public Amortecedor(String codigo, String nome, String marca, String modeloVeiculo, double preco, int quantidadeEstoque, int durabilidade) {
        super(codigo, nome, marca, modeloVeiculo, preco, quantidadeEstoque);
        this.durabilidade = durabilidade;
    }

    public int getDurabilidade() { return durabilidade; }
    public void setDurabilidade(int durabilidade) { this.durabilidade = durabilidade; }
    
    public String toString() {
        return "[AMORTECEDOR]\n" + super.toString();
    }
}