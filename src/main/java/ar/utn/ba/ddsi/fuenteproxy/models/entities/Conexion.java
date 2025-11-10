package ar.utn.ba.ddsi.fuenteproxy.models.entities;

import java.time.LocalDateTime;
import java.util.Map;

public interface Conexion {
    public LocalDateTime ultimaConsulta = LocalDateTime.now();
    Map<String, Object> siguienteHecho(String url);
}