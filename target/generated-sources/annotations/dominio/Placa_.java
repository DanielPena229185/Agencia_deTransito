package dominio;

import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-03-28T00:25:38")
@StaticMetamodel(Placa.class)
public class Placa_ extends Tramite_ {

    public static volatile SingularAttribute<Placa, String> numero;
    public static volatile SingularAttribute<Placa, Vehiculo> vehiculo;
    public static volatile SingularAttribute<Placa, Calendar> fechaRecepcion;

}