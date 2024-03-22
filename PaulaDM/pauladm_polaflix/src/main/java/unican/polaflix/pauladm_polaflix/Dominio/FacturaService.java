package unican.polaflix.pauladm_polaflix.Dominio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class FacturaService {
    
    @Autowired
    public UsuarioRepository ur;

    public FacturaService () {}

    public void calcularFactura (Date fecha) {
        //TODO
        //para todos los usuarios del sistema
        //u.calcularFactura(fecha);
    }
}
