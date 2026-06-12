package chainnote.hash;

public interface CalculadoraHash {
    String calcular(String entrada);
}//Se alguém alterar o conteúdo de um bloco, o hash muda e a cadeia fica inválida