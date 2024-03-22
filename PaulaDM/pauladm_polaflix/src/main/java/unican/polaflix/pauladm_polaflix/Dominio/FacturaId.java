package unican.polaflix.pauladm_polaflix.Dominio;

import java.util.Date;

import jakarta.persistence.Id;

public class FacturaId {
    
    @Id
    private Date fecha;

    @Id
    private String nombreUsuario;

}
