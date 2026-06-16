package chainnote;

import chainnote.content.ImagemConteudo;
import chainnote.content.NotaTexto;
import chainnote.hash.CalculadoraHash;
import chainnote.hash.SHA256Hash;
import chainnote.model.Blockchain;
import chainnote.content.TransacaoConteudo;

public class Main {

    public static void main(String[] args) {

        CalculadoraHash calculadoraHash = new SHA256Hash();
        Blockchain blockchain = new Blockchain(calculadoraHash);

        blockchain.adicionarBloco(new NotaTexto("Minha primeira nota"));
        blockchain.adicionarBloco(new ImagemConteudo("foto-casa.png", "Imagem de uma casa"));
        blockchain.adicionarBloco(new NotaTexto("Minha segunda nota"));
        blockchain.adicionarBloco(new TransacaoConteudo("Samuel", "Lucas", 150.00));
        blockchain.listarBlocos();

        System.out.println(
                "Blockchain válida: " + blockchain.validarCadeia()
        );
    }
}