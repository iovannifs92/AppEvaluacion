package com.sistemas.evaluacion.entidades;

public class datosInvestigacionProcesosA {
    int id, apregunta51, apregunta52,atotal;
    String afolio;

    public datosInvestigacionProcesosA(int id,int apregunta51,int apregunta52, int atotal, String afolio) {
        this.id = id;
        this.apregunta51 = apregunta51;
        this.apregunta52 = apregunta52;
        this.atotal = atotal;
        this.afolio = afolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApregunta51() {
        return apregunta51;
    }

    public void setApregunta51(int apregunta51) {
        this.apregunta51 = apregunta51;
    }

    public int getApregunta52() {
        return apregunta52;
    }

    public void setApregunta52(int apregunta52) {
        this.apregunta52 = apregunta52;
    }

    public int getAtotal() {
        return atotal;
    }

    public void setAtotal(int atotal) {
        this.atotal = atotal;
    }

    public String getAfolio() {
        return afolio;
    }

    public void setAfolio(String afolio) {
        this.afolio = afolio;
    }
}
