package chainnote.persistencia;

import chainnote.content.Conteudo;
import chainnote.content.ImagemConteudo;
import chainnote.content.NotaTexto;
import chainnote.content.TransacaoConteudo;
import chainnote.model.Bloco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEmArquivoJson implements RepositorioCadeia {

    private final String caminhoArquivo;
    private final Gson gson;

    public RepositorioEmArquivoJson(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void salvar(List<Bloco> blocos) {
        List<BlocoJson> blocosJson = new ArrayList<>();

        for (Bloco bloco : blocos) {
            BlocoJson blocoJson = new BlocoJson(
                    bloco.getId(),
                    bloco.getTimestamp().toString(),
                    bloco.getConteudo().obterTipo(),
                    bloco.getConteudo().obterDados(),
                    bloco.getHashAnterior(),
                    bloco.getHashAtual()
            );

            blocosJson.add(blocoJson);
        }

        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            String json = gson.toJson(blocosJson);
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar blockchain em JSON", e);
        }
    }

    @Override
    public List<Bloco> carregar() {
        try (FileReader reader = new FileReader(caminhoArquivo)) {
            BlocoJson[] blocosJson = gson.fromJson(reader, BlocoJson[].class);
            List<Bloco> blocos = new ArrayList<>();

            if (blocosJson == null) {
                return blocos;
            }

            for (BlocoJson blocoJson : blocosJson) {
                Conteudo conteudo = recriarConteudo(blocoJson.tipo, blocoJson.dados);

                Bloco bloco = new Bloco(
                        blocoJson.id,
                        LocalDateTime.parse(blocoJson.timestamp),
                        conteudo,
                        blocoJson.hashAnterior,
                        blocoJson.hashAtual
                );

                blocos.add(bloco);
            }

            return blocos;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar blockchain do JSON", e);
        }
    }

    private Conteudo recriarConteudo(String tipo, String dados) {
        if (tipo.equals("NOTA_TEXTO")) {
            return new NotaTexto(dados);
        }

        if (tipo.equals("IMAGEM")) {
            return new ImagemConteudo(dados, "");
        }

        if (tipo.equals("TRANSACAO")) {
            return new TransacaoConteudo(dados, "", 0);
        }

        return new NotaTexto(dados);
    }

    private static class BlocoJson {
        int id;
        String timestamp;
        String tipo;
        String dados;
        String hashAnterior;
        String hashAtual;

        BlocoJson(
                int id,
                String timestamp,
                String tipo,
                String dados,
                String hashAnterior,
                String hashAtual
        ) {
            this.id = id;
            this.timestamp = timestamp;
            this.tipo = tipo;
            this.dados = dados;
            this.hashAnterior = hashAnterior;
            this.hashAtual = hashAtual;
        }
    }
}