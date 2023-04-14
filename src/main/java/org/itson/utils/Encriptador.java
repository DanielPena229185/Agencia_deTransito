/**
 * Encriptador.java
 * 13 abr. 2023 11:37:41
 */
package org.itson.utils;
//importanciones

/**
 * Descripción de la clase: Esta clase se encarga de realizar un encriptado y
 * desencriptado
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class Encriptador {

    //Este es el módulo en la que se encarga el encriptado o desencriptado
    private static final char[] MODULO = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
        'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
        'V', 'W', 'X', 'Y', 'Z', '!', '#', '$', '&', '/', '(', ')'};
    //Estos son los saltos a hacer para el encriptado o desencriptado
    private static final int SALTO = 9;

    /**
     * Método estatico que se encarga de encriptar cualquier mensaje que se
     * mande por el parámetro
     *
     * @param palabra Palabra que se desea encriptar
     * @return Una cadena que está encriptada con respecto al parámetro
     */
    public static String encriptar(String palabra) {
        StringBuilder palabraEncriptada = new StringBuilder();
        for (char c : palabra.toUpperCase().toCharArray()) {
            int indice = buscarIndice(c);
            if (indice != -1) {
                int nuevoIndice = (indice + SALTO) % MODULO.length;
                palabraEncriptada.append(MODULO[nuevoIndice]);
            } else {
                palabraEncriptada.append(c);
            }
        }
        return palabraEncriptada.toString();
    }

    /**
     * Método estatico que se encarga de desencriptar cualquier mensaje que se
     * mande por el parámetro
     * 
     * @param palabraEncriptada Mensaje que se desee desencriptar
     * @return Mensaje desencriptado con respecto al parámetro
     */
    public static String desencriptar(String palabraEncriptada) {
        StringBuilder palabraDesencriptada = new StringBuilder();
        for (char c : palabraEncriptada.toUpperCase().toCharArray()) {
            int indice = buscarIndice(c);
            if (indice != -1) {
                int nuevoIndice = (indice - SALTO + MODULO.length) % MODULO.length;
                palabraDesencriptada.append(MODULO[nuevoIndice]);
            } else {
                palabraDesencriptada.append(c);
            }
        }
        return palabraDesencriptada.toString();
    }

    private static int buscarIndice(char c) {
        for (int i = 0; i < MODULO.length; i++) {
            if (MODULO[i] == c) {
                return i;
            }
        }
        return -1;
    }
}
