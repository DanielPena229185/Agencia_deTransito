/**
 * CostoServicio.java
 * 1 abr. 2023 17:18:41
 */
package org.itson.servicio;
//importanciones

import java.util.List;
import org.itson.dominio.Costo;
import org.itson.dominio.CostoLicencia;
import org.itson.dominio.CostoPlaca;
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

    public Costo agregarCosto(Costo costo) throws PersistenciaException {
        try {
            return costoDAO.agregarCosto(costo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar el costo " + e.getMessage());
        }
    }

    public List<CostoLicencia> consultarCostoLicencias(String vigencia) throws PersistenciaException {
        try {
            return costoDAO.consultarCostoLicencias(vigencia);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede consultar el costo " + e.getMessage());
        }
    }
    
    public List<CostoPlaca> consultarCostoPlacaNueva()throws PersistenciaException{
        try {
            return costoDAO.consultarCostoPlacaNuevo();
        } catch (Exception e) {
            throw new PersistenciaException("No se puede consultar el costo " + e.getMessage(), e);
        }
    }
}
