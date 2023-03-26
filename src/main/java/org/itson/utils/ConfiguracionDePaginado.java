/**
* ConfiguracionDePaginado.java
* 25 mar. 2023 17:26:03
*/ 

package org.itson.utils;
//importanciones
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ConfiguracionDePaginado {
    
    //Es el número de página
    private int numPagina;
    //Elementos que se observarán por página
    private int elementosPorPagina;

    /**
     * Constructor por omisión
     */
    public ConfiguracionDePaginado(){
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
    public ConfiguracionDePaginado(int numPagina, int elementosPorPagina){
        this.numPagina = numPagina;
        this.elementosPorPagina = elementosPorPagina;
    }

    /**
     * Devuelve el número de página
     * @return el número de página
     */
    public int getNumPagina() {
        return numPagina;
    }

    /**
     * Establece el número de página
     * @param numPagina 
     */
    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    public int getElementosPorPagina() {
        return elementosPorPagina;
    }

    public void setElementosPorPagina(int elementosPorPagina) {
        this.elementosPorPagina = elementosPorPagina;
    }
    
}
