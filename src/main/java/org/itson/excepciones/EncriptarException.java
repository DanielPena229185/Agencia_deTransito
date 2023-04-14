/**
* EncriptarException.java
* 13 abr. 2023 11:43:30
*/ 

package org.itson.excepciones;
//importanciones
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class EncriptarException extends RuntimeException{

    public EncriptarException() {
    }

    public EncriptarException(String message) {
        super(message);
    }

    public EncriptarException(String message, Throwable cause) {
        super(message, cause);
    }
}
