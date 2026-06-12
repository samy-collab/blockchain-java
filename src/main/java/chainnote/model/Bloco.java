package chainnote.model;

import java.time.LocalDateTime;

public class Bloco {

    private int id;
    private LocalDateTime timestamp;
    private String conteudo;
    private String hashAnterior;
    private String hashAtual;

    public Bloco(int id, String conteudo, String hashAnterior, String hashAtual) {
        this.id = id;
        this.timestamp = LocalDateTime.now();
        this.conteudo = conteudo;
        this.hashAnterior = hashAnterior;
        this.hashAtual = hashAtual;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getHashAnterior() {
        return hashAnterior;
    }

    public String getHashAtual() {
        return hashAtual;
    }

    @Override
    public String toString() {
        return "Bloco{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", conteudo='" + conteudo + '\'' +
                ", hashAnterior='" + hashAnterior + '\'' +
                ", hashAtual='" + hashAtual + '\'' +
                '}';
    }
}