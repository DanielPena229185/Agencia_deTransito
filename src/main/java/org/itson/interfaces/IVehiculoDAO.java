/**
 * IVehiculoDAO.java
 * 28 mar. 2023 19:51:25
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la interface:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IVehiculoDAO {

    /**
     * Agrega un nuevo Vehiculo a la base de datos.
     *
     * @param vehiculo El Vehiculo que se desea agregar.
     * @return El Vehiculo agregado.
     * @throws PersistenciaException En caso de que haya un error al agregar en la base de datos
     */
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws PersistenciaException;

    /**
     * Actualiza un Vehiculo existente en la base de datos.
     *
     * @param vehiculo El Vehiculo que se desea actualizar.
     * @return El Vehiculo actualizado.
     * @throws PersistenciaException En caso de que haya un error al actualizar en la base de datos
     */
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) throws PersistenciaException;

    /**
     * Elimina un Vehiculo existente en la base de datos.
     *
     * @param vehiculo El Vehiculo que se desea eliminar.
     * @return El Vehiculo eliminado.
     * @throws PersistenciaException En caso de que haya un error al eliminar en la base de datos
     */
    public Vehiculo eliminarVehiculo(Vehiculo vehiculo) throws PersistenciaException;

    /**
     * Busca un Vehiculo existente en la base de datos.
     *
     * @param vehiculo El Vehiculo que se desea buscar.
     * @return El Vehiculo encontrado o null si no existe en la base de datos.
     * @throws PersistenciaException En caso de que haya un error al consultar en la base de datos
     */
    public Vehiculo consultarVehiculo(Vehiculo vehiculo) throws PersistenciaException;

    /**
     * Busca todos los Vehiculos de la base de datos que coinciden con el número
     * de serie dado.
     *
     * @param vehiculo El Vehiculo que contiene el número de serie a buscar.
     * @return Una lista de Vehiculos que tienen el mismo número de serie que el
     * Vehiculo dado.
     * @throws PersistenciaException En caso de que haya un error al consultar en la base de datos
     */
    public List<Vehiculo> consultarVehiculoNumeroSerie(Vehiculo vehiculo) throws PersistenciaException;

    /**
     * Busca todos los Vehiculos existentes en la base de datos.
     *
     * @return Una lista con todos los Vehiculos de la base de datos.
     * @throws PersistenciaException En caso de que haya un error al consultar en la base de datos
     */
    public List<Vehiculo> consultarVehiculos() throws PersistenciaException;

    /**
     * Busca un Vehiculo existente en la base de datos por su Placa.
     *
     * @param placa La Placa del Vehiculo que se desea buscar.
     * @return El Vehiculo encontrado o null si no existe en la base de datos.
     * @throws PersistenciaException En caso de que haya un error al consultar en la base de datos
     */
    public List<Vehiculo> consultarVehiculo(Placa placa) throws PersistenciaException;
}
