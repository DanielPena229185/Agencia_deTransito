/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Persona;
import org.itson.dominio.Licencia;
import org.itson.excepciones.PersistenciaException;
import org.itson.utils.ConfiguracionDePaginado;

/**
 * Descripción de la clase: Interfaz donde se implementará para tener la
 * comunicación con la base de datos con respecto a las licencias
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public interface ILicenciaDAO {

    /**
     * Método que se encarga de guardar un trámite de Licencia
     *
     * @param licencia Licencia que se quiere guardar
     * @return La licencia que se guardó
     * @throws PersistenciaException En caso de que no se pueda añadir el
     * trámite
     */
    public Licencia agregarLicencia(Licencia licencia) throws PersistenciaException;

    /**
     * Método que se encarga de actualizar la licencia
     *
     * @param licencia Licencia que se quiere actualizar
     * @return Licencia que se actualizó
     * @throws PersistenciaException En caso de que no se haya podido actualizar
     */
    public Licencia actualizarLicencia(Licencia licencia) throws PersistenciaException;

    /**
     * Método que se encarga de eliminar una licencia
     *
     * @param licencia Licencia que se planea eliminar
     * @return Licencia que se eliminó
     * @throws PersistenciaException En caso de que no se pueda eliminar la
     * licencia
     */
    public Licencia eliminarLicencia(Licencia licencia) throws PersistenciaException;

    /**
     * Método que se encarga de consultar todas las licencias
     *
     * @return Lista de todas las licencias que hay en la base de datos
     * @throws PersistenciaException En caso de que no se haya podido realizar
     * la consulta
     */
    public List<Licencia> consultarLicencias() throws PersistenciaException;

    /**
     * Método que se encarga de consultar todas las licencias dependiendo de la
     * persona
     *
     * @param persona Persona de la que se quiere buscar sus licencias
     * @return Regresa todas las licencias de la persona
     * @throws PersistenciaException En caso de que no se pueda realizar la
     * consulta
     */
    public List<Licencia> consultarLicenciasPersona(Persona persona) throws PersistenciaException;

    /**
     * Método que realiza la consulta por persona y limita para no traer todos
     * los tramites y se configura el páginado
     *
     * @param persona Persona de la que se quiere buscar sus trámites
     * @param paginado La cantidad de partes en la que va a traer los datos en
     * la consulta
     * @return Lista de licencias de la persona
     * @throws PersistenciaException En caso que no pueda realizarce la consulta
     */
    public List<Licencia> consultarLicenciasPersonaPaginado(Persona persona, ConfiguracionDePaginado paginado) throws PersistenciaException;

}
