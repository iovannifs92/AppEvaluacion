package com.sistemas.evaluacion.entidades;

public class datosInvestigacionInformacionA {
    int id, apregunta411,apregunta412,apregunta413,apregunta42,atotal;
    String  afolio;

    public datosInvestigacionInformacionA(int id, int apregunta411, int apregunta412,
                                          int apregunta413, int apregunta42, int atotal, String afolio) {
        this.id = id;
        this.apregunta411 = apregunta411;
        this.apregunta412 = apregunta412;
        this.apregunta413 = apregunta413;
        this.apregunta42 = apregunta42;
        this.atotal = atotal;
        this.afolio = afolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApregunta411() {
        return apregunta411;
    }

    public void setApregunta411(int apregunta411) {
        this.apregunta411 = apregunta411;
    }

    public int getApregunta412() {
        return apregunta412;
    }

    public void setApregunta412(int apregunta412) {
        this.apregunta412 = apregunta412;
    }

    public int getApregunta413() {
        return apregunta413;
    }

    public void setApregunta413(int apregunta413) {
        this.apregunta413 = apregunta413;
    }

    public int getApregunta42() {
        return apregunta42;
    }

    public void setApregunta42(int apregunta42) {
        this.apregunta42 = apregunta42;
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
