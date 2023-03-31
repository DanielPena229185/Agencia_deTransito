/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.servicio;

import java.util.List;
import org.itson.dominio.*;
import org.itson.implementaciones.DAOFactory;
import org.itson.interfaces.*;

/**
 *
 * @author HP
 */
public class AutomovilServicio {

    private IAutomovilDAO automovilDAO;

    /**
     *
     */
    public AutomovilServicio() {
        this.automovilDAO = new DAOFactory().getAutomovilDAO();
    }

    public void validarDatos(Automovil automovil) {
        if (automovil.getNumeroSerie() == null || automovil.getNumeroSerie().trim().isEmpty()) {
            throw new IllegalArgumentException("El numero de serie no puede estar vacío");
        } else if (automovil.getNumeroSerie().length() > 50) {
            throw new IllegalArgumentException("El numero de serie del automovil no debe exceder los 50 caracteres");
        }

        if (automovil.getMarca() == null || automovil.getMarca().trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacía");
        } else if (automovil.getMarca().length() > 100) {
            throw new IllegalArgumentException("La marca del automovil no debe exceder los 100 caracteres");
        }

        if (automovil.getColor() == null || automovil.getColor().trim().isEmpty()) {
            throw new IllegalArgumentException("El color no puede estar vacío");
        } else if (automovil.getColor().length() > 100) {
            throw new IllegalArgumentException("El color del automovil no debe exceder los 100 caracteres");
        }

        if (automovil.getModelo() == null || automovil.getModelo().trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío");
        } else if (automovil.getModelo().length() > 100) {
            throw new IllegalArgumentException("El modelo del automovil no debe exceder los 100 caracteres");
        }

        if (automovil.getLinea() == null || automovil.getLinea().trim().isEmpty()) {
            throw new IllegalArgumentException("La linea no puede estar vacía");
        } else if (automovil.getLinea().length() > 100) {
            throw new IllegalArgumentException("La linea del automovil no debe exceder los 100 caracteres");
        }
    }
    
    
    /**
     * 
     * @param automovil
     * @return
     * @throws IllegalArgumentException 
     */
    public Vehiculo agregarVehiculo(Automovil automovil )throws IllegalArgumentException {
        try {
            this.validarDatos(automovil);
            return automovilDAO.agregarVehiculo(automovil);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar el automovil " + e.getMessage());
        }
    }

    /**
     * 
     * @param automovil
     * @return
     * @throws IllegalArgumentException 
     */
    public Vehiculo actualizarVehiculo(Automovil automovil) throws IllegalArgumentException {
        try {
            this.validarDatos(automovil);
            return automovilDAO.actualizarVehiculo(automovil);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo actualizar el automovil " + e.getMessage());
        }
    }

//    public Vehiculo eliminarVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    
    /**
     * 
     * @return
     * @throws IllegalArgumentException 
     */
    public List<Automovil> consultarVehiculos() throws IllegalArgumentException {
        try {
            return automovilDAO.consultarVehiculos();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo realizar la consulta " + e.getMessage());
        }
    }

    
    public List<Automovil> consultarVehiculo(Placa placa) throws IllegalArgumentException {
        try {
            if (placa == null) {
                throw new IllegalArgumentException("La placa no puede ser nula");
            }
            return automovilDAO.consultarVehiculo(placa);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede realizar la consulta");
        }
    }
}
