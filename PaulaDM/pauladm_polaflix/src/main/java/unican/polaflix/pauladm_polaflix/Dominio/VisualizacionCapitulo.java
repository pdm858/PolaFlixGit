package unican.polaflix.pauladm_polaflix.Dominio;

import java.util.Date;

public class VisualizacionCapitulo {
    
    private Date fechaVisualizacion;

    private double precio;

    private Serie serie;
    
    private Temporada temporada;

    private Capitulo capitulo;

    public VisualizacionCapitulo (Date fecha, double precio, Serie serie, Temporada temporada, Capitulo capitulo) {
        this.fechaVisualizacion = fecha;
        this.precio = precio;
        this.serie = serie;
        this.temporada = temporada;
        this.capitulo = capitulo;
    }

    public Date getFechaVisualizacion () {
        return fechaVisualizacion;
    }

    public double getPrecio () {
        return precio;
    }

    public Serie getSerie () {
        return serie;
    }

    public Temporada getTemporada () {
        return temporada;
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
