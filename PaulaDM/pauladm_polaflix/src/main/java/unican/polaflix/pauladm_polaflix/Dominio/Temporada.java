package unican.polaflix.pauladm_polaflix.Dominio;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@IdClass(TemporadaId.class)
@Entity
public class Temporada {

    @Id
    private int numeroTemporada;

    @Id
    private int numeroSerie;

    @OneToMany(mappedBy = "numeroTemporada", cascade = CascadeType.REMOVE)
    private List<Capitulo> capitulos;

    @ManyToOne
    private Serie serie;

    public Temporada (Serie serie, int numero) {
        this.serie = serie;
        this.numeroSerie = serie.getId();
        this.numeroTemporada = numero;
    }

    public void setNumeroTemporada (int numero) {
        this.numeroTemporada = numero;
    }

    public int getNumeroTemporada () {
        return numeroTemporada;
    }

    public void setCapitulos (List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    public List<Capitulo> getCapitulos () {
        return capitulos;
    }

    public void setSerie (Serie serie) {
        this.serie = serie;
        this.numeroSerie = serie.getId();
    }

    public Serie getSerie () {
        return serie;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numeroTemporada + ((serie == null) ? 0 : serie.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        Temporada t = (Temporada) obj;
        //identificadores iguales
        if (this.numeroTemporada == t.getNumeroTemporada()
                && this.serie.equals(t.getSerie())) {
            return true;
        }
        return false;
    }

}