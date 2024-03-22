package unican.polaflix.pauladm_polaflix.Dominio;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

@IdClass(VisualizacionCapituloId.class)
@Entity
public class VisualizacionCapitulo {
    
    @Id
    private String nombreUsuario;

    @Id
    private Date fechaVisualizacion;

    @Id
    private int numeroCapitulo;

    @Id
    private int numeroTemporada;

    @Id
    private int numeroSerie;

    private double precio;
    
    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Serie serie;
    
    @ManyToOne
    private Temporada temporada;

    @ManyToOne
    private Capitulo capitulo;

    public VisualizacionCapitulo (Date fecha, double precio, Serie serie, Temporada temporada, Capitulo capitulo) {
        this.fechaVisualizacion = fecha;
        this.precio = precio;
        this.serie = serie;
        this.numeroSerie = serie.getId();
        this.temporada = temporada;
        this.numeroTemporada = temporada.getNumeroTemporada();
        this.capitulo = capitulo;
        this.numeroCapitulo = capitulo.getNumeroCapitulo();
    }

    public void setFechaVisualizacion (Date fechaVisualizacion) {
        this.fechaVisualizacion = fechaVisualizacion;
    }

    public Date getFechaVisualizacion () {
        return fechaVisualizacion;
    }

    public void setPrecio (double precio) {
        this.precio = precio;
    }

    public double getPrecio () {
        return precio;
    }

    public void setSerie (Serie serie) {
        this.numeroSerie = serie.getId();
        this.serie = serie;
    }

    public Serie getSerie () {
        return serie;
    }

    public void setTemporada (Temporada temporada) {
        this.numeroTemporada = temporada.getNumeroTemporada();
        this.temporada = temporada;
    }

    public Temporada getTemporada () {
        return temporada;
    }

    public void setCapitulo (Capitulo capitulo) {
        this.numeroCapitulo = capitulo.getNumeroCapitulo();
        this.capitulo = capitulo;
    }

    public Capitulo getCapitulo () {
        return capitulo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fechaVisualizacion == null) ? 0 : fechaVisualizacion.hashCode())
                                + ((serie == null) ? 0 : serie.hashCode()) 
                                + ((temporada == null) ? 0 : temporada.hashCode())
                                + ((capitulo == null) ? 0 : capitulo.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        VisualizacionCapitulo v = (VisualizacionCapitulo) obj;
        //identificadores iguales
        if (this.fechaVisualizacion.equals(v.getFechaVisualizacion())
                && this.serie.equals(v.getSerie()) 
                && this.temporada.equals(v.getTemporada())
                && this.capitulo.equals(v.getCapitulo())) {
            return true;
        }
        return false;
    }

}
