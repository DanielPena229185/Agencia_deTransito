package org.itson.excepciones;

/**
 * Descripción de la clase: Excepción personalizada que extiende la clase
 * RuntimeException y se utiliza para manejar excepciones en la capa de
 * persistencia de una aplicación.
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class PersistenciaException extends RuntimeException {

    /**
     * Constructor vacío sin parámetros. Llama al constructor de la clase padre sin argumentos.
     */
    public PersistenciaException() {
        super();
    }

    /**
     * Constructor que recibe un mensaje de error como parámetro, que se mostrará al lanzar la excepción.
     * 
     * @param message El mensaje de error que se desea mostrar.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje de error y la causa de la excepción como parámetros.
     * 
     * @param message El mensaje de error que se desea mostrar.
     * @param cause La causa de la excepción.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

}
