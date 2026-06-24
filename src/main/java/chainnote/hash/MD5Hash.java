package chainnote.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash implements CalculadoraHash {

    @Override
    public String calcular(String entrada) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hashBytes = digest.digest(entrada.getBytes());

            StringBuilder hashHexadecimal = new StringBuilder();

            for (byte b : hashBytes) {
                hashHexadecimal.append(String.format("%02x", b));
            }

            return hashHexadecimal.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao calcular hash MD5", e);
        }
    }
}