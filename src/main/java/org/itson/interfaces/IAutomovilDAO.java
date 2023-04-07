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
 *
 * @author HP
 */
public interface IAutomovilDAO {

    public Automovil agregarAutomovil(Automovil automovil) throws PersistenciaException;
    public Automovil actualizarAutomovil(Automovil automovil) throws PersistenciaException;
    public Automovil eliminarAutomovil(Automovil automovil) throws PersistenciaException;
    public List<Automovil> consultarAutomoviles() throws PersistenciaException;
    public List<Automovil> consultarAutomoviles(Placa placa) throws PersistenciaException;

}
