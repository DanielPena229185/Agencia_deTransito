package org.itson.excepciones;

public class PersistenciaException extends RuntimeException {

    /**
     * Constructor que se encarga de entrar a la super clase RunTimeException
     */
    public PersistenciaException() {
        super();
    }

    /**
     * Constructor que se encarga de entrar a la super clase RunTimeExcpetion
     *
     * @param msj Mensaje de la excepción.
     */
    public PersistenciaException(String msj) {
        super(msj);
    }
}
