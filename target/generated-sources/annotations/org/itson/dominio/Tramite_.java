package org.itson.dominio;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itson.dominio.EstadoTramite;
import org.itson.dominio.Pago;
import org.itson.dominio.Persona;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-04-12T13:32:19")
@StaticMetamodel(Tramite.class)
public class Tramite_ { 

    public static volatile SingularAttribute<Tramite, Long> idTramite;
    public static volatile SingularAttribute<Tramite, Calendar> fechaExpedicion;
    public static volatile SingularAttribute<Tramite, EstadoTramite> estado;
    public static volatile SingularAttribute<Tramite, Float> precio;
    public static volatile SingularAttribute<Tramite, Persona> persona;
    public static volatile ListAttribute<Tramite, Pago> pago;

}