/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.interfaces;

import java.util.Calendar;
import java.util.List;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.PersistenciaException;
import org.itson.utils.ConfiguracionDePaginado;

/**
 *
 * @author HP
 */
public interface IPlacaDAO {
    
    public Placa agregarPlaca(Placa placa)throws PersistenciaException;
    public Placa actualizarPlaca(Placa placa)throws PersistenciaException;
    public Placa eliminarPlaca(Placa placa)throws PersistenciaException;
    public Placa consultarPlaca(Placa placa)throws PersistenciaException;
    public Placa consultarPlacasVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    public List<Placa> consultarPlaca()throws PersistenciaException;
    public List<Placa> consultarPlacasPersona(Persona persona)throws PersistenciaException;
    public List<Placa> consultarPlacasPersonaPaginado(Persona persona, ConfiguracionDePaginado paginado)throws PersistenciaException;
    public List<Placa> consultarPlacasPeriodo(Calendar desde, Calendar hasta, Persona persona)throws PersistenciaException;
    public List<Object[]> consultarPlacasPersonas()throws PersistenciaException;
    public List<Object[]> consultarPlacasPersonasFiltro(String busqueda)throws PersistenciaException;
    public List<Object[]> consultarPlacasPersonasFiltroPaginado(String busqueda, ConfiguracionDePaginado paginado)throws PersistenciaException;
    
}
