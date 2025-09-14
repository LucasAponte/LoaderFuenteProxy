package ar.utn.ba.ddsi.fuenteproxy.models.Repository.imp;

import ar.utn.ba.ddsi.fuenteproxy.models.Repository.IFuenteRepository;
import ar.utn.ba.ddsi.fuenteproxy.models.entities.Fuente;
import ar.utn.ba.ddsi.fuenteproxy.models.entities.EnumTipoFuenteProxy;
import ar.utn.ba.ddsi.fuenteproxy.models.entities.FuenteProxy;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class FuenteRepository implements IFuenteRepository {

    @Override
    public List<FuenteProxy> buscarNuevasRutas(Long ultimoID){
        EnumTipoFuenteProxy tipoFuenteProxy = EnumTipoFuenteProxy.METAMAPA;
        List<FuenteProxy> rutas = new ArrayList<>();
        return rutas;
    }
}
