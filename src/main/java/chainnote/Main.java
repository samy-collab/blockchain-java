package chainnote;

import chainnote.content.ImagemConteudo;
import chainnote.content.NotaTexto;
import chainnote.content.TransacaoConteudo;
import chainnote.hash.CalculadoraHash;
import chainnote.hash.SHA256Hash;
import chainnote.model.Blockchain;

public class Main {

    public static void main(String[] args) {

        CalculadoraHash calculadoraHash = new SHA256Hash();
        Blockchain blockchain = new Blockchain(calculadoraHash);

        blockchain.adicionarBloco(new NotaTexto("Minha primeira nota"));
        blockchain.adicionarBloco(new ImagemConteudo("foto-casa.png", "Imagem de uma casa"));
        blockchain.adicionarBloco(new NotaTexto("Minha segunda nota"));
        blockchain.adicionarBloco(new TransacaoConteudo("Samuel", "Lucas", 150.00));

        System.out.println("=== BLOCKCHAIN ORIGINAL ===");
        blockchain.listarBlocos();

        System.out.println();
        System.out.println("Blockchain válida antes da adulteração: " + blockchain.validarCadeia());

        blockchain.adulterarBloco(2, new NotaTexto("Conteúdo adulterado por atacante"));

        System.out.println();
        System.out.println("=== BLOCKCHAIN APÓS ADULTERAÇÃO ===");
        blockchain.listarBlocos();

        System.out.println();
        System.out.println("Blockchain válida depois da adulteração: " + blockchain.validarCadeia());
    }
}