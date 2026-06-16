package chainnote.content;

public class TransacaoConteudo implements Conteudo {

    private String origem;
    private String destino;
    private double valor;

    public TransacaoConteudo(String origem, String destino, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    @Override
    public String obterDados() {
        return origem + " enviou " + valor + " para " + destino;
    }

    @Override
    public String obterTipo() {
        return "TRANSACAO";
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public double getValor() {
        return valor;
    }
}