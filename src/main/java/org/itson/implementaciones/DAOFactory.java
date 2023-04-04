/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.implementaciones;

import org.itson.interfaces.*;

/**
 *
 * @author HP
 */
public class DAOFactory {

    //Cambiar para que corra
    ConexionBD conexion = new ConexionBD("org.itson.sistema_AgenciaDeTransito_jar_1.0-SNAPSHOTPU");

    /**
     *
     * @return
     */
    public IPagoDAO getPagoDAO() {
        return new PagoDAO(conexion);
    }

    public IPersonaDAO getPersonaDAO() {
        return new PersonaDAO(conexion);
    }

    public ITramiteDAO getTramiteDAO() {
        return new TramiteDAO(conexion);
    }

    public IVehiculoDAO getVehiculoDAO() {
        return new VehiculoDAO(conexion);
    }

    public IAutomovilDAO getAutomovilDAO() {
        return new AutomovilDAO(conexion);
    }

    public ILicenciaDAO getLicenciaDAO() {
        return new LicenciaDAO(conexion);
    }

    public IPlacaDAO getPlacaDAO() {
        return new PlacaDAO(conexion);
    }

    public ICostoDAO getCostoDAO() {
        return new CostoDAO(conexion);
    }
}
