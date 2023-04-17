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
 * Descripción de la clase: Esta clase se encarga de realizar la conexion con la
 * clase dao del vehículo para antes hacer validaciones
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class VehiculoServicio {

    private IVehiculoDAO vehiculoDAO;

    /**
     * Constructor por defecto que inicializa un objeto DAOFactory para obtener
     * un objeto IVehiculoDAO.
     */
    public VehiculoServicio() {
        this.vehiculoDAO = new DAOFactory().getVehiculoDAO();
    }

    /**
     * Agrega un nuevo Vehiculo a la base de datos.
     *
     * @param vehiculo El Vehiculo que se desea agregar.
     * @return El Vehiculo agregado.
     * @throws IllegalArgumentException En caso de que haya un error al agregar
     * en la base de datos
     */
    public Vehiculo agregarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        try {
            this.validarDatos(vehiculo);
            return vehiculoDAO.agregarVehiculo(vehiculo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar el vehiculo: " + e.getMessage());
        }
    }

    /**
     * Actualiza un Vehiculo existente en la base de datos.
     *
     * @param vehiculo El Vehiculo que se desea actualizar.
     * @return El Vehiculo actualizado.
     * @throws IllegalArgumentException En caso de que haya un error al
     * actualizar en la base de datos
     */
    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        try {
            this.validarDatos(vehiculo);
            return vehiculoDAO.actualizarVehiculo(vehiculo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo actualizar el vehiculo: " + e.getMessage());
        }
    }

//    public Vehiculo eliminarVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    /**
     * Busca todos los Vehiculos existentes en la base de datos.
     *
     * @return Una lista con todos los Vehiculos de la base de datos.
     * @throws IllegalArgumentException En caso de que haya un error al
     * consultar en la base de datos
     */
    public List<Vehiculo> consultarVehiculos() throws IllegalArgumentException {
        try {
            return vehiculoDAO.consultarVehiculos();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo realizar la consulta de vehiculos: " + e.getMessage());
        }
    }

    /**
     * Busca un Vehiculo existente en la base de datos por su Placa.
     *
     * @param placa La Placa del Vehiculo que se desea buscar.
     * @return El Vehiculo encontrado o null si no existe en la base de datos.
     * @throws IllegalArgumentException En caso de que haya un error al
     * consultar en la base de datos
     */
    public List<Vehiculo> consultarVehiculo(Placa placa) throws IllegalArgumentException {
        try {
            this.validarDatosPlaca(placa);
            return vehiculoDAO.consultarVehiculo(placa);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede realizar la consulta de vehiculos: " + e.getMessage());
        }
    }

    /**
     * Busca un Vehiculo existente en la base de datos.
     *
     * @param vehiculo El Vehiculo que se desea buscar.
     * @return El Vehiculo encontrado o null si no existe en la base de datos.
     * @throws IllegalArgumentException En caso de que haya un error al
     * consultar en la base de datos
     */
    public Vehiculo consultarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
        try {
            return vehiculoDAO.consultarVehiculo(vehiculo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede realizar ña busqueda del vehiculo: " + e.getMessage());
        }
    }

    /**
     * Busca todos los Vehiculos de la base de datos que coinciden con el número
     * de serie dado.
     *
     * @param vehiculo El Vehiculo que contiene el número de serie a buscar.
     * @return Una lista de Vehiculos que tienen el mismo número de serie que el
     * Vehiculo dado.
     * @throws IllegalArgumentException En caso de que haya un error al
     * consultar en la base de datos
     */
    public List<Vehiculo> consultarVehiculoNumeroSerie(Vehiculo vehiculo) throws IllegalArgumentException {
        try {
            return vehiculoDAO.consultarVehiculoNumeroSerie(vehiculo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede realizar la busqueda del vehiculo: " + e.getMessage());
        }
    }

    /**
     * Valida los atributos del objeto vehiculo
     *
     * @param placa objeto a validar
     * @throws ServicioException si algun atributo no sea el correcto
     */
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

    /**
     * Valida los atributos del objeto placa
     *
     * @param placa objeto a validar
     * @throws ServicioException si algun atributo no sea el correcto
     */
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
