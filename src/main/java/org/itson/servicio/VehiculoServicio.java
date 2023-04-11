/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.servicio;

import java.util.List;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.IVehiculoDAO;

/**
 *
 * @author HP
 */
public class VehiculoServicio {

    private IVehiculoDAO vehiculoDAO;

    public VehiculoServicio() {
        this.vehiculoDAO = new DAOFactory().getVehiculoDAO();
    }

    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        try {
            this.validarDatos(vehiculo);
            return vehiculoDAO.agregarVehiculo(vehiculo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar el vehiculo: " + e.getMessage());
        }
    }

    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        try {
            this.validarDatos(vehiculo);
            return vehiculoDAO.actualizarVehiculo(vehiculo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo actualizar el vehiculo: " + e.getMessage());
        }
    }

//    public Vehiculo eliminarVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    public List<Vehiculo> consultarVehiculos() throws IllegalArgumentException {
        try {
            return vehiculoDAO.consultarVehiculos();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo realizar la consulta de vehiculos: " + e.getMessage());
        }
    }

    public List<Vehiculo> consultarVehiculo(Placa placa) throws IllegalArgumentException {
        try {
            this.validarDatosPlaca(placa);
            return vehiculoDAO.consultarVehiculo(placa);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede realizar la consulta de vehiculos: " + e.getMessage());
        }
    }

    public Vehiculo consultarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        try {
            return vehiculoDAO.consultarVehiculo(vehiculo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede realizar ña busqueda del vehiculo: " + e.getMessage());
        }
    }

    public void validarDatos(Vehiculo vehiculo) {
        if (vehiculo.getNumeroSerie() == null || vehiculo.getNumeroSerie().trim().isEmpty()) {
            throw new IllegalArgumentException("El numero de serie no puede estar vacío");
        } else if (vehiculo.getNumeroSerie().length() > 50) {
            throw new IllegalArgumentException("El numero de serie del vehiculo no debe exceder los 50 caracteres");
        }

        if (vehiculo.getMarca() == null || vehiculo.getMarca().trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacía");
        } else if (vehiculo.getMarca().length() > 100) {
            throw new IllegalArgumentException("La marca del vehiculo no debe exceder los 100 caracteres");
        }

        if (vehiculo.getColor() == null || vehiculo.getColor().trim().isEmpty()) {
            throw new IllegalArgumentException("El color no puede estar vacío");
        } else if (vehiculo.getColor().length() > 100) {
            throw new IllegalArgumentException("El color del vehiculo no debe exceder los 100 caracteres");
        }

        if (vehiculo.getModelo() == null || vehiculo.getModelo().trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío");
        } else if (vehiculo.getModelo().length() > 100) {
            throw new IllegalArgumentException("El modelo del vehiculo no debe exceder los 100 caracteres");
        }

        if (vehiculo.getLinea() == null || vehiculo.getLinea().trim().isEmpty()) {
            throw new IllegalArgumentException("La linea no puede estar vacía");
        } else if (vehiculo.getLinea().length() > 100) {
            throw new IllegalArgumentException("La linea del vehiculo no debe exceder los 100 caracteres");
        }
    }

    public void validarDatosPlaca(Placa placa) throws IllegalArgumentException {
        if (placa.getEstado() == null) {
            throw new IllegalArgumentException("El estado no puede ser nula");
        }

        if (placa.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        if (placa.getFechaExpedicion() == null) {
            throw new IllegalArgumentException("La fecha y hora no pueden ser nulas");
        }

        if (placa.getPersona() == null) {
            throw new IllegalArgumentException("El persona del tramite es requerido");
        }
    }

}
