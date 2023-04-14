/**
 * ReportePDFException.java
 * 13 abr. 2023 12:07:47
 */
package org.itson.excepciones;
//importanciones

/**
 * Descripción de la clase: La clase ReportePDFException representa una
 * excepción que se lanza cuando ocurre un error al generar un archivo PDF. Esta
 * clase extiende la clase RuntimeException, lo que indica que es una excepción
 * no comprobada, es decir, una excepción que no tiene que ser declarada en la
 * cláusula throws o capturada en un bloque try-catch.
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class ReportePDFException extends RuntimeException {

    /**
     * Constructor vacío sin parámetros. Llama al constructor de la clase padre
     * sin argumentos.
     */
    public ReportePDFException() {
        super();
    }

    /**
     * Constructor que recibe un mensaje de error.
     *
     * @param message El mensaje de error que se desea mostrar.
     */
    public ReportePDFException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje de error y la causa de la excepción.
     *
     * @param message El mensaje de error que se desea mostrar.
     * @param cause La causa de la excepción.
     */
    public ReportePDFException(String message, Throwable cause) {
        super(message, cause);
    }

}
