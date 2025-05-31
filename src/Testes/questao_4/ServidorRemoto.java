package Testes.questao_4;

import java.io.*;
import java.net.*;
import pecas.Peca;
import controlador.Deposito;

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

                    String codigo = String.valueOf(cliente.getId());
                    System.out.println("Recebido código: " + codigo);

                    // Buscar a peça pelo código
                    Peca peca = buscarPecaPorCodigo(codigo);

                    if (peca != null) {
                        // Serializar pelo menos 3 atributos (exemplo: código, nome, preço)
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        DataOutputStream dos = new DataOutputStream(baos);
                        dos.writeUTF(peca.getCodigo());
                        dos.writeUTF(peca.getNome());
                        dos.writeDouble(peca.getPreco());
                        byte[] dadosPeca = baos.toByteArray();

                        out.writeInt(dadosPeca.length);
                        out.write(dadosPeca);
                        out.flush();
                        System.out.println("Peça enviada ao cliente: " + peca.getNome());
                    } else {
                        out.writeInt(0); // Nenhuma peça encontrada
                        out.flush();
                        System.out.println("Peça não encontrada para o código: " + codigo);
                    }
                }
            }
        }
    }

    private static Peca buscarPecaPorCodigo(String codigo) {
        
        return Deposito.buscarPorCodigo(codigo);
    }

    public static byte[] serializarCliente(Cliente user) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getNome());
        dos.writeUTF(user.getNum());
        dos.writeUTF(user.getRua());
        return baos.toByteArray();
    }

    public static Cliente desserializarCliente(byte[] dados) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(dados);
        DataInputStream dis = new DataInputStream(bais);
        int id = dis.readInt();
        String nome = dis.readUTF();
        String num = dis.readUTF();
        String rua = dis.readUTF();
        return new Cliente(id, nome, num, rua);
    }
}