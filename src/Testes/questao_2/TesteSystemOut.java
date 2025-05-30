package Testes.questao_2;
import java.io.*;
import pecas.*;
import stream.PecaOutputStream;

public class TesteSystemOut {
    public static void main(String[] args) throws IOException {
        Peca[] pecas = {
            new Motor("M001", "Motor V8", "Ford", "Mustang", 15000.0, 5, 450),
            new Pneu("P001", "Pneu Aro 17", "Pirelli", "Golf", 800.0, 10, 55)
        };

        try (PecaOutputStream pos = new PecaOutputStream(pecas, pecas.length, System.out)) {
            pos.writePecas();
        } catch (IOException e) {
            System.err.println("Erro durante a escrita: " + e.getMessage());
        }
    }
}