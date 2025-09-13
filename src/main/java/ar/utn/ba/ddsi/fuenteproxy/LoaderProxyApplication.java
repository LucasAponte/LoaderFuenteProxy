package ar.utn.ba.ddsi.fuenteproxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LoaderProxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoaderProxyApplication.class, args);
        log.info("Funciona");
    }
}
