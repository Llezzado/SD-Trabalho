package Modelos;
import pecas.Peca;

public interface Compras {
    void comprarPeca(Peca peca, int quantidade);
    void exibirDetalhesCompra();
}