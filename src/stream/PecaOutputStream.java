package stream;

import pecas.Peca;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class PecaOutputStream extends OutputStream {
    private final OutputStream outputStream;
    private final Peca[] pecas;
    private final int numObjetos;

    public PecaOutputStream(Peca[] pecas, int numObjetos, OutputStream destination) {
        this.outputStream = destination;
        this.pecas = pecas;
        this.numObjetos = Math.min(numObjetos, pecas.length);
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    public void writePecas() throws IOException {

        writeInt(numObjetos);

        for (int i = 0; i < numObjetos; i++) {
            Peca peca = pecas[i];
            byte[] pecaBytes = convertPecaToBytes(peca);
            
            writeInt(pecaBytes.length);
            write(pecaBytes);
        }
        outputStream.flush();
    }

    private byte[] convertPecaToBytes(Peca peca) {
        // Converte 3 atributos para bytes: codigo, nome, preco
        String dados = String.format("%s;%s;%.2f", 
            peca.getCodigo(), 
            peca.getNome(), 
            peca.getPreco());
        return dados.getBytes();
    }

    private void writeInt(int value) throws IOException {
        byte[] bytes = ByteBuffer.allocate(4).putInt(value).array();
        outputStream.write(bytes);
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}