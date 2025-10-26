package ar.utn.ba.ddsi.fuenteproxy.models.entities;

import jakarta.persistence.*;

@Entity
public class Fuente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuente;

    private String url;

    @Enumerated(EnumType.STRING)
    private EnumTipoFuenteProxy tipoFuenteProxy;

    public Fuente() {}

    public Fuente(Long id, String url, EnumTipoFuenteProxy tipoFuenteProxy) {
        this.idFuente = id;
        this.url = url;
        this.tipoFuenteProxy = tipoFuenteProxy;}
    public Long getIdFuente() {
        return idFuente;
    }
    public void setIdFuente(Long idFuente) {
        this.idFuente = idFuente;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public EnumTipoFuenteProxy getTipoFuenteProxy() {
        return tipoFuenteProxy;
    }
    public void setTipoFuenteProxy(EnumTipoFuenteProxy tipoFuenteProxy) {
        this.tipoFuenteProxy = tipoFuenteProxy;
    }

}
