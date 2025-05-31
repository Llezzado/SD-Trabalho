package Testes.questao_1;
import Modelos.CompraOnline;
import Modelos.CompraPresencial;
import Modelos.Compras;
import controlador.Deposito;
import pecas.Amortecedor;
import pecas.Motor;
import pecas.Peca;
import pecas.Pneu;

public class Test {
    public static void main(String[] args) {
        
        Pneu pneu1 = new Pneu("P001", "Pneu Aro 15", "Michelin", "Fiat Uno", 299.90, 50, 55);
        Motor motor1 = new Motor("M001", "Motor 1.0", "Fiat", "Palio", 4500.00, 10, 75);
        Amortecedor amortecedor1 = new Amortecedor("A001", "Amortecedor Dianteiro", "Monroe", "Gol", 199.90, 30, 24);

        Deposito depositoCentral = new Deposito("São Paulo", 1000);
        depositoCentral.adicionarPeca(pneu1);
        depositoCentral.adicionarPeca(motor1);
        depositoCentral.adicionarPeca(amortecedor1);

        Compras compraOnline = new CompraOnline("cliente@email.com", "Rua das Flores, 123");
        Compras compraPresencial = new CompraPresencial("João Silva", "123.456.789-00");

        System.out.println("\n=== COMPRA ONLINE ===");
        compraOnline.comprarPeca(pneu1, 2);
        compraOnline.exibirDetalhesCompra();

        System.out.println("\n=== COMPRA PRESENCIAL ===");
        compraPresencial.comprarPeca(motor1, 1);
        compraPresencial.exibirDetalhesCompra();

        System.out.println("\n=== ESTOQUE ATUALIZADO ===");
        System.out.println("Pneus em estoque: " + pneu1.getQuantidadeEstoque());
        System.out.println("Motores em estoque: " + motor1.getQuantidadeEstoque());
        System.out.println("Amortecedores em estoque: " + amortecedor1.getQuantidadeEstoque());

        System.out.println("\n=== PEÇAS NO DEPÓSITO ===");
        for (Peca peca : depositoCentral.getPecas()) {
            System.out.println(peca.getNome() + " - " + peca.getMarca());
        }



    }
}