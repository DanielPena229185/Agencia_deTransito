/**
* ReportePDFException.java
* 13 abr. 2023 12:07:47
*/ 

package org.itson.excepciones;
//importanciones
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ReportePDFException extends RuntimeException{

    public ReportePDFException() {
    }

    public ReportePDFException(String message) {
        super(message);
    }

    public ReportePDFException(String message, Throwable cause) {
        super(message, cause);
    }
}
