package ar.utn.ba.ddsi.fuenteproxy.models.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class FuenteMetamapa extends FuenteProxy {

    private String url;
    private final WebClient webClient;

    public FuenteMetamapa(@Value("www") String url, WebClient.Builder builder) {
        this.webClient = builder.build();
        this.url = url;
    }

    @Override
    public List<Hecho> obtenerHechos() {
        return obtenerHechosDesdeUrl(this.url + "/hechos");
    }

    public List<Hecho> obtenerHechosDesdeUrl(String urlCompleta) {
        return webClient.get()
                .uri(urlCompleta)
                .retrieve()
                .bodyToFlux(Hecho.class)
                .collectList().block();
    }

    // Obtener hechos por colección
    public List<Hecho> obtenerHechosDeColeccion(String identificador) {
        return obtenerHechosDesdeUrl(url + "/colecciones/" + identificador + "/hechos");
    }

}