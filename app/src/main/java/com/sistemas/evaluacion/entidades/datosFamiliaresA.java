package com.sistemas.evaluacion.entidades;

public class datosFamiliaresA {
    int id;
    String anombre1,arelacion1,aedad1,atelefono1,avivecon1,anombre2,arelacion2,aedad2,atelefono2,avivecon2,aubicarfam,anombrefam,arelacionfam,alocalidadfam,afolio;

    public datosFamiliaresA(int id, String anombre1, String arelacion1, String aedad1, String atelefono1, String avivecon1,
                            String anombre2, String arelacion2, String aedad2, String atelefono2, String avivecon2,
                            String aubicarfam,String anombrefam, String arelacionfam, String alocalidadfam, String afolio) {
        this.id = id;
        this.anombre1 = anombre1;
        this.arelacion1 = arelacion1;
        this.aedad1 = aedad1;
        this.atelefono1 = atelefono1;
        this.avivecon1 = avivecon1;
        this.anombre2 = anombre2;
        this.arelacion2 = arelacion2;
        this.aedad2 = aedad2;
        this.atelefono2 = atelefono2;
        this.avivecon2 = avivecon2;
        this.aubicarfam = aubicarfam;
        this.anombrefam = anombrefam;
        this.arelacionfam = arelacionfam;
        this.alocalidadfam = alocalidadfam;
        this.afolio = afolio;
    }
//region get-set
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getAnombre1() { return anombre1; }

    public void setAnombre1(String anombre1) { this.anombre1 = anombre1; }

    public String getArelacion1() { return arelacion1; }

    public void setArelacion1(String arelacion1) { this.arelacion1 = arelacion1; }

    public String getAedad1() { return aedad1; }

    public void setAedad1(String aedad1) { this.aedad1 = aedad1; }

    public String getAtelefono1() { return atelefono1; }

    public void setAtelefono1(String atelefono1) { this.atelefono1 = atelefono1; }

    public String getAvivecon1() { return avivecon1; }

    public void setAvivecon1(String avivecon1) { this.avivecon1 = avivecon1; }

    public String getAnombre2() { return anombre2; }

    public void setAnombre2(String anombre2) { this.anombre2 = anombre2; }

    public String getArelacion2() { return arelacion2; }

    public void setArelacion2(String arelacion2) { this.arelacion2 = arelacion2; }

    public String getAedad2() { return aedad2; }

    public void setAedad2(String aedad2) { this.aedad2 = aedad2; }

    public String getAtelefono2() { return atelefono2; }

    public void setAtelefono2(String atelefono2) { this.atelefono2 = atelefono2; }

    public String getAvivecon2() { return avivecon2; }

    public void setAvivecon2(String avivecon2) { this.avivecon2 = avivecon2; }

    public String getAubicarfam() { return aubicarfam; }

    public void setAubicarfam(String aubicarfam) { this.aubicarfam = aubicarfam; }

    public String getAnombrefam() { return anombrefam; }

    public void setAnombrefam(String anombrefam) { this.anombrefam = anombrefam; }

    public String getArelacionfam() { return arelacionfam; }

    public void setArelacionfam(String arelacionfam) { this.arelacionfam = arelacionfam; }

    public String getAlocalidadfam() { return alocalidadfam; }

    public void setAlocalidadfam(String alocalidadfam) { this.alocalidadfam = alocalidadfam; }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }
    //endregion
}
