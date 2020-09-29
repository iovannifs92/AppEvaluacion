package com.sistemas.evaluacion.entidades;

public class datosInvestigacionConexionesA {
    int id,apregunta211,apregunta212,apregunta214,apregunta221,
            apregunta223,apregunta224,apregunta23,atotal;
    String  afolio;

    public datosInvestigacionConexionesA(int id, int apregunta211, int apregunta212, int apregunta214,
                                         int apregunta221, int apregunta223, int apregunta224, int apregunta23,
                                         int atotal, String afolio) {
        this.id = id;
        this.apregunta211 = apregunta211;
        this.apregunta212 = apregunta212;
        this.apregunta214 = apregunta214;
        this.apregunta221 = apregunta221;
        this.apregunta223 = apregunta223;
        this.apregunta224 = apregunta224;
        this.apregunta23 = apregunta23;
        this.atotal = atotal;
        this.afolio = afolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApregunta211() {
        return apregunta211;
    }

    public void setApregunta211(int apregunta211) {
        this.apregunta211 = apregunta211;
    }

    public int getApregunta212() {
        return apregunta212;
    }

    public void setApregunta212(int apregunta212) {
        this.apregunta212 = apregunta212;
    }

    public int getApregunta214() {
        return apregunta214;
    }

    public void setApregunta214(int apregunta214) {
        this.apregunta214 = apregunta214;
    }

    public int getApregunta221() {
        return apregunta221;
    }

    public void setApregunta221(int apregunta221) {
        this.apregunta221 = apregunta221;
    }

    public int getApregunta223() {
        return apregunta223;
    }

    public void setApregunta223(int apregunta223) {
        this.apregunta223 = apregunta223;
    }

    public int getApregunta224() {
        return apregunta224;
    }

    public void setApregunta224(int apregunta224) {
        this.apregunta224 = apregunta224;
    }

    public int getApregunta23() {
        return apregunta23;
    }

    public void setApregunta23(int apregunta23) {
        this.apregunta23 = apregunta23;
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
