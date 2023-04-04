/**
* CostoServicio.java
* 1 abr. 2023 17:18:41
*/ 

package org.itson.servicio;
//importanciones

import org.itson.dominio.Costo;
import org.itson.excepciones.PersistenciaException;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.ICostoDAO;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class CostoServicio {

    private ICostoDAO costoDAO;

    /**
     *
     */
    public CostoServicio() {
        this.costoDAO = new DAOFactory().getCostoDAO();
    }
    
    public Costo agregarCosto(Costo costo)throws PersistenciaException{
         try {
            return costoDAO.agregarCosto(costo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar la persona " + e.getMessage());
        }
    }
}
