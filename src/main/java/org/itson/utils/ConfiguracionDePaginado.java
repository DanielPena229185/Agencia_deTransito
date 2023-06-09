/**
 * ConfiguracionDePaginado.java
 * 25 mar. 2023 17:26:03
 */
package org.itson.utils;
//importanciones

/**
 * Descripción de la clase: Esta clase se dedica a realizar el paginado
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class ConfiguracionDePaginado {

    //Es el número de página
    private int numPagina;
    //Elementos que se observarán por página
    private int elementosPorPagina;

    /**
     * Constructor por omisión
     */
    public ConfiguracionDePaginado() {
        this.numPagina = 0;
        this.elementosPorPagina = 3;
    }

    /**
     * Constructor que inicializa los valores en cierta página con cierta
     * cantidad de elementos por página
     *
     * @param numPagina Número de la página que se va a ver
     * @param elementosPorPagina Cantidad de elementos que deseas ver
     */
    public ConfiguracionDePaginado(int numPagina, int elementosPorPagina) {
        this.numPagina = numPagina;
        this.elementosPorPagina = elementosPorPagina;
    }

    /**
     * Devuelve el número de página
     *
     * @return el número de página
     */
    public int getNumPagina() {
        return numPagina;
    }

    /**
     * Establece el número de página
     *
     * @param numPagina numero de página
     */
    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    /**
     * Regresa el número de elementos por página
     * 
     * @return Los elementos por página
     */
    public int getElementosPorPagina() {
        return elementosPorPagina;
    }

    /**
     * Establece los elementos por página
     * 
     * @param elementosPorPagina Los elementos por página
     */
    public void setElementosPorPagina(int elementosPorPagina) {
        this.elementosPorPagina = elementosPorPagina;
    }

    /**
     * Metodo que avanza de pagina.
     */
    public void avanzarPagina() {
        this.numPagina++;
    }

    /**
     * Metodo que retrocede la pagina.
     */
    public void retrocederPagina() {
        if (this.numPagina > 1) {
            this.numPagina--;
        }
    }

}
