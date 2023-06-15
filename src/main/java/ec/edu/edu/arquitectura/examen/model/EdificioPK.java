package ec.edu.edu.arquitectura.examen.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EdificioPK implements Serializable {
    @Column(name = "COD_EDIFICIO", length = 8, nullable = false)
    private String codigo;
    @Column(name = "COD_SEDE", length = 8, nullable = false)
    private String codigoSede;

    public EdificioPK() {
    }

    public EdificioPK(String codigo, String codigoSede) {
        this.codigo = codigo;
        this.codigoSede = codigoSede;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    @Override
    public String toString() {
        return "EdificioPK [codigo=" + codigo + ", codigoSede=" + codigoSede + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((codigoSede == null) ? 0 : codigoSede.hashCode());
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
        EdificioPK other = (EdificioPK) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (codigoSede == null) {
            if (other.codigoSede != null)
                return false;
        } else if (!codigoSede.equals(other.codigoSede))
            return false;
        return true;
    }

}
