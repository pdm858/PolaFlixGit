package unican.polaflix.pauladm_polaflix.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Persona {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    
    private String nombre;
    
    private String apellido1;

    private String apellido2;

    public Persona () {}

    public int getId () {
        return id;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre () {
        return nombre;
    }

    public void setApellido1 (String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido1 () {
        return apellido1;
    }

    public void setApellido2 (String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getApellido2 () {
        return apellido2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        Persona p = (Persona) obj;
        //identificadores iguales
        if (this.id == p.getId()) {
            return true;
        }
        return false;
    }
}