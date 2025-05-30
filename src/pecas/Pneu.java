package pecas;

public class Pneu extends Peca {
    private int perfil; // Ex: 55, 60, 70

    public Pneu(String codigo, String nome, String marca, String modeloVeiculo, double preco, int quantidadeEstoque, int perfil) {
        super(codigo, nome, marca, modeloVeiculo, preco, quantidadeEstoque);
        this.perfil = perfil;
    }

    public int getPerfil() { return perfil; }
    public void setPerfil(int perfil) { this.perfil = perfil; }

    public String toString() {
        return "[PNEU]\n" + super.toString() + 
        String.format("\nPerfil: %d", perfil);
    }
}