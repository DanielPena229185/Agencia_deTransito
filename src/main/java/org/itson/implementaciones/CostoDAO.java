/**
* CostoDAO.java
* 1 abr. 2023 17:17:58
*/ 

package org.itson.implementaciones;
//importanciones

import java.util.List;

import javax.persistence.EntityManager;

import org.itson.dominio.Costo;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.ICostoDAO;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class CostoDAO implements ICostoDAO{

    EntityManager em;

    /**
     * 
     */
    public CostoDAO(ConexionBD conexion){
        em = conexion.getConexion();
    }

    @Override
    public Costo agregarCosto(Costo costo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Costo eliminarCosto(Costo costo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Costo actualizarCosto(Costo costo) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Costo> consultarCostos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Costo> consultarCostosLicencia() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Costo> consultarCostosPlacas() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
