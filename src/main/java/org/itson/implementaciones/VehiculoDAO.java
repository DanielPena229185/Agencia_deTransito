/**
 * VehiculoDAO.java
 * 28 mar. 2023 20:20:47
 */
package org.itson.implementaciones;
//importanciones

import java.util.LinkedList;
import java.util.List;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IVehiculoDAO;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class VehiculoDAO implements IVehiculoDAO {

    public VehiculoDAO() {

    }

    @Override
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehiculo eliminarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehiculo> consultarVehiculos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehiculo> consultarVehiculo(Placa placa) throws PersistenciaException {
        List<Vehiculo> vehiculos = new LinkedList<>();
        String numeroPlaca = placa.getNumero();
        return vehiculos;
    }
}
