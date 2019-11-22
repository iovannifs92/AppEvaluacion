package com.sistemas.evaluacion.entidades;

public class datosInvestigacionProcesoLegalA {
    int id,apregunta71,apregunta72,atotal;
    String  afolio;

    public datosInvestigacionProcesoLegalA(int id, int apregunta71, int apregunta72, int atotal, String afolio) {
        this.id = id;
        this.apregunta71 = apregunta71;
        this.apregunta72 = apregunta72;
        this.atotal = atotal;
        this.afolio = afolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApregunta71() {
        return apregunta71;
    }

    public void setApregunta71(int apregunta71) {
        this.apregunta71 = apregunta71;
    }

    public int getApregunta72() {
        return apregunta72;
    }

    public void setApregunta72(int apregunta72) {
        this.apregunta72 = apregunta72;
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
