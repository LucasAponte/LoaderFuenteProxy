package ar.utn.ba.ddsi.fuenteproxy.models.Repository;


import ar.utn.ba.ddsi.fuenteproxy.models.entities.Fuente;
import ar.utn.ba.ddsi.fuenteproxy.models.entities.FuenteProxy;
import ar.utn.ba.ddsi.fuenteproxy.models.entities.Hecho;

import java.util.List;

public interface IFuenteRepository {
    public List<FuenteProxy> buscarNuevasRutas(Long ultimoID);
}
