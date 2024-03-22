package unican.polaflix.pauladm_polaflix.Dominio;

import jakarta.persistence.Id;

public class CapituloId {
    
    @Id
    private int numeroSerie;

    @Id
    private int numeroTemporada;

    @Id
    private int numeroCapitulo;

}
