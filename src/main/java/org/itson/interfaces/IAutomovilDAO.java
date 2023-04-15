/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Placa;
import org.itson.dominio.Automovil;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la clase: Interfaz donde se implementará para tener la
 * comunicación con la base de datos con respecto a los automóviles
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public interface IAutomovilDAO {

    /**
     * Método que se encarga de agregar un Automóvil
     *
     * @param automovil Automovil que se desea agregar
     * @return Un objeto de tipo Automóvil
     * @throws PersistenciaException En caso de que no se pueda realizar la
     * operación de persistit el automóvil en la base de datos
     */
    public Automovil agregarAutomovil(Automovil automovil) throws PersistenciaException;

    /**
     * Método que se encarga de actualizar en la base de datos un automóvil
     *
     * @param automovil Automóvil que quiere actualizar
     * @return El objeto del automóvil actualizado
     * @throws PersistenciaException En caso que no se pueda realizar la
     * operación de actualizar el automóvil
     */
    public Automovil actualizarAutomovil(Automovil automovil) throws PersistenciaException;

    /**
     * Método que se encarga de eliminar un automóvil en la base de datos
     *
     * @param automovil Automóvil que se desea eliminar
     * @return El objeto del automóvil que se eliminó
     * @throws PersistenciaException En caso de que no se pueda eliminar el
     * automóvil
     */
    public Automovil eliminarAutomovil(Automovil automovil) throws PersistenciaException;

    /**
     * Método que consulta todos los automóviles que pertenecen en la base de
     * datos
     *
     * @return Una lista con todos los automóviles que se conseguieron en la
     * consulta
     * @throws PersistenciaException En caso de que no se pueda realizar la
     * consulta
     */
    public List<Automovil> consultarAutomoviles() throws PersistenciaException;

    /**
     * Consulta todos los automóviles por su placa
     *
     * @param placa Placa que se desea buscar en el filtro
     * @return Una lista de todos los automóvil que cuentan con los placa
     * @throws PersistenciaException En caso de que no se pueda realizar la
     * consulta
     */
    public List<Automovil> consultarAutomoviles(Placa placa) throws PersistenciaException;

}
