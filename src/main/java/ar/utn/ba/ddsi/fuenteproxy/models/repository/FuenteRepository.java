package ar.utn.ba.ddsi.fuenteproxy.models.repository;


import ar.utn.ba.ddsi.fuenteproxy.models.entities.Fuente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuenteRepository extends JpaRepository<Fuente, Long> {
    List<Fuente> findByIdFuenteGreaterThan(Long ultimoID);
}
