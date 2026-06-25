package chainnote;

import chainnote.content.NotaTexto;
import chainnote.hash.SHA256Hash;
import chainnote.model.Blockchain;
import chainnote.model.Bloco;
import chainnote.validacao.ValidadorCadeia;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlockchainTest {

    @Test
    void deveCriarBlockchainVazia() {
        Blockchain blockchain = new Blockchain(new SHA256Hash());

        assertTrue(blockchain.getBlocos().isEmpty());
    }

    @Test
    void deveAdicionarPrimeiroBlocoComHashAnteriorZero() {
        Blockchain blockchain = new Blockchain(new SHA256Hash());

        blockchain.adicionarBloco(new NotaTexto("Brasil hexa"));

        List<Bloco> blocos = blockchain.getBlocos();

        assertEquals(1, blocos.size());
        assertEquals("0", blocos.get(0).getHashAnterior());
        assertNotNull(blocos.get(0).getHashAtual());
    }

    @Test
    void deveAdicionarSegundoBlocoLigadoAoPrimeiro() {
        Blockchain blockchain = new Blockchain(new SHA256Hash());

        blockchain.adicionarBloco(new NotaTexto("Primeira nota"));
        blockchain.adicionarBloco(new NotaTexto("Segunda nota"));

        List<Bloco> blocos = blockchain.getBlocos();

        Bloco primeiroBloco = blocos.get(0);
        Bloco segundoBloco = blocos.get(1);

        assertEquals(2, blocos.size());
        assertEquals(primeiroBloco.getHashAtual(), segundoBloco.getHashAnterior());
    }

    @Test
    void deveValidarBlockchainCorreta() {
        Blockchain blockchain = new Blockchain(new SHA256Hash());

        blockchain.adicionarBloco(new NotaTexto("Primeira nota"));
        blockchain.adicionarBloco(new NotaTexto("Segunda nota"));

        ValidadorCadeia validador = new ValidadorCadeia(new SHA256Hash());

        assertTrue(validador.validar(blockchain.getBlocos()));
    }

    @Test
    void deveInvalidarBlockchainAdulterada() {
        Blockchain blockchain = new Blockchain(new SHA256Hash());

        blockchain.adicionarBloco(new NotaTexto("Primeira nota"));
        blockchain.adicionarBloco(new NotaTexto("Segunda nota"));

        blockchain.adulterarBloco(1, new NotaTexto("Nota adulterada"));

        ValidadorCadeia validador = new ValidadorCadeia(new SHA256Hash());

        assertFalse(validador.validar(blockchain.getBlocos()));
    }
}
