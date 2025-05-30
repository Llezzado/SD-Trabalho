import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String args[]) {
        // Verificar argumentos
        if (args.length != 2) {
            System.out.println("Uso: java UDPClient <endereço_servidor> <mensagem>");
            return;
        }

        DatagramSocket socket = null;
        
        try {
            // 1. Criar socket UDP
            socket = new DatagramSocket();
            
            // 2. Preparar dados para envio
            byte[] sendData = args[1].getBytes();
            InetAddress serverAddress = InetAddress.getByName(args[0]);
            
            // 3. Criar e enviar pacote para o servidor (porta 9876)
            DatagramPacket sendPacket = new DatagramPacket(
                sendData, 
                sendData.length, 
                serverAddress, 
                9876
            );
            socket.send(sendPacket);
            
            System.out.println("Mensagem enviada para o servidor: " + args[1]);
            
            // 4. Preparar para receber resposta
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            // 5. Definir timeout de 5 segundos
            socket.setSoTimeout(5000);
            
            // 6. Tentar receber resposta
            socket.receive(receivePacket);
            
            // 7. Processar resposta
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Resposta do servidor: " + response);
            
        } catch (SocketTimeoutException e) {
            System.err.println("Timeout: Nenhuma resposta do servidor após 5 segundos");
        } catch (IOException e) {
            System.err.println("Erro no cliente: " + e.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}