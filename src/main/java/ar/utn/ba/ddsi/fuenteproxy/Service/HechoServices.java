package ar.utn.ba.ddsi.fuenteproxy.Service;

import ar.utn.ba.ddsi.fuenteproxy.models.Repository.IFuenteRepository;
import ar.utn.ba.ddsi.fuenteproxy.models.Repository.imp.FuenteRepository;
import ar.utn.ba.ddsi.fuenteproxy.models.entities.*;
import ar.utn.ba.ddsi.fuenteproxy.models.factory.FactoryFuenteProxy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HechoServices implements IHechoServices {
    private List<FuenteProxy> fuenteProxis = new ArrayList<>();
    private Long ultimoId = (long) 2.0; //RARIIISIMO,VER ESTO
    private FactoryFuenteProxy factoryFuenteProxy = new FactoryFuenteProxy() ;
    private IFuenteRepository fuenteRepository = new FuenteRepository();

    @Override
    public List<Hecho> BuscarHechos() {
        BuscarNuevasFuentes();
        List<Hecho> hechosObtenidos = new ArrayList<>();
        //Ojo que llega fuente proxy Null, no deberíam, por eso le hago el new Arraylist, falta constructo
        this.fuenteProxis.forEach(fuenteProxy -> hechosObtenidos.addAll(fuenteProxy.obtenerHechos()));
        //MOCKEO
        hechosObtenidos.add(new Hecho("hecho1","es un hecho",new Categoria("categoria1"),new Ubicacion(11,5), LocalDate.now()));
        return hechosObtenidos;
    }

    @Override
    public void BuscarNuevasFuentes() {
        this.fuenteProxis = this.fuenteRepository.buscarNuevasRutas(this.ultimoId);
        //String url  = "dsdas";
        //fuenteProxis.add(this.factoryFuenteProxy.createFuenteMetamapa(url));
    }
}
