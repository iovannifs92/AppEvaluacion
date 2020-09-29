package com.sistemas.evaluacion.entidades;

public class datosInvestigacionVictimaA {
    int id, apregunta61,apregunta621,apregunta622,
            apregunta623,apregunta63,apregunta64,apregunta65,atotal;
    String  afolio;

    public datosInvestigacionVictimaA(int id, int apregunta61, int apregunta621,
                                      int apregunta622, int apregunta623, int apregunta63, int apregunta64,
                                      int apregunta65, int atotal, String afolio) {
        this.id = id;
        this.apregunta61 = apregunta61;
        this.apregunta621 = apregunta621;
        this.apregunta622 = apregunta622;
        this.apregunta623 = apregunta623;
        this.apregunta63 = apregunta63;
        this.apregunta64 = apregunta64;
        this.apregunta65 = apregunta65;
        this.atotal = atotal;
        this.afolio = afolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApregunta61() {
        return apregunta61;
    }

    public void setApregunta61(int apregunta61) {
        this.apregunta61 = apregunta61;
    }

    public int getApregunta621() {
        return apregunta621;
    }

    public void setApregunta621(int apregunta621) {
        this.apregunta621 = apregunta621;
    }

    public int getApregunta622() {
        return apregunta622;
    }

    public void setApregunta622(int apregunta622) {
        this.apregunta622 = apregunta622;
    }

    public int getApregunta623() {
        return apregunta623;
    }

    public void setApregunta623(int apregunta623) {
        this.apregunta623 = apregunta623;
    }

    public int getApregunta63() {
        return apregunta63;
    }

    public void setApregunta63(int apregunta63) {
        this.apregunta63 = apregunta63;
    }

    public int getApregunta64() {
        return apregunta64;
    }

    public void setApregunta64(int apregunta64) {
        this.apregunta64 = apregunta64;
    }

    public int getApregunta65() {
        return apregunta65;
    }

    public void setApregunta65(int apregunta65) {
        this.apregunta65 = apregunta65;
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
