package ar.utn.ba.ddsi.fuenteproxy.models.dtos;

import ar.utn.ba.ddsi.fuenteproxy.models.entities.Adjunto;
import ar.utn.ba.ddsi.fuenteproxy.models.entities.Hecho;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HechoInputDTO {
    private String titulo;
    private String descripcion;
    private String categoria;
    private String fecha;
    private String fechaDeCarga;
    private String ubicacionLat; // latitud como string
    private String ubicacionLon; // longitud como string
    private String etiqueta;
    private String tipoHecho;
    private List<AdjuntoDTO> adjuntos = new java.util.ArrayList<>();

    public HechoInputDTO() {
    }
}

