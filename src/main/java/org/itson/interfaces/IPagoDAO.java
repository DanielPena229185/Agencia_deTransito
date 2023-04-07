/**
* IPagoDAO.java
* 29 mar. 2023 09:44:47
*/ 

package org.itson.interfaces;

import java.util.Calendar;
import java.util.List;
import org.itson.dominio.Pago;
import org.itson.excepciones.PersistenciaException;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IPagoDAO {

    public Pago agregarPago(Pago pago)throws PersistenciaException;
    public void eliminarPago(Pago pago)throws PersistenciaException;
    public Pago actualizarPago(Pago pago)throws PersistenciaException;
    public Pago consultarPago(Pago pago)throws PersistenciaException;
    public List<Pago> consultarPagos()throws PersistenciaException;
    public List<Pago> consultarPagosFecha(Calendar fecha)throws PersistenciaException;
            
}
