/**
* ICostoDAO.java
* 1 abr. 2023 16:37:32
*/ 

package org.itson.interfaces;

import org.itson.dominio.Costo;
import org.itson.excepciones.PersistenciaException;

import java.util.List;
import org.itson.dominio.CostoLicencia;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface ICostoDAO {

    public Costo agregarCosto(Costo costo)throws PersistenciaException;
    public Costo eliminarCosto(Costo costo) throws PersistenciaException;
    public Costo actualizarCosto(Costo costo)throws PersistenciaException;
    public List<CostoLicencia> consultarCostoLicencias(String vigencia)throws PersistenciaException;
    public List<Costo> consultarCostos()throws PersistenciaException;
    public List<Costo> consultarCostosLicencia()throws PersistenciaException;
    public List<Costo> consultarCostosPlacas()throws PersistenciaException;
}
