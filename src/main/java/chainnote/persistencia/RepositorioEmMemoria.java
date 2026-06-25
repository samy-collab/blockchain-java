package chainnote.persistencia;

import chainnote.model.Bloco;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEmMemoria implements RepositorioCadeia {

    private List<Bloco> blocosSalvos = new ArrayList<>();

    @Override
    public void salvar(List<Bloco> blocos) {
        this.blocosSalvos = copiarBlocos(blocos);
    }

    @Override
    public List<Bloco> carregar() {
        return copiarBlocos(blocosSalvos);
    }

    private List<Bloco> copiarBlocos(List<Bloco> blocos) {
        List<Bloco> copias = new ArrayList<>();

        for (Bloco bloco : blocos) {
            Bloco copia = new Bloco(
                    bloco.getId(),
                    bloco.getTimestamp(),
                    bloco.getConteudo(),
                    bloco.getHashAnterior(),
                    bloco.getHashAtual()
            );

            copias.add(copia);
        }

        return copias;
    }
}