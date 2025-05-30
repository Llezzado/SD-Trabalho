import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ServidorTCP {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor aguardando conexões...");
            
            while (true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream dis = new DataInputStream(socket.getInputStream())) {
                    
                    System.out.println("\nCliente conectado: " + socket.getInetAddress());
                    
                    int numPecas = dis.readInt();
                    System.out.println("Número de peças: " + numPecas);
                    
                    for (int i = 0; i < numPecas; i++) {
                        int tamanho = dis.readInt();
                        byte[] buffer = new byte[tamanho];
                        dis.readFully(buffer);
                        String pecaStr = new String(buffer);
                        System.out.println("Peça " + (i+1) + ": " + pecaStr);
                    }
                }
            }
        }
    }
}