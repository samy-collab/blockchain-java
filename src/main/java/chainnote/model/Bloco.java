package chainnote.model;

import chainnote.hash.CalculadoraHash;
import java.time.LocalDateTime;

public class Bloco {

    private int id;
    private LocalDateTime timestamp;
    private String conteudo;
    private String hashAnterior;
    private String hashAtual;

    public Bloco(
            int id,
            String conteudo,
            String hashAnterior,
            CalculadoraHash calculadoraHash
    ) {
        this.id = id;
        this.timestamp = LocalDateTime.now();
        this.conteudo = conteudo;
        this.hashAnterior = hashAnterior;
        this.hashAtual = calcularHash(calculadoraHash);
    }

    public String calcularHash(CalculadoraHash calculadoraHash) {
        String dados = id + timestamp.toString() + conteudo + hashAnterior;
        return calculadoraHash.calcular(dados);
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