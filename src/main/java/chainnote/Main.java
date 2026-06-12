package chainnote;

import chainnote.hash.CalculadoraHash;
import chainnote.hash.SHA256Hash;

public class Main {
    public static void main(String[] args) {
        CalculadoraHash calculadoraHash = new SHA256Hash();

        String texto = "Primeira nota do ChainNote";
        String hash = calculadoraHash.calcular(texto);
//passa a novaa hash
        System.out.println("Texto: " + texto);
        System.out.println("Hash SHA-256: " + hash);
    }
}