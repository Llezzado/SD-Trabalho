package Testes.questao_3;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ServidorTCP {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(12346)) {
            System.out.println("Servidor aguardando conexões...");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     FileInputStream fis = new FileInputStream("pecas.bin");
                     OutputStream out = socket.getOutputStream()) {

                    System.out.println("\nCliente conectado: " + socket.getInetAddress());

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                    System.out.println("Arquivo enviado para o cliente.");
                }
            }
        }
    }
}