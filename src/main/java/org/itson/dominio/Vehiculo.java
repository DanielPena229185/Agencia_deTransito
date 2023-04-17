package org.itson.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Daniel Alameda, Daniel Peña
 */
@Entity
@Table(name = "vehiculo")
@DiscriminatorColumn(name = "tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Vehiculo implements Serializable {

    /**
     * Identificador unico del vehiculo
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;

    /**
     * Numero de serie del vehiculo
     */
    @Column(name = "numero_serie", nullable = false, unique = true, length = 50)
    private String numeroSerie;

    /**
     * Marca del vehiculo
     */
    @Column(name = "marca", nullable = false, length = 100)
    private String marca;

    /**
     * Color del vehiculo
     */
    @Column(name = "color", nullable = false, length = 100)
    private String color;
    /**
     * Modelo del vehiculo
     */
    @Column(name = "modelo", nullable = false, length = 100)
    private String modelo;
    /**
     * Linea del vehiculo
     */
    @Column(name = "linea", nullable = false, length = 100)
    private String linea;

    //Relaciones
    /**
     * Placas asociadas al vehiculo
     */
    @OneToMany(mappedBy = "vehiculo")
    private List<Placa> placas;

    /**
     * Constructor vacio de la clase vehiculo
     */
    public Vehiculo() {
    }

    /**
     * Constructor de la clase vehiculo
     *
     * @param numeroSerie Numero de serie del vehiculo
     * @param marca Marca del vehiculo
     * @param color Color del vehiculo
     * @param modelo Modelo del vehiculo
     * @param linea Linea del vehiculo
     */
    public Vehiculo(String numeroSerie, String marca, String color,
            String modelo, String linea) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
    }

    /**
     * Constructor de la clase vehiculo
     *
     * @param idVehiculo Identificador del vehiculo
     * @param numeroSerie Numero de serie del vehiculo
     * @param marca Marca del vehiculo
     * @param color Color del vehiculo
     * @param modelo Modelo del vehiculo
     * @param linea Linea del vehiculo
     */
    public Vehiculo(Long idVehiculo, String numeroSerie, String marca,
            String color, String modelo, String linea) {
        this.idVehiculo = idVehiculo;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
    }

    /**
     * Devuelve el identificador del vehiculo
     *
     * @return Identificador del vehiculo
     */
    public Long getIdVehiculo() {
        return idVehiculo;
    }

    /**
     * Establece el identificador del vehiculo
     *
     * @param idVehiculo Identificador del vehiculo
     */
    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    /**
     * Establece el numero de serie del vehiculo
     *
     * @return Numero de serie del vehiculo
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Establece el numero de serie del vehiculo
     *
     * @param numeroSerie Numero de serie del vehiculo
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Devuelve la marca del vehiculo
     *
     * @return Marca del vehiculo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehiculo
     *
     * @param marca Marca del vehiculo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve el color del vehiculo
     *
     * @return Color del vehiculo
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehiculo
     *
     * @param color Color de vehiculo
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve el color de vehiculo
     *
     * @return Color del vehiculo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establecer el modelo del vehiculo
     *
     * @param modelo Modelo del vehiculo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve la linea del vehiculo
     *
     * @return Linea del vehiculo
     */
    public String getLinea() {
        return linea;
    }

    /**
     * +
     * Establece la linea del vehiculo
     *
     * @param linea Linea del vehiculo
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Devuelve las placas asociadas al vehiculo
     *
     * @return Lista de placas asociadas
     */
    public List<Placa> getPlaca() {
        return placas;
    }

    /**
     * Estable la lista de placas asociadas al vehiculo
     *
     * @param placa Lista de placas asociadas al vehiculo
     */
    public void setPlaca(List<Placa> placa) {
        this.placas = placa;
    }

    /**
     * Agregar placa a la lista de placas asociadas al vehiculo
     *
     * @param placa Placa para agregar a la lista
     */
    public void agregarPlaca(Placa placa) {
        this.placas.add(placa);
    }

    /**
     * Obtener lista de placas asociadas al vehiculo
     *
     * @return Lista de placas asociadas al vehiculo
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Establecer la lista de placas asociadas al vehiculo
     *
     * @param placas Lista de placas asociadas al vehiculo
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

}
