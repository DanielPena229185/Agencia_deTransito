package org.itson.dominio;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itson.dominio.Tramite;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-29T21:59:57")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, Calendar> fechaNacimiento;
    public static volatile ListAttribute<Persona, Tramite> tramites;
    public static volatile SingularAttribute<Persona, String> apellido_paterno;
    public static volatile SingularAttribute<Persona, String> apellido_materno;
    public static volatile SingularAttribute<Persona, Boolean> discapacidad;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, Long> idPersona;
    public static volatile SingularAttribute<Persona, String> rfc;
    public static volatile SingularAttribute<Persona, String> nombres;

}