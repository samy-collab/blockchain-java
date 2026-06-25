package chainnote.persistencia;

import chainnote.model.Bloco;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEmMemoria implements RepositorioCadeia {

    private List<Bloco> blocosSalvos = new ArrayList<>();

    @Override
    public void salvar(List<Bloco> blocos) {
        this.blocosSalvos = new ArrayList<>(blocos);
    }

    @Override
    public List<Bloco> carregar() {
        return new ArrayList<>(blocosSalvos);
    }
}