package pecas;
public class Motor extends Peca {
    private double potencia;

    public Motor(String codigo, String nome, String marca, String modeloVeiculo, double preco, int quantidadeEstoque, double potencia) {
        super(codigo, nome, marca, modeloVeiculo, preco, quantidadeEstoque);
        this.potencia = potencia;
    }

    public double getPotencia() { return potencia; }
    public void setPotencia(double potencia) { this.potencia = potencia; }

    public String toString() {
        return "[MOTOR]\n" + super.toString() + 
        String.format("\nPotência: %.1f HP", potencia);
    }
}