package unican.polaflix.pauladm_polaflix.Dominio;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {

    @Id
    private String nombreUsuario;

    private String contrasenha;

    private String iban;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Serie> empezadas;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Serie> pendientes;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Serie> terminadas;

    @OneToOne
    private TipoFactura tipoFactura;

    @OneToMany(mappedBy = "nombreUsuario", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Factura> facturas;

    @OneToMany(mappedBy = "nombreUsuario", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<VisualizacionCapitulo> capitulosVisualizados;

    public Usuario (String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setNombreUsuario (String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario () {
        return nombreUsuario;
    }

    public void setContrasenha (String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getContrasenha () {
        return contrasenha;
    }

    public void setIBAN (String iban) {
        this.iban = iban;
    }

    public String getIBAN () {
        return iban;
    }

    public void setEmpezadas (List<Serie> empezadas) {
        this.empezadas = empezadas;
    }

    public List<Serie> getEmpezadas () {
        return empezadas;
    }

    public void setPendientes (List<Serie> pendientes) {
        this.pendientes = pendientes;
    }

    public List<Serie> getPendientes () {
        return pendientes;
    }

    public void setTerminadas (List<Serie> terminadas) {
        this.terminadas = terminadas;
    }

    public List<Serie> getTerminadas () {
        return terminadas;
    }

    public void setTipoFactura (TipoFactura tipo) {
        this.tipoFactura = tipo;
    }

    public TipoFactura getTipoFactura () {
        return tipoFactura;
    }

    public void setFacturas (List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Factura> getFacturas () {
        return facturas;
    }

    public void setCapitulosVisualizados (List<VisualizacionCapitulo> capitulos) {
        this.capitulosVisualizados = capitulos;
    }

    public List<VisualizacionCapitulo> getCapitulosVisualizados () {
        return capitulosVisualizados;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        Usuario u = (Usuario) obj;
        //identificadores iguales
        if (this.nombreUsuario.equals(u.getNombreUsuario())) {
            return true;
        }
        return false;
    }

    public double verFacturacion (Date fecha) {
        for (Factura f: facturas) {
            if (f.getFecha() == fecha) {
                //TODO: abrir interfaz de la factura con los capitulos y el importe
                return f.getImporte();
            }
        }
        //TODO: mensaje en la interfaz de que no esta?
        return 0;
    }

    public void verSerie (Serie serie) {
        boolean serieEmpezada = false;
        for (Serie e: empezadas) {
            if (e.equals(serie)) {
                serieEmpezada = true;
            }
        }
        if (!serieEmpezada) {
            empezadas.add(serie);
        }
        //TODO: abrir interfaz de la serie por temporada de obtener ultimo y consultar todos los anteriores a ese
    }

    public void verCapitulo (Capitulo capitulo) {
        //se accede desde la interfaz que se abre en verSerie
        capitulo.getEnlace();
        Temporada temporada = capitulo.getTemporada();
        Serie serie = temporada.getSerie();
        agregarCapituloVisto(capitulo, temporada, serie);
        if (capitulo.equals(obtenerUltimo(serie))) {
            terminarSerie(serie);
        }
    }

    public void agregarNuevaSerie (Serie serie) {
        pendientes.add(serie);
    }

    public void terminarSerie (Serie serie) {
        terminadas.add(serie);
        empezadas.remove(serie);
    }

    public Capitulo obtenerUltimo (Serie serie) {
        Capitulo capitulo = null;
        if (pendientes.contains(serie)) {
            capitulo = null;
        } else if (terminadas.contains(serie)) {
            capitulo = serie.getTemporadas().getLast().getCapitulos().getLast();
        } else {
            for (VisualizacionCapitulo v: capitulosVisualizados) {
                if (v.getSerie().equals(serie)) {
                    Capitulo c = v.getCapitulo();
                    //perteneciendo a la misma serie el ultimo capitulo sera el de mayor temporada y numero de entre los vistos
                    if (c.getTemporada().getNumeroTemporada() > capitulo.getTemporada().getNumeroTemporada() 
                            && c.getNumeroCapitulo() > capitulo.getNumeroCapitulo()) {
                        capitulo = c;
                    }
                }
            }
        }
        return capitulo;
    }

    public boolean consultarCapitulo (Capitulo capitulo, Temporada temporada, Serie serie) {
        boolean visto = false;
        if (empezadas.contains(serie) || terminadas.contains(serie)) {
            for (VisualizacionCapitulo v: capitulosVisualizados) {
                //el identificador del capitulo se compone de los tres numeros, serie, temporada y capitulo
                if (v.getSerie().equals(serie) && v.getTemporada().equals(temporada) && v.getCapitulo().equals(capitulo)) {
                    visto = true;
                    break;
                }
            }
        }
        return visto;
    }
    
    public void agregarCapituloVisto (Capitulo capitulo, Temporada temporada, Serie serie) {
        Date now = new Date();
        double precio = serie.getCategoria().getPrecio();
        VisualizacionCapitulo v = new VisualizacionCapitulo(now, precio, serie, temporada, capitulo);
        capitulosVisualizados.addFirst(v); //para que esten ordenados los primeros los mas recientes vistos
        //habra mas posibilidad de que el ultimo capitulo visto de la serie sea el mas reciente
    }

    public void calcularFactura (Date fecha) {
        Factura f = new Factura(this, fecha);
        //si el tipo de factura es cuota fija poner la cuota como importe
        f.setTipo(tipoFactura);
        if (tipoFactura.getNombre().equals(Constantes.FACTURA_CUOTA_FIJA)) {
            f.setImporte(tipoFactura.getImporteBase());
        } else {
        //si el tipo de factura es por visualizacion calcular el importe segun la fecha
            List<VisualizacionCapitulo> capitulos = capitulosVisualizados;
            double importe = 0;
            for (VisualizacionCapitulo v: capitulos) {
                if (v.getFechaVisualizacion().after(fecha)) {
                    importe += v.getPrecio();
                }
            }
            f.setImporte(importe);
        }
        f.setCapitulos(capitulosVisualizados);
    }

}