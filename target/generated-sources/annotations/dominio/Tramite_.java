package dominio;

import dominio.EstadoTramite;
import dominio.Persona;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-03-27T23:10:10")
@StaticMetamodel(Tramite.class)
public class Tramite_ { 

    public static volatile SingularAttribute<Tramite, Long> idTramite;
    public static volatile SingularAttribute<Tramite, Calendar> fechaExpedicion;
    public static volatile SingularAttribute<Tramite, EstadoTramite> estado;
    public static volatile SingularAttribute<Tramite, Float> precio;
    public static volatile SingularAttribute<Tramite, Persona> persona;

}