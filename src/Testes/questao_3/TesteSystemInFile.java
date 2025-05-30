package Testes.questao_3;

import java.io.FileInputStream;
import java.io.InputStream;
import stream.PecaInputStream;
import pecas.Peca;

public class TesteSystemInFile {
    public static void main(String[] args) {
        try {
            // Use o arquivo como origem
            try (InputStream fileIn = new FileInputStream("pecas.bin");
                 PecaInputStream pis = new PecaInputStream(fileIn)) {

                Peca[] pecas = pis.readPecas();
                System.out.println("Peças processadas: " + pecas.length);

                for (Peca peca : pecas) {
                    System.out.println("Detalhes da peça:");
                    if (peca instanceof pecas.Motor) {
                        System.out.println("=======================");
                        pecas.Motor motor = (pecas.Motor) peca;
                        System.out.println(motor);
                        System.out.println("Potência dedicada: " + motor.getPotencia() + " HP");
                    } else if (peca instanceof pecas.Pneu) {
                        System.out.println("=======================");
                        pecas.Pneu pneu = (pecas.Pneu) peca;
                        System.out.println(pneu);
                        System.out.println("Aro do Pneu: " + pneu.getPerfil());
                    } else if (peca instanceof pecas.Amortecedor) {
                        System.out.println("=======================");
                        pecas.Amortecedor amortecedor = (pecas.Amortecedor) peca;
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