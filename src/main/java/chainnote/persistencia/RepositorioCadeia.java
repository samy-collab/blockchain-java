package chainnote.persistencia;

import chainnote.model.Bloco;

import java.util.List;

public interface RepositorioCadeia {

    void salvar(List<Bloco> blocos);

    List<Bloco> carregar();
}