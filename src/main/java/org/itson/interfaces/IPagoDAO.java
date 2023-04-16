/**
 * IPagoDAO.java
 * 29 mar. 2023 09:44:47
 */
package org.itson.interfaces;

import java.util.Calendar;
import java.util.List;
import org.itson.dominio.Pago;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la clase: Interfaz donde se implementará para tener la
 * comunicación con la base de datos con respecto a los pagos
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public interface IPagoDAO {

    /**
     * Agrega un pago a la base de datos.
     *
     * @param pago Pago que se desea guardar en la base de datos.
     * @return Pago que se guardó en la base de datos.
     * @throws PersistenciaException Si no se puede guardar el pago en la base
     * de datos.
     */
    public Pago agregarPago(Pago pago) throws PersistenciaException;

    /**
     * Elimina un pago de la base de datos.
     *
     * @param pago Pago que se desea eliminar de la base de datos.
     * @throws PersistenciaException Si no se puede eliminar el pago de la base
     * de datos.
     */
    public void eliminarPago(Pago pago) throws PersistenciaException;

    /**
     * Actualiza los datos de un pago en la base de datos.
     *
     * @param pago Pago que se desea actualizar en la base de datos.
     * @return Pago que se actualizó en la base de datos.
     * @throws PersistenciaException Si no se puede actualizar el pago en la
     * base de datos.
     */
    public Pago actualizarPago(Pago pago) throws PersistenciaException;

    /**
     * Consulta un pago en la base de datos.
     *
     * @param pago Pago que se desea consultar en la base de datos.
     * @return Pago consultado en la base de datos.
     * @throws PersistenciaException Si no se puede consultar el pago en la base
     * de datos.
     */
    public Pago consultarPago(Pago pago) throws PersistenciaException;

    /**
     * Consulta todos los pagos en la base de datos.
     *
     * @return Lista de todos los pagos en la base de datos.
     * @throws PersistenciaException Si no se puede realizar la consulta en la
     * base de datos.
     */
    public List<Pago> consultarPagos() throws PersistenciaException;

    /**
     * Consulta todos los pagos realizados en una fecha específica.
     *
     * @param fecha Fecha a consultar.
     * @return Lista de todos los pagos realizados en la fecha especificada.
     * @throws PersistenciaException Si no se puede realizar la consulta en la
     * base de datos.
     */
    public List<Pago> consultarPagosFecha(Calendar fecha) throws PersistenciaException;

}
