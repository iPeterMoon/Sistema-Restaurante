package itson.sistemarestaurantenegocio.seguridad;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Cifrado {

    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "f2c3e9a7d4b9c5e1f4d0a1b6c9e0a2f3".getBytes(); // Clave de 16 bytes (128 bits)

    /**
     * Cifra un texto usando el algoritmo AES.
     *
     * @param texto Texto a cifrar.
     * @return Texto cifrado en Base64.
     * @throws Exception Si ocurre un error durante el cifrado.
     */
    public static String cifrar(String texto) throws Exception {
        SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] textoCifrado = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(textoCifrado);
    }

    /**
     * Descifra un texto cifrado usando el algoritmo AES.
     *
     * @param textoCifrado Texto cifrado en Base64.
     * @return Texto descifrado.
     * @throws Exception Si ocurre un error durante el descifrado.
     */
    public static String descifrar(String textoCifrado) throws Exception {
        SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] textoDescifrado = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
        return new String(textoDescifrado);
    }
}