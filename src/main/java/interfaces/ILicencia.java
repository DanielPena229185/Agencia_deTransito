/**
* ILicencia.java
* 28 mar. 2023 13:59:54
*/ 

package interfaces;

import dominio.Licencia;
import dominio.Persona;
import java.util.List;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface ILicencia {
    
    public Licencia agregarTramiteLicencia();
    public Licencia actualizar(Licencia licencia);
    public Licencia consultarLicencia(Licencia licencia);
    public List<Licencia> consultarLicencias(Persona persona);
    public List<Licencia> consultarLicencias(String columna, String filtro);

}
