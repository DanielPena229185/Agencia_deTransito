package dominio;

import dominio.Tramite;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-03-28T00:25:38")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, Float> monto;
    public static volatile SingularAttribute<Pago, Tramite> tramite;
    public static volatile SingularAttribute<Pago, Calendar> fechaHora;
    public static volatile SingularAttribute<Pago, Long> idPago;
    public static volatile SingularAttribute<Pago, String> concepto;

}