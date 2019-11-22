package com.sistemas.evaluacion.entidades;

public class datosInvestigacionConsideracionesA {
    int id,apregunta31,apregunta32,apregunta33,atotal;
    String afolio;

    public datosInvestigacionConsideracionesA(int id, int apregunta31, int apregunta32,
                                              int apregunta33, int atotal, String afolio) {
        this.id = id;
        this.apregunta31 = apregunta31;
        this.apregunta32 = apregunta32;
        this.apregunta33 = apregunta33;
        this.atotal = atotal;
        this.afolio = afolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApregunta31() {
        return apregunta31;
    }

    public void setApregunta31(int apregunta31) {
        this.apregunta31 = apregunta31;
    }

    public int getApregunta32() {
        return apregunta32;
    }

    public void setApregunta32(int apregunta32) {
        this.apregunta32 = apregunta32;
    }

    public int getApregunta33() {
        return apregunta33;
    }

    public void setApregunta33(int apregunta33) {
        this.apregunta33 = apregunta33;
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
