package Testes.questao_4;
import java.io.Serializable;
public class Cliente implements Serializable {
    private int id;
    private String nome;
    private String contato;

    public Cliente(int id, String nome, String contato) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getNum() { return contato; }

    
    public String toString() {
        return "Cliente{id=" + id + ", nome='" + nome + "', contato='" + contato + "'}";
    }
}