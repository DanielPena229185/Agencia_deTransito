package dominio;

import org.itson.dominio.Vehiculo;
import org.itson.dominio.Placa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-03-28T00:25:38")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, String> numeroSerie;
    public static volatile SingularAttribute<Vehiculo, String> marca;
    public static volatile SingularAttribute<Vehiculo, Long> idVehiculo;
    public static volatile SingularAttribute<Vehiculo, String> color;
    public static volatile SingularAttribute<Vehiculo, String> modelo;
    public static volatile SingularAttribute<Vehiculo, String> linea;
    public static volatile ListAttribute<Vehiculo, Placa> placa;

}