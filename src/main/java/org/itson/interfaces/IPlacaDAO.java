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
 * Descripción de la clase: Interfaz donde se implementará para tener la
 * comunicación con la base de datos con respecto a las personas
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public interface IPlacaDAO {

    /**
     *
     * Agrega una nueva placa al sistema.
     *
     * @param placa la placa a agregar al sistema.
     * @return la placa agregada al sistema.
     * @throws PersistenciaException si ocurre un error al interactuar con el
     * sistema de persistencia.
     */
    public Placa agregarPlaca(Placa placa) throws PersistenciaException;

    /**
     * Actualiza la información de una placa existente en la base de datos.
     *
     * @param placa la placa a actualizar
     * @return la placa actualizada
     * @throws PersistenciaException si ocurre un error al acceder a la base de
     * datos
     */
    public Placa actualizarPlaca(Placa placa) throws PersistenciaException;

    /**
     * Elimina una placa existente en la base de datos.
     *
     * @param placa la placa a eliminar
     * @return la placa eliminada
     * @throws PersistenciaException si ocurre un error al acceder a la base de
     * datos
     */
    public Placa eliminarPlaca(Placa placa) throws PersistenciaException;

    /**
     *
     * Consulta una placa en la base de datos.
     *
     * @param placa La placa a consultar.
     * @return La placa consultada.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    public Placa consultarPlaca(Placa placa) throws PersistenciaException;

    /**
     *
     * Consulta la placa asociada a un vehículo en la base de datos.
     *
     * @param vehiculo El vehículo del cual se desea consultar la placa.
     * @return La placa asociada al vehículo consultado.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    public Placa consultarPlacasVehiculo(Vehiculo vehiculo) throws PersistenciaException;

    /**
     * Devuelve una lista de todas las placas registradas en el sistema.
     *
     * @return una lista de todas las placas registradas en el sistema.
     * @throws PersistenciaException si ocurre algún error al interactuar con el
     * almacenamiento persistente.
     */
    public List<Placa> consultarPlaca() throws PersistenciaException;

    /**
     * Devuelve una lista de todas las placas registradas en el sistema que
     * están asociadas con una persona dada.
     *
     * @param persona la persona para la cual se desea obtener las placas
     * asociadas.
     * @return una lista de todas las placas registradas en el sistema que están
     * asociadas con la persona dada.
     * @throws PersistenciaException si ocurre algún error al interactuar con el
     * almacenamiento persistente.
     */
    public List<Placa> consultarPlacasPersona(Persona persona) throws PersistenciaException;

    /**
     * Consulta las placas de una persona de forma paginada.
     *
     * @param persona La persona de la que se quieren consultar las placas.
     * @param paginado La configuración de paginado que se quiere utilizar.
     * @return La lista de placas de la persona consultada, de acuerdo a la
     * configuración de paginado especificada.
     * @throws PersistenciaException Si ocurre un error en la operación de
     * consulta.
     */
    public List<Placa> consultarPlacasPersonaPaginado(Persona persona, ConfiguracionDePaginado paginado) throws PersistenciaException;

    /**
     * Consulta las placas de una persona en un período de tiempo específico.
     *
     * @param desde La fecha de inicio del período de tiempo.
     * @param hasta La fecha de fin del período de tiempo.
     * @param persona La persona de la que se quieren consultar las placas.
     * @return La lista de placas de la persona consultada que se encontraron
     * dentro del período de tiempo especificado.
     * @throws PersistenciaException Si ocurre un error en la operación de
     * consulta.
     */
    public List<Placa> consultarPlacasPeriodo(Calendar desde, Calendar hasta, Persona persona) throws PersistenciaException;

    /**
     * Obtiene la lista de placas de todos los vehículos asociados a sus
     * respectivos dueños.
     *
     * @return una lista de matrices de objetos, donde cada fila contiene la
     * información de la placa, el vehículo y la persona propietaria.
     * @throws PersistenciaException si ocurre un error al interactuar con el
     * sistema de persistencia de datos.
     */
    public List<Object[]> consultarPlacasPersonas() throws PersistenciaException;

    /**
     * Obtiene la lista de placas de los vehículos asociados a las personas cuyo
     * nombre, número de identificación o dirección contengan la cadena
     * especificada en el parámetro de búsqueda.
     *
     * @param busqueda la cadena de texto a buscar en los datos de las personas
     * asociadas a los vehículos.
     * @return una lista de matrices de objetos, donde cada fila contiene la
     * información de la placa, el vehículo y la persona propietaria.
     * @throws PersistenciaException si ocurre un error al interactuar con el
     * sistema de persistencia de datos.
     */
    public List<Object[]> consultarPlacasPersonasFiltro(String busqueda) throws PersistenciaException;

    /**
     * Busca y retorna una lista de objetos que contienen la información de la
     * placa y la persona asociada a dicha placa, filtrando los resultados según
     * el valor de búsqueda proporcionado, y aplicando paginación a los
     * resultados.
     *
     * @param busqueda valor de búsqueda para filtrar los resultados de la
     * consulta.
     * @param paginado configuración de paginación a aplicar a los resultados de
     * la consulta.
     * @return lista de objetos que contienen la información de la placa y la
     * persona asociada a dicha placa.
     * @throws PersistenciaException si ocurre algún error durante la ejecución
     * de la consulta.
     */
    public List<Object[]> consultarPlacasPersonasFiltroPaginado(String busqueda, ConfiguracionDePaginado paginado) throws PersistenciaException;

}
