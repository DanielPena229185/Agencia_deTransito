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
public class ObjetoServicioExcepcion extends RuntimeException{

    /**
     * 
     */
    public ObjetoServicioExcepcion(){
        super();
    }

    /**
     * 
     * @param message 
     */
    public ObjetoServicioExcepcion(String message) {
        super(message);
    }

    /**
     * 
     * @param msj
     * @param err
     */
    public ObjetoServicioExcepcion(String msj, Throwable err){
        super(msj, err);
    }
}
