/**
 * Encriptador.java
 * 13 abr. 2023 11:37:41
 */
package org.itson.utils;
//importanciones

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class Encriptador {

    private static final char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '!', '#', '$', '&', '/', '(', ')'};
    private static final int SALTO = 9;

    public static String encriptar(String palabra) {
        StringBuilder palabraEncriptada = new StringBuilder();
        for (char c : palabra.toUpperCase().toCharArray()) {
            int indice = buscarIndice(c);
            if (indice != -1) {
                int nuevoIndice = (indice + SALTO) % alfabeto.length;
                palabraEncriptada.append(alfabeto[nuevoIndice]);
            } else {
                palabraEncriptada.append(c);
            }
        }
        return palabraEncriptada.toString();
    }

    public static String desencriptar(String palabraEncriptada) {
        StringBuilder palabraDesencriptada = new StringBuilder();
        for (char c : palabraEncriptada.toUpperCase().toCharArray()) {
            int indice = buscarIndice(c);
            if (indice != -1) {
                int nuevoIndice = (indice - SALTO + alfabeto.length) % alfabeto.length;
                palabraDesencriptada.append(alfabeto[nuevoIndice]);
            } else {
                palabraDesencriptada.append(c);
            }
        }
        return palabraDesencriptada.toString();
    }

    private static int buscarIndice(char c) {
        for (int i = 0; i < alfabeto.length; i++) {
            if (alfabeto[i] == c) {
                return i;
            }
        }
        return -1;
    }
}
