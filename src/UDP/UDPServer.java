import java.net.*;
import java.io.*;

public class UDPServer {
    public static void main(String args[]) {
        DatagramSocket socket = null;
        
        try {
            // 1. Criar socket UDP na porta 9876
            socket = new DatagramSocket(9876);
            byte[] buffer = new byte[1024];
            
            System.out.println("Servidor UDP iniciado na porta 9876...");
            
            while(true) {
                // 2. Preparar pacote para receber dados
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                
                // 3. Receber pacote do cliente
                socket.receive(receivePacket);
                
                // 4. Extrair dados e informações do cliente
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                
                System.out.println("Mensagem recebida de " + clientAddress + ":" + clientPort + " - " + message);
                
                // 5. Processar mensagem (aqui apenas convertemos para maiúsculas)
                String response = message.toUpperCase();
                byte[] responseData = response.getBytes();
                
                // 6. Enviar resposta ao cliente
                DatagramPacket sendPacket = new DatagramPacket(
                    responseData, 
                    responseData.length, 
                    clientAddress, 
                    clientPort
                );
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}