package unican.polaflix.pauladm_polaflix.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Categoria {

    @Id
    private String nombre;

    private double precio;

    public Categoria (String nombre) {
        this.nombre = nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre () {
        return nombre;
    }

    public void setPrecio (double precio) {
        this.precio = precio;
    }

    public double getPrecio () {
        return precio;
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
        Categoria c = (Categoria) obj;
        //identificadores iguales
        if (this.nombre.equals(c.getNombre())) {
            return true;
        }
        return false;
    }

}