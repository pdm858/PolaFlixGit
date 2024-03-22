package unican.polaflix.pauladm_polaflix.Dominio;

import java.util.Date;

import jakarta.persistence.Id;

public class VisualizacionCapituloId {

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

}
