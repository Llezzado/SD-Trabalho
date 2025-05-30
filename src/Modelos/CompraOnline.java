package Modelos;
import pecas.Peca;
public class CompraOnline implements Compras {
    private String emailCliente;
    private String enderecoEntrega;

    public CompraOnline(String emailCliente, String enderecoEntrega) {
        this.emailCliente = emailCliente;
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    public void comprarPeca(Peca peca, int quantidade) {
        if (peca.getQuantidadeEstoque() >= quantidade) {
            peca.setQuantidadeEstoque(peca.getQuantidadeEstoque() - quantidade);
            System.out.println("Compra online realizada: " + quantidade + "x " + peca.getNome());
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }

    @Override
    public void exibirDetalhesCompra() {
        System.out.println("Entrega para: " + enderecoEntrega + " | Cliente: " + emailCliente);
    }
}
