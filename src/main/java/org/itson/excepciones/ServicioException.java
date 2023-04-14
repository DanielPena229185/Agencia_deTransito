/**
 * ObjetoServicioExcepcion.java
 * 1 abr. 2023 16:38:20
 */
package org.itson.excepciones;
//importanciones

/**
 * Descripción de la clase: Descripción de la clase: Esta clase se utiliza para
 * manejar las excepciones que puedan ocurrir en la capa de servicio.
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class ServicioException extends RuntimeException {

    /**
     * Constructor por default
     */
    public ServicioException() {
        super();
    }

    /**
     * Constructor que recibe un mensaje que se mostrará al ocurrir una
     * excepción en la capa de servicio.
     *
     * @param message Mensaje que se desea mostrar al momento de ocurrir un
     * error en la capa de servicio.
     */
    public ServicioException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje y una causa para mostrar la causa del
     * error que ocurrió en la capa de servicio.
     *
     * @param msj Mensaje que se desea mostrar al momento de ocurrir un error en
     * la capa de servicio.
     * @param err Esta es la causa del por qué se genero este error.
     */
    public ServicioException(String msj, Throwable err) {
        super(msj, err);
    }
}
