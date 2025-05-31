package controlador;
import java.util.ArrayList;
import java.util.List;

import pecas.Amortecedor;
import pecas.Motor;
import pecas.Peca;
import pecas.Pneu;

public class Deposito {

    private String localizacao;
    private int capacidadeMaxima;

    private static final List<Peca> pecas = new ArrayList<>(); // Agregação: Depósito contém peças

    static {
        pecas.add(new Motor("1", "Motor V8", "generico", "Motor", 800.0, 50,0 /*parametros extras do Motor*/));
        pecas.add(new Pneu("2", "Pneu Aro 20", "generico", "Pneu", 350.0, 50,0 /*parametros extras do Pneu*/));
        pecas.add(new Amortecedor("3", "Amortecedor Traseiro", "generico", "Amortecedor", 250.0, 50,0 /*parametros extras do Amortecedor*/));
    }

    public Deposito(String localizacao, int capacidadeMaxima) {
        this.localizacao = localizacao;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public static Peca buscarPorCodigo(String codigo) {
        for (Peca p : pecas) {
            System.out.println("listando " + p.getCodigo() + " com " + codigo);
            System.out.println("Comparando " + p.getCodigo() + " com " + codigo);
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public static void imprimirDeposito() {
    System.out.println("=== Peças no Depósito ===");
    for (Peca p : pecas) {
        System.out.println("Código: " + p.getCodigo() + ", Nome: " + p.getNome());
    }
}

    // Método para adicionar peça ao depósito
    public void adicionarPeca(Peca peca) {
        if (pecas.size() < capacidadeMaxima) {
            pecas.add(peca);
        } else {
            System.out.println("Depósito cheio!");
        }
    }

    // Getters e Setters
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public int getCapacidadeMaxima() { return capacidadeMaxima; }
    public void setCapacidadeMaxima(int capacidadeMaxima) { this.capacidadeMaxima = capacidadeMaxima; }

    public List<Peca> getPecas() { return pecas; }
}