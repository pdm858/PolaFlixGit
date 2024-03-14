package unican.polaflix.pauladm_polaflix.Dominio;

import java.util.List;
import java.util.Set;

public class Serie {
    
    private int id;

    private String nombre;

    private String descripcion;

    private List<Temporada> temporadas;

    private Categoria categoria;

    private Set<Persona> actores;

    private Set<Persona> creadores;

    private SerieService ss = new SerieService();

    public Serie () {}

    public int getId () {
        return id;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getNombre () {
        return nombre;
    }

    public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public void setTemporadas (List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public List<Temporada> getTemporadas () {
        return temporadas;
    }

    public void setCategoria (Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria () {
        return categoria;
    }

    public void setActores (Set<Persona> actores) {
        this.actores = actores;
    }

    public Set<Persona> getActores () {
        return actores;
    }

    public void setCreadores (Set<Persona> creadores) {
        this.creadores = creadores;
    }

    public Set<Persona> getCreadores () {
        return creadores;
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
        Serie s = (Serie) obj;
        //identificadores iguales
        if (this.id == s.getId()) {
            return true;
        }
        return false;
    }

    public void nuevaTemporada (Temporada temporada) {
        temporadas.add(temporada);
        ss.nuevaTemporadaCambiarTerminadas(this);
    }
    
}