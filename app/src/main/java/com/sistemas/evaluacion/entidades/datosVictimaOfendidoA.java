package com.sistemas.evaluacion.entidades;

public class datosVictimaOfendidoA {
    int id;
    String aexistevictima,avivedomicilio,anovivevictima,acasomismodomicilio,acercania,aintegridad,aintenciones,afolio;

    public datosVictimaOfendidoA(int id, String aexistevictima, String avivedomicilio, String anovivevictima, String acasomismodomicilio,
                                 String aintegridad, String aintenciones, String afolio) {
        this.id = id;
        this.aexistevictima = aexistevictima;
        this.avivedomicilio = avivedomicilio;
        this.anovivevictima = anovivevictima;
        this.acasomismodomicilio = acasomismodomicilio;
        this.aintegridad = aintegridad;
        this.aintenciones = aintenciones;
        this.afolio = afolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAexistevictima() {
        return aexistevictima;
    }

    public void setAexistevictima(String aexistevictima) {
        this.aexistevictima = aexistevictima;
    }

    public String getAvivedomicilio() {
        return avivedomicilio;
    }

    public void setAvivedomicilio(String avivedomicilio) {
        this.avivedomicilio = avivedomicilio;
    }

    public String getAnovivevictima() {
        return anovivevictima;
    }

    public void setAnovivevictima(String anovivevictima) {
        this.anovivevictima = anovivevictima;
    }

    public String getAcasomismodomicilio() {
        return acasomismodomicilio;
    }

    public void setAcasomismodomicilio(String acasomismodomicilio) { this.acasomismodomicilio = acasomismodomicilio; }

    public String getAintegridad() {
        return aintegridad;
    }

    public void setAintegridad(String aintegridad) {
        this.aintegridad = aintegridad;
    }

    public String getAintenciones() {
        return aintenciones;
    }

    public void setAintenciones(String aintenciones) {
        this.aintenciones = aintenciones;
    }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }
}
