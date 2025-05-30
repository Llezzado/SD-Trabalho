package stream;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import pecas.Peca;
import pecas.Motor;
import pecas.Pneu;
import pecas.Amortecedor;

public class PecaInputStream extends InputStream {
    private final DataInputStream dataInputStream;

    public PecaInputStream(InputStream in) {
        this.dataInputStream = new DataInputStream(in);
    }

    public Peca[] readPecas() throws IOException {
        // Verificar se há dados suficientes para o cabeçalho (8 bytes)
        if (dataInputStream.available() < 8) {
            throw new EOFException("Dados insuficientes para cabeçalho");
        }


        // Ler número de peças (big-endian)
        int numPecas = dataInputStream.readInt();
        //System.out.println("Número de peças (raw): " + numPecas);

        Peca[] pecas = new Peca[numPecas];
        
        for (int i = 0; i < numPecas; i++) {
            // Ler tamanho dos dados (big-endian)
            int tamanho = dataInputStream.readInt();
            //System.out.println("Tamanho da peça " + i + ": " + tamanho);
            
            // Verificar se há dados suficientes
            if (dataInputStream.available() < tamanho) {
                throw new EOFException("Dados insuficientes para peça " + i);
            }
            
            byte[] buffer = new byte[tamanho];
            dataInputStream.readFully(buffer);
            
            // Converter para string usando ISO-8859-1 (preserva bytes)
            String pecaStr = new String(buffer, StandardCharsets.ISO_8859_1);
            System.out.println("Dados crus: '" + pecaStr + "'");
            
            pecas[i] = parsePeca(pecaStr);
        }
        return pecas;
    }

    private Peca parsePeca(String pecaStr) {
        // Remover caracteres não ASCII se necessário
        pecaStr = pecaStr.replaceAll("[^\\x20-\\x7E]", "");
        
        String[] partes = pecaStr.split(";");
        
        if (partes.length < 4) { // ajuste conforme o mínimo de campos esperado
            throw new IllegalArgumentException("Formato inválido. Esperado: tipo;codigo;nome;preco. Recebido: " + pecaStr);
        }
        
        String tipo = partes[0];
        String codigo = partes[1];
        String nome = partes[2];
        double preco = Double.parseDouble(partes[3]);
        
        switch (tipo) {
            case "Motor":
                return new Motor(codigo, nome, "Genérico", "Genérico", preco, 0, 0.0);
            case "Pneu":
                int aro = 0; 
                return new Pneu(codigo, nome, "Genérico", "Genérico", preco, 0, aro);
            case "Amortecedor":
                int durabilidade = Integer.parseInt(partes[4]);
                return new Amortecedor(codigo, nome, "Genérico", "Genérico", preco, 0, durabilidade);
            default:
                throw new IllegalArgumentException("Tipo de peça desconhecido: " + tipo);
        }
        
    }

    public int read() throws IOException {
        return dataInputStream.read();
    }

    public void close() throws IOException {
        dataInputStream.close();
    }
}