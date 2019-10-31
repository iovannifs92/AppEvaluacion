package com.sistemas.evaluacion.entidades;

public class datosResponsablesA {
    int id;
    String aconsetimiento, anombre1, arelacion1, aoyente1, anombre2,arelacion2,aoyente2,afolio;


    public datosResponsablesA(int id, String aconsetimiento, String anombre1, String arelacion1, String aoyente1,
                              String anombre2, String arelacion2, String aoyente2, String afolio) {
        this.id = id;
        this.aconsetimiento = aconsetimiento;
        this.anombre1 = anombre1;
        this.arelacion1 = arelacion1;
        this.aoyente1 = aoyente1;
        this.anombre2 = anombre2;
        this.arelacion2 = arelacion2;
        this.aoyente2 = aoyente2;
        this.afolio = afolio;
    }
//region set-get
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getAconsetimiento() { return aconsetimiento; }

    public void setAconsetimiento(String aconsetimiento) { this.aconsetimiento = aconsetimiento; }

    public String getAnombre1() {
        return anombre1;
    }

    public void setAnombre1(String anombre1) {
        this.anombre1 = anombre1;
    }

    public String getArelacion1() {
        return arelacion1;
    }

    public void setArelacion1(String arelacion1) {
        this.arelacion1 = arelacion1;
    }

    public String getAoyente1() {
        return aoyente1;
    }

    public void setAoyente1(String aoyente1) {
        this.aoyente1 = aoyente1;
    }

    public String getAnombre2() {
        return anombre2;
    }

    public void setAnombre2(String anombre2) {
        this.anombre2 = anombre2;
    }

    public String getArelacion2() {
        return arelacion2;
    }

    public void setArelacion2(String arelacion2) {
        this.arelacion2 = arelacion2;
    }

    public String getAoyente2() {
        return aoyente2;
    }

    public void setAoyente2(String aoyente2) {
        this.aoyente2 = aoyente2;
    }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }
    //endregion
}
