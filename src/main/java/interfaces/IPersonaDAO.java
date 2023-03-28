/**
* IPersona.java
* 28 mar. 2023 14:13:55
*/ 

package interfaces;

import dominio.Persona;
import java.util.List;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IPersonaDAO {

    public Persona agregarPersona(Persona persona);
    public List<Persona> consultarPersona();
    public Persona consultarPersona(String columna, String filtro);
}
