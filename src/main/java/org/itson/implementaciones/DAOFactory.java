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
    ConexionBD conexion = new ConexionBD("base");

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
    
    

}
