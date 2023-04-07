package org.itson.dominio;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itson.dominio.Tramite;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-04-07T00:02:02")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, Float> monto;
    public static volatile SingularAttribute<Pago, Tramite> tramite;
    public static volatile SingularAttribute<Pago, Calendar> fechaHora;
    public static volatile SingularAttribute<Pago, Long> idPago;
    public static volatile SingularAttribute<Pago, String> concepto;

}