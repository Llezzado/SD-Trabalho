package Testes.questao_4;
import java.io.Serializable;
public class Cliente implements Serializable {
    private int id;
    private String nome;
    private String contato;
    private String endereco;

    public Cliente(int id, String nome, String contato, String endereco) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getNum() { return contato; }
    public String getRua() { return endereco; }

    
    public String toString() {
        return "Cliente{id=" + id + ", nome='" + nome + "', contato='" + contato + ", endereco:" + endereco + "}";
    }
}