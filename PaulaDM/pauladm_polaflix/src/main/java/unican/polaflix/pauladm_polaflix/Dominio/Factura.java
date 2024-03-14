package unican.polaflix.pauladm_polaflix.Dominio;

import java.util.Date;
import java.util.List;

public class Factura {

    private Usuario usuario;

    private Date fecha;

    private TipoFactura tipo;

    private double importe;

    private List<VisualizacionCapitulo> capitulos;

    public Factura (Usuario usuario, Date fecha) {
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Usuario getUsuario () {
        return usuario;
    }

    public Date getFecha () {
        return fecha;
    }

    public void setTipo (TipoFactura tipo) {
        this.tipo = tipo;
    }

    public TipoFactura getTipo () {
        return tipo;
    }

    public void setImporte (double importe) {
        this.importe = importe;
    }

    public double getImporte () {
        return importe;
    }

    public void setCapitulos (List<VisualizacionCapitulo> capitulosVisualizados) {
        this.capitulos = capitulosVisualizados;
    }

    public List<VisualizacionCapitulo> getCapitulos () {
        return capitulos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode())
                                + ((fecha == null) ? 0 : fecha.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        Factura f = (Factura) obj;
        //identificadores iguales
        if (this.usuario.equals(f.getUsuario())
                && this.fecha.equals(f.getFecha())) {
            return true;
        }
        return false;
    }

}