package Testes.questao_3;
import java.net.Socket;
import stream.PecaInputStream;
import pecas.Peca;

public class TesteSystemInTCP {
    public static void main(String[] args) {
        try {
            // Conecte ao servidor remoto (ajuste o IP se necessário)
            try (Socket socket = new Socket("127.0.0.1", 12346);
                 PecaInputStream pis = new PecaInputStream(socket.getInputStream())) {

                Peca[] pecas = pis.readPecas();
                System.out.println("Peças processadas: " + pecas.length);

                for (Peca peca : pecas) {
                    System.out.println("Detalhes da peça:");
                    if (peca instanceof pecas.Motor) {
                        pecas.Motor motor = (pecas.Motor) peca;
                        System.out.println("=================");
                        System.out.println(motor);
                        System.out.println("Potência dedicada: " + motor.getPotencia() + " HP");
                    } else if (peca instanceof pecas.Pneu) {
                        pecas.Pneu pneu = (pecas.Pneu) peca;
                        System.out.println("=================");
                        System.out.println(pneu);
                        System.out.println("Aro do Pneu: " + pneu.getPerfil());
                    } else if (peca instanceof pecas.Amortecedor) {
                        pecas.Amortecedor amortecedor = (pecas.Amortecedor) peca;
                        System.out.println("=================");
                        System.out.println(amortecedor);
                        System.out.println("Durabilidade: " + amortecedor.getDurabilidade() + " meses");
                    } else {
                        System.out.println("Tipo: Desconhecido");
                        System.out.println(peca);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erro durante processamento:");
            e.printStackTrace();
        }
    }
}