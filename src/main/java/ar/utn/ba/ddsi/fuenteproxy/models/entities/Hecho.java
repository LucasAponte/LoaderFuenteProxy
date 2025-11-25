package ar.utn.ba.ddsi.fuenteproxy.models.entities;

import ar.utn.ba.ddsi.fuenteproxy.models.dtos.FuenteDTO;
import ar.utn.ba.ddsi.fuenteproxy.models.dtos.HechoInputDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Hecho {
    private String Titulo;
    private String descripcion;
    private Categoria categoria;
    private LocalDate fecha;
    private LocalDate fechaDeCarga;
    private Ubicacion ubicacion;
    private Etiqueta etiqueta;
    private EnumTipoHecho tipoHecho;
    private Fuente fuente;
    private List<Adjunto> adjuntos = new ArrayList<>();


    public Hecho(String titulo, String descripcion, Categoria categoria,Ubicacion lugarDeOcurrencia, LocalDate fecha) {
        this.Titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ubicacion = lugarDeOcurrencia;
        this.fecha = fecha;

    }
    public Hecho(HechoInputDTO hechoDTO) {
        this.Titulo = hechoDTO.getTitulo();
        this.descripcion = hechoDTO.getDescripcion();
        this.categoria = new Categoria(hechoDTO.getCategoria());
        this.ubicacion = new Ubicacion(Float.parseFloat(hechoDTO.getUbicacionLat()), Float.parseFloat(hechoDTO.getUbicacionLon()));
        this.fecha = LocalDate.parse(hechoDTO.getFecha());
        this.fechaDeCarga = LocalDate.parse(hechoDTO.getFechaDeCarga());
        this.etiqueta = new Etiqueta(hechoDTO.getEtiqueta());
        this.tipoHecho = EnumTipoHecho.valueOf(hechoDTO.getTipoHecho());
    }

    //getters y setters
    public String getTitulo() {return Titulo;}
    public void cambiarTitulo(String titulo) {this.Titulo= titulo;}
    public void cambiarDescripcion(String descripcion) {this.descripcion = descripcion;}
    public Categoria getCategoria() {return categoria;}
    public void cambiarCategoria(String categoria) {this.categoria.setNombre(categoria);}
    public Etiqueta getEtiqueta() {return etiqueta;}
    public void cambiarEtiqueta(String etiqueta) {this.etiqueta.setNombre(etiqueta);}
    public Fuente getFuente() {return fuente;}

    //Así me vendría la info, en String?
    public void cambiarUbicacion(String dato, String dato1) {
        float nuevaLatitud = Float.parseFloat(dato);
        float nuevaLongitud = Float.parseFloat(dato1);
        ubicacion.setUbicacion(nuevaLatitud,nuevaLongitud);
    }

    //string a fecha??
    public LocalDate getFecha() {return fecha;}
    public String getDescripcion() {return descripcion;}
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalDate getFechaDeCarga() {return fechaDeCarga;}
    public void setFechaDeCarga(LocalDate fechaDeCarga) {this.fechaDeCarga = fechaDeCarga;}
    public Ubicacion getUbicacion() {return ubicacion;}
    public EnumTipoHecho getTipoHecho() {return tipoHecho;}
    public void setTipoHecho(EnumTipoHecho tipoHecho) {this.tipoHecho = tipoHecho;}
    public List<Adjunto> getAdjuntos() {return adjuntos;}
    public void setFuente(Fuente fuente) {this.fuente = fuente;}
}
