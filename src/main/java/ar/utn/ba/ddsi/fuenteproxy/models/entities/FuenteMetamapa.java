package ar.utn.ba.ddsi.fuenteproxy.models.entities;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
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
        System.out.println("obtenerHechos en Metamapa");
        return obtenerHechosDesdeUrl(this.url + "/hechos");
    }

    public List<Hecho> obtenerHechosDesdeUrl(String urlCompleta) {
        try {
            // Evitar bloqueos largos: timeout corto y manejo de errores
            return webClient.get()
                    .uri(urlCompleta)
                    .retrieve()
                    .bodyToFlux(Hecho.class)
                    .collectList()
                    .timeout(Duration.ofSeconds(5))
                    .onErrorResume(ex -> {
                        // Loguear y devolver lista vacía en caso de error
                        System.err.println("Error al obtener hechos desde " + urlCompleta + ": " + ex.getMessage());
                        return Mono.just(Collections.emptyList());
                    })
                    .block();
        } catch (WebClientResponseException wex) {
            System.err.println("WebClient error: " + wex.getStatusCode() + " " + wex.getMessage());
            return Collections.emptyList();
        } catch (Exception ex) {
            System.err.println("Error inesperado en obtenerHechosDesdeUrl: " + ex.getMessage());
            return Collections.emptyList();
        }
    }

    // Obtener hechos por colección
    public List<Hecho> obtenerHechosDeColeccion(String identificador) {
        return obtenerHechosDesdeUrl(url + "/colecciones/" + identificador + "/hechos");
    }

}