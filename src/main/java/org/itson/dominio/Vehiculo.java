package org.itson.dominio;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Daniel Alameda, Daniel Peña
 */
@Entity
@Table(name = "vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;

    @Column(name = "numero_serie", nullable = false, unique = true, length = 50)
    private String numeroSerie;

    @Column(name = "marca", nullable = false, length = 100)
    private String marca;

    @Column(name = "color", nullable = false, length = 100)
    private String color;

    @Column(name = "modelo", nullable = false, length = 100)
    private String modelo;

    @Column(name = "linea", nullable = false, length = 100)
    private String linea;

    //Relaciones
    
    // Relacion a placas
    @OneToMany(mappedBy = "vehiculo")
    private List<Placa> placas;
    
    //Relación a Persona
    @ManyToOne()
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    public Vehiculo() {
    }

    public Vehiculo(String numeroSerie, String marca, String color,
            String modelo, String linea, Persona persona) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.persona = persona;
    }

    public Vehiculo(Long idVehiculo, String numeroSerie, String marca,
            String color, String modelo, String linea) {
        this.idVehiculo = idVehiculo;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
    }

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public List<Placa> getPlaca() {
        return placas;
    }

    public void setPlaca(List<Placa> placa) {
        this.placas = placa;
    }
    
    public void agregarPlaca(Placa placa){
        if(this.placas == null){
            this.placas = new LinkedList<>();
        }
        this.placas.add(placa);
    }

    public List<Placa> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
