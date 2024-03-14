package unican.polaflix.pauladm_polaflix.Dominio;

import java.util.List;

public class Temporada {

    private int numero;

    private List<Capitulo> capitulos;

    private Serie serie;

    public Temporada (Serie serie, int numero) {
        this.serie = serie;
        this.numero = numero;
    }

    public int getNumero () {
        return numero;
    }

    public void setCapitulos (List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    public List<Capitulo> getCapitulos () {
        return capitulos;
    }

    public Serie getSerie () {
        return serie;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero + ((serie == null) ? 0 : serie.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        Temporada t = (Temporada) obj;
        //identificadores iguales
        if (this.numero == t.getNumero()
                && this.serie.equals(t.getSerie())) {
            return true;
        }
        return false;
    }

}