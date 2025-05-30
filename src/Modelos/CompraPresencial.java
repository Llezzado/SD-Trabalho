package Modelos;
import pecas.Peca;
public class CompraPresencial implements Compras {
    private String nomeCliente;
    private String cpf;

    public CompraPresencial(String nomeCliente, String cpf) {
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
    }

    @Override
    public void comprarPeca(Peca peca, int quantidade) {
        if (peca.getQuantidadeEstoque() >= quantidade) {
            peca.setQuantidadeEstoque(peca.getQuantidadeEstoque() - quantidade);
            System.out.println("Compra presencial realizada: " + quantidade + "x " + peca.getNome());
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }

    @Override
    public void exibirDetalhesCompra() {
        System.out.println("Cliente: " + nomeCliente + " | CPF: " + cpf);
    }
}