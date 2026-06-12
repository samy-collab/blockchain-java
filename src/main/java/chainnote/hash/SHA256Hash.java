package chainnote.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Hash implements CalculadoraHash {

    @Override
    public String calcular(String entrada) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(entrada.getBytes());

            StringBuilder hexadecimal = new StringBuilder();

            for (byte b : hashBytes) {
                String valorHexadecimal = Integer.toHexString(0xff & b);

                if (valorHexadecimal.length() == 1) {
                    hexadecimal.append('0');
                }

                hexadecimal.append(valorHexadecimal);
            }

            return hexadecimal.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao calcular hash SHA-256", e);
        }
    }
}

//Gera uma impressao digital , ou seja criptografa tudo