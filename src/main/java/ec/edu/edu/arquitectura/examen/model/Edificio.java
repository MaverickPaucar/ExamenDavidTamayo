package ec.edu.edu.arquitectura.examen.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "EDIFICIO")
public class Edificio {
    @EmbeddedId
    private EdificioPK pk;

    @Column(name = "NOMBRE", length = 128, nullable = false)
    private String nombre;
    @Column(name = "PISO", nullable = false)
    private Integer piso;
    @Column(name = "SUPERFICE", precision = 7, scale = 2, nullable = false)
    private BigDecimal superfice;
    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @ManyToOne
    @JoinColumn(name = "COD_SEDE", referencedColumnName = "COD_SEDE", insertable = false, updatable = false)
    private Sede sede;

    public Edificio() {
    }

    public Edificio(EdificioPK pk) {
        this.pk = pk;
    }

    public EdificioPK getPk() {
        return pk;
    }

    public void setPk(EdificioPK pk) {
        this.pk = pk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public BigDecimal getSuperfice() {
        return superfice;
    }

    public void setSuperfice(BigDecimal superfice) {
        this.superfice = superfice;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "Edificio [pk=" + pk + ", nombre=" + nombre + ", piso=" + piso + ", superfice=" + superfice
                + ", version=" + version + ", sede=" + sede + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edificio other = (Edificio) obj;
        if (pk == null) {
            if (other.pk != null)
                return false;
        } else if (!pk.equals(other.pk))
            return false;
        return true;
    }

}
