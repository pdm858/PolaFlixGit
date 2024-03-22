package unican.polaflix.pauladm_polaflix.Dominio;

import org.springframework.beans.factory.annotation.Autowired;

public class SerieService {
    
    @Autowired
    public SerieRepository sr;

    public SerieService () {}

    public void nuevaTemporadaCambiarTerminadas (Serie serie) {
        //TODO
        //para todos los usuarios que tengan la serie
        //eliminar la serie del conjunto de series terminadas y moverla a empezadas
    }

}
