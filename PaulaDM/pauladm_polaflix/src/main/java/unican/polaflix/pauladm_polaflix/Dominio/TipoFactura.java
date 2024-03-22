package unican.polaflix.pauladm_polaflix.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TipoFactura {
    
    @Id    
    private String nombre;

    private double importeBase;

    public TipoFactura (String nombre) {
        this.nombre = nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre () {
        return nombre;
    }

    public void setImporteBase (double importeBase) {
        this.importeBase = importeBase;
    }

    public double getImporteBase () {
        return importeBase;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        TipoFactura t = (TipoFactura) obj;
        //identificadores iguales
        if (this.nombre.equals(t.getNombre())) {
            return true;
        }
        return false;
    }

}
