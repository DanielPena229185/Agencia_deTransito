/**
 * ICostoDAO.java
 * 1 abr. 2023 16:37:32
 */
package org.itson.interfaces;

import org.itson.dominio.Costo;
import org.itson.excepciones.PersistenciaException;

import java.util.List;
import org.itson.dominio.CostoLicencia;
import org.itson.dominio.CostoPlaca;

/**
 * Descripción de la clase: Interfaz donde se implementará para tener la
 * comunicación con la base de datos con respecto a los costos
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public interface ICostoDAO {

    /**
     *
     * @param costo
     * @return
     * @throws PersistenciaException
     */
    public Costo agregarCosto(Costo costo) throws PersistenciaException;

    /**
     * 
     * @param costo
     * @return
     * @throws PersistenciaException 
     */
    public Costo eliminarCosto(Costo costo) throws PersistenciaException;

    /**
     * 
     * @param costo
     * @return
     * @throws PersistenciaException 
     */
    public Costo actualizarCosto(Costo costo) throws PersistenciaException;

    /**
     * 
     * @param vigencia
     * @return
     * @throws PersistenciaException 
     */
    public List<CostoLicencia> consultarCostoLicencias(String vigencia) throws PersistenciaException;

    /**
     * 
     * @return
     * @throws PersistenciaException 
     */
    public List<CostoPlaca> consultarCostoPlacaNuevo() throws PersistenciaException;

    /**
     * 
     * @return
     * @throws PersistenciaException 
     */
    public List<CostoPlaca> consultarCostoPlacaUsado() throws PersistenciaException;

    /**
     * 
     * @return
     * @throws PersistenciaException 
     */
    public List<Costo> consultarCostos() throws PersistenciaException;

    /**
     * 
     * @return
     * @throws PersistenciaException 
     */
    public List<Costo> consultarCostosLicencia() throws PersistenciaException;

    /**
     * 
     * @return
     * @throws PersistenciaException 
     */
    public List<Costo> consultarCostosPlacas() throws PersistenciaException;
}
