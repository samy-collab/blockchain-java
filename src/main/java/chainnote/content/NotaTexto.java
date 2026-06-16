package chainnote.content;

public class NotaTexto implements Conteudo {

    private String texto;

    public NotaTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String obterDados() {
        return texto;
    }

    @Override
    public String obterTipo() {
        return "NOTA_TEXTO";
    }

    public String getTexto() {
        return texto;
    }
}