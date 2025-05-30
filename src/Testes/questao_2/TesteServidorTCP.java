package Testes.questao_2;
import java.net.Socket;

import java.io.*;
import pecas.*;
import stream.PecaOutputStream;


public class TesteServidorTCP {
    public static void main(String[] args) {
        Peca[] pecas = {
            new Pneu("P002", "Pneu Aro 16", "Michelin", "Palio", 600.0, 7, 50),
            new Amortecedor("A002", "Amortecedor Traseiro", "Sachs", "Corolla", 350.0, 6, 18)
        };

        try (Socket socket = new Socket("localhost", 12345);
             OutputStream os = socket.getOutputStream();
             PecaOutputStream pos = new PecaOutputStream(pecas, pecas.length, os)) {
            
            pos.writePecas();
            System.out.println("Dados enviados para o servidor!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}