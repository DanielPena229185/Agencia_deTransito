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
@Table(name = "Costos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Costo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Costo_Normal")
    private double costoNormal;
    
    @Column(name = "Concepto", length = 100)
    private String concepto;
    
    /**
     * 
     */
    public Costo(){

    }

    public Costo(Long id, double costoNormal, String concepto) {
        this.id = id;
        this.costoNormal = costoNormal;
        this.concepto = concepto;
    }

    public Costo(double costoNormal, String concepto) {
        this.costoNormal = costoNormal;
        this.concepto = concepto;
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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costo)) {
            return false;
        }
        Costo other = (Costo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itson.dominio.Costo[ id=" + id + " ]";
    }
}
