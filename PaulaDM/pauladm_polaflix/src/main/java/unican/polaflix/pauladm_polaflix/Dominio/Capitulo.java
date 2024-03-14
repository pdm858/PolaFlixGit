package unican.polaflix.pauladm_polaflix.Dominio;

public class Capitulo {

    private int numero;

    private String nombre;

    private String descripcion;

    private String enlace;

    private Temporada temporada;

    public Capitulo (Temporada temporada, int numero) {
        this.temporada = temporada;
        this.numero = numero;
    }

    public int getNumero () {
        return numero;
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

    public Temporada getTemporada () {
        return temporada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero + ((temporada == null) ? 0 : temporada.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        Capitulo c = (Capitulo) obj;
        //identificadores iguales
        if (this.temporada.equals(c.getTemporada())
                && this.numero == c.getNumero()) {
            return true;
        }
        return false;
    }

}