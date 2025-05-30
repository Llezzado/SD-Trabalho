package Testes.questao_2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import pecas.Amortecedor;
import pecas.Motor;
import pecas.Peca;
import stream.PecaOutputStream;

public class TesteArquivo {
    public static void main(String[] args) {
        Peca[] pecas = {
            new Amortecedor("A001", "Amortecedor Dianteiro", "Monroe", "Civic", 400.0, 8, 24),
            new Motor("M002", "Motor 1.0 Turbo", "VW", "Gol", 10000.0, 3, 120)
        };

        try (OutputStream fos = new FileOutputStream("pecas.dat");
             PecaOutputStream pos = new PecaOutputStream(pecas, pecas.length, fos)) {
            
            pos.writePecas();
            System.out.println("Dados gravados no arquivo com sucesso!");
            
        } catch (IOException e) {
            System.err.println("Erro ao gravar arquivo:");
            e.printStackTrace();
        }
    }
}