package ar.utn.ba.ddsi.fuenteproxy.Service;

import ar.utn.ba.ddsi.fuenteproxy.models.repository.IFuenteRepository;
import ar.utn.ba.ddsi.fuenteproxy.models.entities.*;
import ar.utn.ba.ddsi.fuenteproxy.models.factory.FactoryFuenteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HechoServices implements IHechoServices {
    private List<FuenteProxy> fuenteProxis = new ArrayList<>();
    private Long ultimoId = (long) 0; //RARIIISIMO,VER ESTO

    private FactoryFuenteProxy factoryFuenteProxy = FactoryFuenteProxy.getInstance();
    @Autowired
    private IFuenteRepository fuenteRepository ;

    @Override
    public List<Hecho> BuscarHechos() {
        System.out.println("Buscando Hechos");
        BuscarNuevasFuentes();
        List<Hecho> hechosObtenidos = new ArrayList<>();
        //Ojo que llega fuente proxy Null, no deberíam, por eso le hago el new Arraylist, falta constructo
        this.fuenteProxis.forEach(fuenteProxy -> hechosObtenidos.addAll(fuenteProxy.obtenerHechos()));
        //MOCKEO
        //hechosObtenidos.add(new Hecho("hecho1","es un hecho",new Categoria("categoria1"),new Ubicacion(11,5), LocalDate.now()));
        return hechosObtenidos;
    }

    @Override
    public void BuscarNuevasFuentes() {
        System.out.println("Buscando Nuevas Fuentes");
        List<Fuente> fuentes = this.fuenteRepository.findByIdFuenteGreaterThan(this.ultimoId);
        fuentes.forEach(fuente -> {
            System.out.println(fuente.getIdFuente());
            System.out.println(fuente.getNombre());
            System.out.println(fuente.getTipoFuente());
        });
        fuentes.forEach(fuente -> {
            this.fuenteProxis.add(this.factoryFuenteProxy.createFuenteProxy(fuente));
        });
        //PRUEBA
        this.fuenteProxis.forEach(fuenteProxy ->{
                System.out.println("Fuente Proxy agregada: " + fuenteProxy.toString());

            }
        );
    }
}
