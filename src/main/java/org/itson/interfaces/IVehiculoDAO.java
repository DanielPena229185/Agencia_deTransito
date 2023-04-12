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
    
    public Vehiculo agregarVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    public Vehiculo eliminarVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    public Vehiculo consultarVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    public List<Vehiculo> consultarVehiculoNumeroSerie(Vehiculo vehiculo)throws PersistenciaException;
    public List<Vehiculo> consultarVehiculos()throws PersistenciaException;
    public List<Vehiculo> consultarVehiculo(Placa placa)throws PersistenciaException;
}
