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

    public Vehiculo() {
    }

    public Vehiculo(String numeroSerie, String marca, String color,
            String modelo, String linea) {
        this.validarDatos(numeroSerie, marca, color, modelo, linea);
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
    }

    public Vehiculo(Long idVehiculo, String numeroSerie, String marca,
            String color, String modelo, String linea) {
        this.validarDatos(numeroSerie, marca, color, modelo, linea);
        this.idVehiculo = idVehiculo;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
    }

    public void validarDatos(String numeroSerie, String marca, String color,
            String modelo, String linea) {

        if (numeroSerie == null || numeroSerie.trim().isEmpty()) {
            throw new IllegalArgumentException("El numero de serie no puede estar vacío");
        } else if (numeroSerie.length() > 50) {
            throw new IllegalArgumentException("El numero de serie del vehiculo no debe exceder los 50 caracteres");
        }

        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacía");
        } else if (marca.length() > 100) {
            throw new IllegalArgumentException("La marca del vehiculo no debe exceder los 100 caracteres");
        }

        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("El color no puede estar vacío");
        } else if (color.length() > 100) {
            throw new IllegalArgumentException("El color del vehiculo no debe exceder los 100 caracteres");
        }

        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío");
        } else if (modelo.length() > 100) {
            throw new IllegalArgumentException("El modelo del vehiculo no debe exceder los 100 caracteres");
        }

        if (linea == null || linea.trim().isEmpty()) {
            throw new IllegalArgumentException("La linea no puede estar vacía");
        } else if (linea.length() > 100) {
            throw new IllegalArgumentException("La linea del vehiculo no debe exceder los 100 caracteres");
        }

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
        if (numeroSerie == null || numeroSerie.trim().isEmpty()) {
            throw new IllegalArgumentException("El numero de serie no puede estar vacío");
        } else if (numeroSerie.length() > 50) {
            throw new IllegalArgumentException("El numero de serie del vehiculo no debe exceder los 50 caracteres");
        }
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacía");
        } else if (marca.length() > 100) {
            throw new IllegalArgumentException("La marca del vehiculo no debe exceder los 100 caracteres");
        }
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("El color no puede estar vacío");
        } else if (color.length() > 100) {
            throw new IllegalArgumentException("El color del vehiculo no debe exceder los 100 caracteres");
        }
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío");
        } else if (modelo.length() > 100) {
            throw new IllegalArgumentException("El modelo del vehiculo no debe exceder los 100 caracteres");
        }
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        if (linea == null || linea.trim().isEmpty()) {
            throw new IllegalArgumentException("La linea no puede estar vacía");
        } else if (linea.length() > 100) {
            throw new IllegalArgumentException("La linea del vehiculo no debe exceder los 100 caracteres");
        }
        this.linea = linea;
    }

    public List<Placa> getPlaca() {
        return placas;
    }

    public void setPlaca(List<Placa> placa) {
        this.placas = placa;
    }

    public void agregarPlaca(Placa placa) {
        if (this.placas == null) {
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

}
