/**
 * Costo.java
 * 1 abr. 2023 15:26:41
 */
package org.itson.dominio;
//importanciones

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@Table(name = "costos")
@DiscriminatorColumn(name = "tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Costo implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "costo_normal", nullable = false)
    private double costoNormal;

    public Costo() {
    }

    public Costo(double costoNormal) {
        this.costoNormal = costoNormal;
    }

    public Costo(Long id, double costoNormal) {
        this.id = id;
        this.costoNormal = costoNormal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCostoNormal() {
        return costoNormal;
    }

    public void setCostoNormal(double costoNormal) {
        this.costoNormal = costoNormal;
    }

}
