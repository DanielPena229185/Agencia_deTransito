/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.implementaciones;

import org.itson.interfaces.*;

/**
 * Descripción de la clase: Esta clase se encarga de realizar la conexión con la
 * base de datos
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
public class DAOFactory {

    //Cambiar para que corra
    /**
     * Conexión a la base de datos
     */
    ConexionBD conexion = new ConexionBD("org.itson.sistema_AgenciaDeTransito_jar_1.0-SNAPSHOTPU");

    /**
     * Devuelve la conexión a la base de dato para la clase PagoDAO
     *
     * @return conexión a la base de dato para la clase PagoDAO
     */
    public IPagoDAO getPagoDAO() {
        return new PagoDAO(conexion);
    }

    /**
     * Devuelve la conexión a la base de dato para la clase PesonaDAO
     *
     * @return conexión a la base de dato para la clase PesonaDAO
     */
    public IPersonaDAO getPersonaDAO() {
        return new PersonaDAO(conexion);
    }

    /**
     * Devuelve la conexión a la base de dato para la clase TramiteDAO
     *
     * @return conexión a la base de dato para la clase TramiteDAO
     */
    public ITramiteDAO getTramiteDAO() {
        return new TramiteDAO(conexion);
    }

    /**
     * Devuelve la conexión a la base de dato para la clase VehiculoDAO
     *
     * @return conexión a la base de dato para la clase VehiculoDAO
     */
    public IVehiculoDAO getVehiculoDAO() {
        return new VehiculoDAO(conexion);
    }

    /**
     * Devuelve la conexión a la base de dato para la clase AutomovilDAO
     *
     * @return conexión a la base de dato para la clase AutomovilDAO
     */
    public IAutomovilDAO getAutomovilDAO() {
        return new AutomovilDAO(conexion);
    }

    /**
     * Devuelve la conexión a la base de dato para la clase LicenciaDAO
     *
     * @return conexión a la base de dato para la clase LicenciaDAO
     */
    public ILicenciaDAO getLicenciaDAO() {
        return new LicenciaDAO(conexion);
    }

    /**
     * Devuelve la conexión a la base de dato para la clase PlacaDAO
     *
     * @return conexión a la base de dato para la clase PlacaDAO
     */
    public IPlacaDAO getPlacaDAO() {
        return new PlacaDAO(conexion);
    }

    /**
     * Devuelve la conexión a la base de dato para la clase CostoDAO
     *
     * @return conexión a la base de dato para la clase CostoDAO
     */
    public ICostoDAO getCostoDAO() {
        return new CostoDAO(conexion);
    }
}
