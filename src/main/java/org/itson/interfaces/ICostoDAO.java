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
     * Guardar el costo a la base de datos
     *
     * @param costo el costo a guardar en la base de datos
     * @return costo ya guardado
     * @throws PersistenciaException en el caso de no poder guardarse
     */
    public Costo agregarCosto(Costo costo) throws PersistenciaException;

    /**
     * Eliminar el costo en la base de datos
     *
     * @param costo el costo a eliminar en la base de datos
     * @return costo ya eliminado en la base de datos
     * @throws PersistenciaException en el caso de no poder eliminarse
     */
    public Costo eliminarCosto(Costo costo) throws PersistenciaException;

    /**
     * Actualizar el costo en la base de datos
     *
     * @param costo el costo a actualizar en la base de datos
     * @return costo ya actualizado en la base de datos
     * @throws PersistenciaException en el caso de no poder actualizarse
     */
    public Costo actualizarCosto(Costo costo) throws PersistenciaException;

    /**
     * Consultar el costo con la vigencia ingresada en la base de datos
     *
     * @param vigencia la vigencia a comparar en la base de datos
     * @return Lista de costos con la vigencia comparada en la base de datos
     * @throws PersistenciaException en el caso de no poder consultar los costos
     */
    public List<CostoLicencia> consultarCostoLicencias(String vigencia) throws PersistenciaException;

    /**
     * Consulta el costo de placas nuevas en la base de datos
     *
     * @return Lista de costos de placas nuevas en la base de datos
     * @throws PersistenciaException en el caso de no poder consultar los costos
     */
    public List<CostoPlaca> consultarCostoPlacaNuevo() throws PersistenciaException;

    /**
     * Consulta el costo de placas usadas en la base de datos
     *
     * @return Lista de costos de placas usadas en la base de datos
     * @throws PersistenciaException en el caso de no poder consultar los costos
     */
    public List<CostoPlaca> consultarCostoPlacaUsado() throws PersistenciaException;

    /**
     * Consultar los costos en la base de datos
     *
     * @return Lista de costos en la base de datos
     * @throws PersistenciaException en el caso de no poder consultar los costos
     */
    public List<Costo> consultarCostos() throws PersistenciaException;

    /**
     * Consultar los costos de licencia en la base de datos
     *
     * @return Lista de costos de licencia en la base de datos
     * @throws PersistenciaException en el caso de no poder consultar los costos
     * de las licencias
     */
    public List<Costo> consultarCostosLicencia() throws PersistenciaException;

    /**
     * Consultar los costos de placa en la base de datos
     *
     * @return Lista de costos de placa en la base de datos
     * @throws PersistenciaException en el caso de no poder consultar los costos
     * de las placas
     */
    public List<Costo> consultarCostosPlacas() throws PersistenciaException;
}
