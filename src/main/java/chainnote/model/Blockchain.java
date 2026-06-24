package chainnote.model;

import chainnote.content.Conteudo;
import chainnote.hash.CalculadoraHash;
import chainnote.validacao.ValidadorCadeia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Blockchain {

    private final List<Bloco> blocos;
    private final CalculadoraHash calculadoraHash;

    public Blockchain(CalculadoraHash calculadoraHash) {
        this.blocos = new ArrayList<>();
        this.calculadoraHash = calculadoraHash;
    }

    public void adicionarBloco(Conteudo conteudo) {
        int id = blocos.size() + 1;
        String hashAnterior = obterHashAnterior();

        Bloco novoBloco = new Bloco(
                id,
                conteudo,
                hashAnterior,
                calculadoraHash
        );

        blocos.add(novoBloco);
    }

    private String obterHashAnterior() {
        if (blocos.isEmpty()) {
            return "0";
        }

        return blocos.get(blocos.size() - 1).getHashAtual();
    }

    public List<Bloco> getBlocos() {
        return Collections.unmodifiableList(blocos);
    }

    public void listarBlocos() {
        if (blocos.isEmpty()) {
            System.out.println("A blockchain está vazia.");
            return;
        }

        for (Bloco bloco : blocos) {
            System.out.println(bloco);
        }
    }

    public boolean validarCadeia() {
        ValidadorCadeia validadorCadeia = new ValidadorCadeia(calculadoraHash);
        return validadorCadeia.validar(blocos);
    }
}