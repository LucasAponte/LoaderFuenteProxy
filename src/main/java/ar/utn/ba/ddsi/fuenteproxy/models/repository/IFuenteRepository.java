package ar.utn.ba.ddsi.fuenteproxy.models.Repository;


import ar.utn.ba.ddsi.fuenteproxy.models.entities.Fuente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFuenteRepository extends JpaRepository<Fuente, Long> {
    List<Fuente> findByIdFuenteGreaterThan(Long ultimoID);
}
