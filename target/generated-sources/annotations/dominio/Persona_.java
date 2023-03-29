package dominio;

import org.itson.dominio.Persona;
import org.itson.dominio.Tramite;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-03-28T00:25:38")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, Calendar> fechaNacimiento;
    public static volatile ListAttribute<Persona, Tramite> tramite;
    public static volatile SingularAttribute<Persona, String> apellido_paterno;
    public static volatile SingularAttribute<Persona, String> apellido_materno;
    public static volatile SingularAttribute<Persona, Boolean> discapacidad;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, Long> idPersona;
    public static volatile SingularAttribute<Persona, String> rfc;
    public static volatile SingularAttribute<Persona, String> nombres;

}