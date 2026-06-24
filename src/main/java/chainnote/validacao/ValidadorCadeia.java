package chainnote.validacao;

import chainnote.hash.CalculadoraHash;
import chainnote.model.Bloco;

import java.util.List;

public class ValidadorCadeia {

    private final CalculadoraHash calculadoraHash;

    public ValidadorCadeia(CalculadoraHash calculadoraHash) {
        this.calculadoraHash = calculadoraHash;
    }

    public boolean validar(List<Bloco> blocos) {
        for (int i = 0; i < blocos.size(); i++) {
            Bloco blocoAtual = blocos.get(i);

            String hashCalculado = blocoAtual.calcularHash(calculadoraHash);

            if (!blocoAtual.getHashAtual().equals(hashCalculado)) {
                return false;
            }

            if (i == 0) {
                if (!blocoAtual.getHashAnterior().equals("0")) {
                    return false;
                }
            } else {
                Bloco blocoAnterior = blocos.get(i - 1);

                if (!blocoAtual.getHashAnterior().equals(blocoAnterior.getHashAtual())) {
                    return false;
                }
            }
        }

        return true;
    }
}