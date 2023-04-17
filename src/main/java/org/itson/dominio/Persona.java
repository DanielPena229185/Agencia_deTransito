package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import org.itson.excepciones.EncriptarException;
import org.itson.utils.Encriptador;

/**
 * Descripción de la clase: Esta clase es el dominio de una clase que representa
 * a una persona y se realiza el mapeo en la base de datos
 *
 * @author Daniel Armando Peña Garcia ID:229185
 * @author Daniel Omar Alameda López ID: 228343
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    //Variables
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @Column(name = "nombres", nullable = false, length = 150)
    private String nombres;

    @Column(name = "apellido_paterno", nullable = false, length = 150)
    private String apellido_paterno;

    @Column(name = "apellido_materno", nullable = false, length = 150)
    private String apellido_materno;

    @Column(name = "rfc", nullable = false, length = 150, unique = true)
    private String rfc;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    @Column(name = "isDiscapacidad", nullable = false)
    private Boolean discapacidad;

    @Column(name = "telefono", nullable = false, length = 100)
    private String telefono;

    //Relaciones
    // Relacion Tramite
    @OneToMany(mappedBy = "persona")
    private List<Tramite> tramites;

    /**
     * Contructor por ausencia
     */
    public Persona() {
    }

    /**
     * Constructor que inicializa el objeto los parametros:
     *
     * @param nombres Nombre de la persona
     * @param apellido_paterno Apellido paterno de la persona
     * @param apellido_materno Apellido paterno de la persona
     * @param rfc RFC de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param discapacidad La discapacidad de la persona
     * @param telefono Teléfono de la persona
     */
    public Persona(String nombres, String apellido_paterno,
            String apellido_materno, String rfc, Calendar fechaNacimiento,
            Boolean discapacidad, String telefono) {
        this.validarPersona(nombres, apellido_paterno, apellido_materno, rfc, fechaNacimiento, discapacidad, telefono);
        this.encriptarNombres(nombres, apellido_paterno, apellido_materno);
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
        this.telefono = telefono;
    }

    /**
     * Constructor que inicializa los parámetros
     *
     * @param idPersona Id de la persona
     * @param nombres Nombre de la persona
     * @param apellido_paterno Apellido paterno de la persona
     * @param apellido_materno Apellido paterno de la persona
     * @param rfc RFC de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param discapacidad La discapacidad de la persona
     * @param telefono Teléfono de la persona
     */
    public Persona(Long idPersona, String nombres, String apellido_paterno,
            String apellido_materno, String rfc, Calendar fechaNacimiento,
            Boolean discapacidad, String telefono) {
        this.validarPersona(nombres, apellido_paterno, apellido_materno, rfc, fechaNacimiento, discapacidad, telefono);
        this.idPersona = idPersona;
        this.encriptarNombres(nombres, apellido_paterno, apellido_materno);
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
        this.telefono = telefono;
    }

    /**
     * Valida si los parametros con responden con las validaciones
     *
     * @param nombres Nombre de la persona
     * @param apellido_paterno Apellido paterno de la persona
     * @param apellido_materno Apellido paterno de la persona
     * @param rfc RFC de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param discapacidad La discapacidad de la persona
     * @param telefono Teléfono de la persona
     */
    public void validarPersona(String nombres, String apellido_paterno,
            String apellido_materno, String rfc, Calendar fechaNacimiento,
            Boolean discapacidad, String telefono) {

        if (nombres == null || nombres.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        } else if (nombres.length() > 150) {
            throw new IllegalArgumentException("El nombre de la persona no debe exceder los 150 caracteres");
        }

        if (apellido_paterno == null || apellido_paterno.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido paterno no puede estar vacío");
        } else if (apellido_paterno.length() > 150) {
            throw new IllegalArgumentException("El apellido paterno de la persona no debe exceder los 150 caracteres");
        }

        if (apellido_materno == null || apellido_materno.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido materno no puede estar vacío");
        } else if (apellido_materno.length() > 150) {
            throw new IllegalArgumentException("El apellido materno de la persona no debe exceder los 150 caracteres");
        }

        if (rfc == null || rfc.trim().isEmpty()) {
            throw new IllegalArgumentException("El RFC no puede estar vacío");
        } else if (rfc.length() > 150) {
            throw new IllegalArgumentException("El RFC de la persona no debe exceder los 150 caracteres");
        }

//        if (fechaNacimiento == null) {
//            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
//        }
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de teléfono no puede estar vacío");
        } else if (rfc.length() > 100) {
            throw new IllegalArgumentException("El numero telefonico de la persona no debe exceder los 100 caracteres");
        }
    }

    /**
     * Método que regresa el id de la persona
     *
     * @return id de la persona
     */
    public Long getIdPersona() {
        return idPersona;
    }

    /**
     * Método que ingresa el id de la persona
     *
     * @param idPersona a ingresar
     */
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * Método que devuelve el nombre de la persona
     *
     * @return nombre de la persona
     */
    public String getNombres() {
        try {
            return Encriptador.desencriptar(this.nombres);
        } catch (Exception e) {
            throw new EncriptarException("Error al encriptar el nombre: " + e.getMessage(), e);
        }
    }

    /**
     * Método que ingresa el nombre de la persona
     *
     * @param nombres a ingresar
     */
    public void setNombres(String nombres) {
        if (nombres == null || nombres.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        } else if (nombres.length() > 150) {
            throw new IllegalArgumentException("El nombre de la persona no debe exceder los 150 caracteres");
        }
        this.nombres = nombres;
    }

    /**
     * Método que regresa el apellido paterno de la persona
     *
     * @return apellido_paterno de la persona
     */
    public String getApellido_paterno() {
        try {
            return Encriptador.desencriptar(this.apellido_paterno);
        } catch (Exception e) {
            throw new EncriptarException("Error al desencriptar el apellido "
                    + "materno: " + e.getMessage(), e);
        }
    }

    /**
     * Método que ingresa el apellido paterno de la persona
     *
     * @param apellido_paterno valor a ingresar
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Método que regresa el apellido materno de la persona
     *
     * @return apellido_materno de la persona
     */
    public String getApellido_materno() {
        try {
            return Encriptador.desencriptar(this.apellido_materno);
        } catch (Exception e) {
            throw new EncriptarException("Error al desencriptar el apellido "
                    + "materno: " + e.getMessage(), e);
        }
    }

    /**
     * Método que ingresa el apellido materno de la persona
     *
     * @param apellido_materno valor a ingresar
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Devuelve el rfc de la persona
     *
     * @return rfc de la persona
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Método que ingresa el rfc de la persona
     *
     * @param rfc Rfc de la persona
     */
    public void setRfc(String rfc) {
        if (rfc == null || rfc.trim().isEmpty()) {
            throw new IllegalArgumentException("El RFC no puede estar vacío");
        } else if (rfc.length() > 150) {
            throw new IllegalArgumentException("El RFC de la persona no debe exceder los 150 caracteres");
        }
        this.rfc = rfc;
    }

    /**
     * Devuelve fecha de nacimiento de la persona
     *
     * @return fehcaNacimiento de la persona
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método que ingresa valor de fecha de nacimiento de la persona
     *
     * @param fechaNacimiento Fecha de nacimiento de la persona
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve el valor de discapacidad
     *
     * @return discapaciad 
     */
    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    /**
     * Método que ingresa valor de discapacidad
     *
     * @param discapacidad a ingresar
     */
    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * Devuelve el valor de teléfono
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método que ingresa el valor de un telefono a la clase
     *
     * @param telefono a ingresar
     */
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de teléfono no puede estar vacío");
        } else if (rfc.length() > 100) {
            throw new IllegalArgumentException("El numero telefonico de la persona no debe exceder los 100 caracteres");
        }
        this.telefono = telefono;
    }

    public List<Tramite> getTramite() {
        return tramites;
    }

    public void setTramite(List<Tramite> tramite) {
        this.tramites = tramite;
    }

    public void agregarALista(Tramite tramite) {
        if (this.tramites == null) {
            this.tramites = new LinkedList<>();
        }
        this.tramites.add(tramite);
    }

    /**
     * Metodo get que regresa la edad de la persona
     *
     * @return edad de la persona
     */
    public int getEdad() {
        Calendar ahora = Calendar.getInstance();
        long edadEnDias
                = (ahora.getTimeInMillis() - fechaNacimiento.getTimeInMillis())
                / 1000 / 60 / 60 / 24;
        int anios = Double.valueOf(edadEnDias / 365.25d).intValue();

        return anios;

    }

    public String getNombreCompleto() {
        return this.getNombres() + " " + this.getApellido_paterno() + " " + this.getApellido_materno();
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombres=" + nombres + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", rfc=" + rfc + ", fechaNacimiento=" + fechaNacimiento + ", discapacidad=" + discapacidad + ", telefono=" + telefono + ", tramites=" + tramites + '}';
    }

    private void encriptarNombres(String nombres, String apellido_Paterno, String apellido_Materno) throws EncriptarException {
        try {

            this.nombres = Encriptador.encriptar(nombres.toUpperCase());
            this.apellido_paterno = Encriptador.encriptar(apellido_Paterno.toUpperCase());
            this.apellido_materno = Encriptador.encriptar(apellido_Materno.toUpperCase());
        } catch (Exception e) {
            throw new EncriptarException("Error al encriptar: " + e.getMessage(), e);
        }
    }

}
