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
    
    public AutomovilServicio() {
        this.automovilDAO = new DAOFactory().getAutomovilDAO();
    }
    
    public Vehiculo agregarAutomovil(Automovil automovil) throws IllegalArgumentException {
        try {
            this.validarDatos(automovil);
            return automovilDAO.agregarAutomovil(automovil);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede agregar el automovil: " + e.getMessage());
        }
    }
    
    public Vehiculo actualizarAutomovil(Automovil automovil) throws IllegalArgumentException {
        try {
            this.validarDatos(automovil);
            return automovilDAO.actualizarAutomovil(automovil);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo actualizar el automovil: " + e.getMessage());
        }
    }

//    public Vehiculo eliminarVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    public List<Automovil> consultarAutomoviles() throws IllegalArgumentException {
        try {
            return automovilDAO.consultarAutomoviles();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se pudo realizar la consulta: " + e.getMessage());
        }
    }
    
    public List<Automovil> consultarAutomoviles(Placa placa) throws IllegalArgumentException {
        try {
            this.validarDatosPlaca(placa);
            return automovilDAO.consultarAutomoviles(placa);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede realizar la consulta: " + e.getMessage());
        }
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
