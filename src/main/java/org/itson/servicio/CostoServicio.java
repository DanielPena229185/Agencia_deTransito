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
import org.itson.excepciones.ServicioException;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.ICostoDAO;

/**
 * Descripción de la clase: Esta clase se encarga de realizar la conexion con la
 * clase dao del costo para antes hacer validaciones
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class CostoServicio {

    private ICostoDAO costoDAO;

    /**
     * Constructor por defecto que inicializa un objeto DAOFactory para obtener
     * un objeto ICostoDAO.
     */
    public CostoServicio() {
        this.costoDAO = new DAOFactory().getCostoDAO();
    }

    /**
     * Guardar el costo a la base de datos
     *
     * @param costo el costo a guardar en la base de datos
     * @return costo ya guardado
     * @throws ServicioException en el caso de no poder guardarse
     */
    public Costo agregarCosto(Costo costo) throws ServicioException {
        try {
            return costoDAO.agregarCosto(costo);
        } catch (PersistenciaException e) {
            throw new ServicioException("No se puede agregar el costo: " + e.getMessage());
        }
    }

    /**
     * Consultar los costos en la base de datos
     *
     * @return Lista de costos en la base de datos
     * @throws ServicioException en el caso de no poder consultar los costos
     */
    public List<Costo> consultarCostos() {
        try {
            return costoDAO.consultarCostos();
        } catch (PersistenciaException e) {
            throw new ServicioException("No se puede consultar los costos: " + e.getMessage());
        }
    }

    /**
     * Consultar el costo con la vigencia ingresada en la base de datos
     *
     * @param vigencia la vigencia a comparar en la base de datos
     * @return Lista de costos con la vigencia comparada en la base de datos
     * @throws ServicioException en el caso de no poder consultar los costos
     */
    public List<CostoLicencia> consultarCostoLicencias(String vigencia) throws ServicioException {
        try {
            return costoDAO.consultarCostoLicencias(vigencia);
        } catch (PersistenciaException e) {
            throw new ServicioException("No se puede consultar el costo: " + e.getMessage());
        }
    }

    /**
     * Consulta el costo de placas nuevas en la base de datos
     *
     * @return Lista de costos de placas nuevas en la base de datos
     * @throws ServicioException en el caso de no poder consultar los costos
     */
    public List<CostoPlaca> consultarCostoPlacaNueva() throws ServicioException {
        try {
            return costoDAO.consultarCostoPlacaNuevo();
        } catch (PersistenciaException e) {
            throw new ServicioException("No se puede consultar el costo: " + e.getMessage(), e);
        }
    }

    /**
     * Consulta el costo de placas usadas en la base de datos
     *
     * @return Lista de costos de placas usadas en la base de datos
     * @throws ServicioException en el caso de no poder consultar los costos
     */
    public List<CostoPlaca> consultarCostoPlacaUsado() throws ServicioException {
        try {
            return costoDAO.consultarCostoPlacaUsado();
        } catch (PersistenciaException e) {
            throw new ServicioException("No se puede consultar el costo: " + e.getMessage(), e);
        }
    }
}
