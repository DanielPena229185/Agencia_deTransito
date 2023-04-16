/**
 * Encriptador.java
 * 13 abr. 2023 11:37:41
 */
package org.itson.utils;
//importanciones

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.itson.excepciones.EncriptarException;

/**
 * Descripción de la clase: Clase que proporciona métodos para encriptar y
 * desencriptar cadenas de texto utilizando el algoritmo AES.
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class Encriptador {

    private static final String clave = "itson_nainary256";

    /**
     * Encripta una cadena de texto utilizando el algoritmo AES.
     *
     * @param texto La cadena de texto a encriptar.
     * @return La cadena de texto encriptada.
     */
    public static String encriptar(String texto) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textoEnBytes = texto.getBytes("UTF-8");
            byte[] textoEncriptado = cipher.doFinal(textoEnBytes);
            return Base64.getEncoder().encodeToString(textoEncriptado);
        } catch (Exception e) {
            throw new RuntimeException("Error al encriptar el texto", e);
        }
    }

    /**
     * Desencripta una cadena de texto previamente encriptada con el algoritmo
     * AES.
     *
     * @param palabraEncriptada La cadena de texto encriptada.
     * @return La cadena de texto desencriptada.
     */
    public static String desencriptar(String palabraEncriptada) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(clave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] textoEncriptadoEnBytes = Base64.getDecoder().decode(palabraEncriptada);
            byte[] textoDesencriptadoEnBytes = cipher.doFinal(textoEncriptadoEnBytes);
            return new String(textoDesencriptadoEnBytes, "UTF-8");
        } catch (Exception e) {
            throw new EncriptarException("Error: " + e.getMessage(), e);
        }
    }

}
