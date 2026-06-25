package chainnote.model;

import chainnote.content.Conteudo;
import chainnote.hash.CalculadoraHash;

import java.time.LocalDateTime;

public class Bloco {

    private int id;
    private LocalDateTime timestamp;
    private Conteudo conteudo;
    private String hashAnterior;
    private String hashAtual;

    public Bloco(
            int id,
            Conteudo conteudo,
            String hashAnterior,
            CalculadoraHash calculadoraHash
    ) {
        this.id = id;
        this.timestamp = LocalDateTime.now();
        this.conteudo = conteudo;
        this.hashAnterior = hashAnterior;
        this.hashAtual = calcularHash(calculadoraHash);
    }

    public Bloco(
            int id,
            LocalDateTime timestamp,
            Conteudo conteudo,
            String hashAnterior,
            String hashAtual
    ) {
        this.id = id;
        this.timestamp = timestamp;
        this.conteudo = conteudo;
        this.hashAnterior = hashAnterior;
        this.hashAtual = hashAtual;
    }

    public String calcularHash(CalculadoraHash calculadoraHash) {
        String dados = id
                + timestamp.toString()
                + conteudo.obterTipo()
                + conteudo.obterDados()
                + hashAnterior;

        return calculadoraHash.calcular(dados);
    }

    public void adulterarConteudo(Conteudo novoConteudo) {
        this.conteudo = novoConteudo;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Conteudo getConteudo() {
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
                ", tipo='" + conteudo.obterTipo() + '\'' +
                ", conteudo='" + conteudo.obterDados() + '\'' +
                ", hashAnterior='" + hashAnterior + '\'' +
                ", hashAtual='" + hashAtual + '\'' +
                '}';
    }
}