package chainnote.content;

public class ImagemConteudo implements Conteudo {

    private String nomeArquivo;
    private String descricao;

    public ImagemConteudo(String nomeArquivo, String descricao) {
        this.nomeArquivo = nomeArquivo;
        this.descricao = descricao;
    }

    @Override
    public String obterDados() {
        return nomeArquivo + " - " + descricao;
    }

    @Override
    public String obterTipo() {
        return "IMAGEM";
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public String getDescricao() {
        return descricao;
    }
}