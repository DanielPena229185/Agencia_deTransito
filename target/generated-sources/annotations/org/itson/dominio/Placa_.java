package org.itson.dominio;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itson.dominio.Vehiculo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-04-07T00:02:02")
@StaticMetamodel(Placa.class)
public class Placa_ extends Tramite_ {

    public static volatile SingularAttribute<Placa, Vehiculo> vehiculo;
    public static volatile SingularAttribute<Placa, String> numeroPlaca;
    public static volatile SingularAttribute<Placa, Calendar> fechaRecepcion;

}