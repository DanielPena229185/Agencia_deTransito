/**
* ObjetoServicioExcepcion.java
* 1 abr. 2023 16:38:20
*/ 

package org.itson.excepciones;
//importanciones
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ServicioException extends RuntimeException{

    /**
     * 
     */
    public ServicioException(){
        super();
    }

    /**
     * 
     * @param message 
     */
    public ServicioException(String message) {
        super(message);
    }

    /**
     * 
     * @param msj
     * @param err
     */
    public ServicioException(String msj, Throwable err){
        super(msj, err);
    }
}
