package Testes.questao_4;

import java.io.*;
import java.net.*;


public class ServidorRemoto {


    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(12347)) {
            System.out.println("Servidor aguardando conexões...");
            while (true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream in = new DataInputStream(socket.getInputStream());
                     DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                    // Desempacotar requisição do cliente
                    int tam = in.readInt();
                    byte[] dados = new byte[tam];
                    in.readFully(dados);

                    Cliente cliente = desserializarCliente(dados);

                    System.out.println("Cliente conectado: " + cliente.getNome() + "\nNumero: " + cliente.getNum());
                    
                    int codigo = cliente.getId();
                    // Exibir informações do cliente
                    System.out.println("Recebido código: " + codigo);

                    // Processar e empacotar resposta
                    String resposta = "Peça " + codigo + ": Motor V8";
                    out.writeInt(resposta.length());
                    out.writeUTF(resposta);
                }
            }
        }
    }
    
    public static byte[] serializarCliente(Cliente user) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getNome());
        dos.writeUTF(user.getNum());
        return baos.toByteArray();
    }
    
    public static Cliente desserializarCliente(byte[] dados) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(dados);
        DataInputStream dis = new DataInputStream(bais);
        int id = dis.readInt();
        String nome = dis.readUTF();
        String num = dis.readUTF();
        return new Cliente(id, nome, num);
    }
}
