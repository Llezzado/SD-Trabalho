package Testes.questao_4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteRemoto {
    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket("127.0.0.1", 12347);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in)) {

            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite seu contato: ");
            String contato = scanner.nextLine();

            int codigo = 42;
            Cliente cliente = new Cliente(codigo, nome, contato);
            byte[] dados = ServidorRemoto.serializarCliente(cliente);

            // Empacotar requisição
            out.writeInt(dados.length);
            out.write(dados);
            System.out.println("Requisição enviada para o servidor.");

            // Desempacotar resposta
            int tamanho = in.readInt();
            String resposta = in.readUTF();
            System.out.println("Resposta do servidor: " + resposta + " - " + tamanho + " bytes");
        }
    }
}