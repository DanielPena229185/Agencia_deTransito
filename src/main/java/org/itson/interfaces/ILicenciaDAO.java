 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.interfaces;

import java.util.Calendar;
import java.util.List;
import org.itson.dominio.Persona;
import org.itson.dominio.Licencia;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author HP
 */
public interface ILicenciaDAO {
    
    public Licencia agregarLicencia(Licencia licencia)throws PersistenciaException;
    public Licencia actualizarLicencia(Licencia licencia)throws PersistenciaException;
    public Licencia eliminarLicencia(Licencia licencia)throws PersistenciaException;
    public List<Licencia> consultarLicencias()throws PersistenciaException;
    public List<Licencia> consultarLicenciasPersona(Persona persona)throws PersistenciaException;
    public List<Licencia> consultarLicenciaPeriodo(Calendar desde, Calendar hasta, Persona persona)throws PersistenciaException;
    
}
