package com.sistemas.evaluacion.entidades;

public class datosVerificacionA {
    int id;
    String anombre,arelacion,afolio;

    public datosVerificacionA(int id, String anombre, String arelacion, String afolio) {
        this.id = id;
        this.anombre = anombre;
        this.arelacion = arelacion;
        this.afolio = afolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnombre() {
        return anombre;
    }

    public void setAnombre(String anombre) {
        this.anombre = anombre;
    }

    public String getArelacion() {
        return arelacion;
    }

    public void setArelacion(String arelacion) {
        this.arelacion = arelacion;
    }

    public String getAfolio() {
        return afolio;
    }

    public void setAfolio(String afolio) {
        this.afolio = afolio;
    }
}
