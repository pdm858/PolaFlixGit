package unican.polaflix.pauladm_polaflix.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;

@IdClass(CapituloId.class)
@Entity
public class Capitulo {

    @Id
    private int numeroCapitulo;

    @Id
    private int numeroTemporada;

    @Id
    private int numeroSerie;

    private String nombre;

    private String descripcion;

    private String enlace;

    @ManyToOne
    private Temporada temporada;

    public Capitulo (Temporada temporada, int numero) {
        this.numeroSerie = temporada.getSerie().getId();
        this.numeroTemporada = temporada.getNumeroTemporada();
        this.temporada = temporada;
        this.numeroCapitulo = numero;
    }

    public void setNumeroCapitulo (int numero) {
        this.numeroCapitulo = numero;
    }

    public int getNumeroCapitulo () {
        return numeroCapitulo;
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

    public void setEnlace (String enlace) {
        this.enlace = enlace;
    }

    public String getEnlace () {
        return enlace;
    }

    public void setTemporada (Temporada temporada) {
        this.numeroSerie = temporada.getSerie().getId();
        this.numeroTemporada = temporada.getNumeroTemporada();
        this.temporada = temporada;
    }

    public Temporada getTemporada () {
        return temporada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numeroCapitulo + ((temporada == null) ? 0 : temporada.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        Capitulo c = (Capitulo) obj;
        //identificadores iguales
        if (this.temporada.equals(c.getTemporada())
                && this.numeroCapitulo == c.getNumeroCapitulo()) {
            return true;
        }
        return false;
    }

}