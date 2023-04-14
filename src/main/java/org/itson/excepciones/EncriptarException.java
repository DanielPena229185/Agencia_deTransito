/**
 * EncriptarException.java
 * 13 abr. 2023 11:43:30
 */
package org.itson.excepciones;
//importanciones

/**
 * Descripción de la clase: Esta clase está para analizar y lanzar todos los
 * errores donde esté involucrado la encriptación y desencriptación.
 *
 * Esta clase extiende de la clase RuntimeException, lo cual indica que
 * cualquier error que ocurra en la capa de encriptación y desencriptación será
 * tratado como una excepción no verificada.
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class EncriptarException extends RuntimeException {

    /**
     * Constructor por default
     */
    public EncriptarException() {
        super();
    }

    /**
     * Constructor que recibe como parámetro un mensaje el cuál se especifica
     * dependiendo del error y lo que se esté realizando
     *
     * @param message Mensaje que quieres mostrar al momento de ocurrir un error
     * especifico
     */
    public EncriptarException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe como parámetro un mensaje el cuál se especifica
     * dependiendo del error y lo que se esté realizando y su causa
     *
     * @param message Mensaje que quieres mostrar al momento de ocurrir un error
     * especifico
     * @param cause Esta es la causa del por qué se genero este error
     */
    public EncriptarException(String message, Throwable cause) {
        super(message, cause);
    }
}
