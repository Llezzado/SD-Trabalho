package controlador;
import java.util.ArrayList;
import java.util.List;

import pecas.Peca;

public class Deposito {
    private String localizacao;
    private int capacidadeMaxima;
    private List<Peca> pecas = new ArrayList<>(); // Agregação: Depósito contém peças

    public Deposito(String localizacao, int capacidadeMaxima) {
        this.localizacao = localizacao;
        this.capacidadeMaxima = capacidadeMaxima;
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