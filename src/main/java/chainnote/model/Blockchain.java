package chainnote.model;

import chainnote.hash.CalculadoraHash;

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

    public void adicionarBloco(String conteudo) {
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
        for (int i = 0; i < blocos.size(); i++) {
            Bloco blocoAtual = blocos.get(i);

            String hashCalculado =
                    blocoAtual.calcularHash(calculadoraHash);

            if (!blocoAtual.getHashAtual().equals(hashCalculado)) {
                return false;
            }

            if (i == 0) {
                if (!blocoAtual.getHashAnterior().equals("0")) {
                    return false;
                }
            } else {
                Bloco blocoAnterior = blocos.get(i - 1);

                if (!blocoAtual.getHashAnterior()
                        .equals(blocoAnterior.getHashAtual())) {
                    return false;
                }
            }
        }

        return true;
    }
}

//guarda os blocos em uma lista
//define o id automaticamente
//Lista todos os blocos
//Usa 0 como o hash anterior do primeiro bloco