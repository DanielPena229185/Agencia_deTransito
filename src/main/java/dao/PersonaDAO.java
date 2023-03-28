/**
* PersonaDAO.java
* 28 mar. 2023 14:18:16
*/ 

package dao;
//importanciones

import dominio.Persona;
import interfaces.IPersonaDAO;
import java.util.List;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PersonaDAO implements IPersonaDAO{

    //Constructor por omisión
    public PersonaDAO(){

    }

    @Override
    public Persona agregarPersona(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> consultarPersona() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona consultarPersona(String columna, String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
