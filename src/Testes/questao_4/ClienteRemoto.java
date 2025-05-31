package Testes.questao_4;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteRemoto {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu contato: ");
        String contato = scanner.nextLine();
        System.out.print("Digite seu endereço de entrega: ");
        String endereco = scanner.nextLine();

        List<Integer> carrinho = new ArrayList<>();
        while (true) {
            System.out.println("\n--- Menu Carrinho ---");
            System.out.println("1 - Adicionar Motor");
            System.out.println("2 - Adicionar Pneu");
            System.out.println("3 - Adicionar Amortecedor");
            System.out.println("4 - Finalizar pedido");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            if (opcao == 4) { break; }

            switch (opcao) {
                case 1:
                    carrinho.add(1); // código do Motor
                    System.out.println("Motor adicionado ao carrinho.");
                    break;
                case 2:
                    carrinho.add(2); // código do Pneu
                    System.out.println("Pneu adicionado ao carrinho.");
                    break;
                case 3:
                    carrinho.add(3); // código do Amortecedor
                    System.out.println("Amortecedor adicionado ao carrinho.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        // Para cada item do carrinho, faz um pedido ao servidor
        for (int codigo : carrinho) {
            try (
                Socket socket = new Socket("127.0.0.1", 12347);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream())
            ) {
                Cliente cliente = new Cliente(codigo, nome, contato, endereco);
                byte[] dados = ServidorRemoto.serializarCliente(cliente);

                out.writeInt(dados.length);
                out.write(dados);
                System.out.println("Pedido do código " + codigo + " enviado para o servidor.");

                int tamanho = in.readInt();
                if (tamanho > 0) {
                    String resposta = in.readUTF();
                    System.out.println("Resposta do servidor: " + resposta + " - " + tamanho + " bytes");
                } else {
                    System.out.println("Peça não encontrada para o código informado.");
                }
            }
        }
        scanner.close();
    }
}