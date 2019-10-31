package com.sistemas.evaluacion.entidades;

public class datosHistorialEscolarA {
    int id;
    String aasiste,aconcluyo,anombreact,adireccionact,atelefonoact,anivelact,agrado,anombreant1,alocalidad1,agradoant1,anombreant2,alocalidad2,agradoant2,afolio;

    public datosHistorialEscolarA(int id, String aasiste, String aconcluyo, String anombreact, String adireccionact,
                                  String atelefonoact, String anivelact, String agrado, String anombreant1, String alocalidad1,
                                  String agradoant1, String anombreant2, String alocalidad2, String agradoant2, String afolio) {
        this.id = id;
        this.aasiste = aasiste;
        this.aconcluyo = aconcluyo;
        this.anombreact = anombreact;
        this.adireccionact = adireccionact;
        this.atelefonoact = atelefonoact;
        this.anivelact = anivelact;
        this.agrado = agrado;
        this.anombreant1 = anombreant1;
        this.alocalidad1 = alocalidad1;
        this.agradoant1 = agradoant1;
        this.anombreant2 = anombreant2;
        this.alocalidad2 = alocalidad2;
        this.agradoant2 = agradoant2;
        this.afolio = afolio;
    }
//region set-get
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getAasiste() { return aasiste; }

    public void setAasiste(String aasiste) { this.aasiste = aasiste; }

    public String getAconcluyo() { return aconcluyo; }

    public void setAconcluyo(String aconcluyo) { this.aconcluyo = aconcluyo; }

    public String getAnombreact() { return anombreact; }

    public void setAnombreact(String anombreact) { this.anombreact = anombreact; }

    public String getAdireccionact() { return adireccionact; }

    public void setAdireccionact(String adireccionact) { this.adireccionact = adireccionact; }

    public String getAtelefonoact() { return atelefonoact; }

    public void setAtelefonoact(String atelefonoact) { this.atelefonoact = atelefonoact; }

    public String getAnivelact() { return anivelact; }

    public void setAnivelact(String anivelact) { this.anivelact = anivelact; }

    public String getAgrado() { return agrado; }

    public void setAgrado(String agrado) { this.agrado = agrado; }

    public String getAnombreant1() { return anombreant1; }

    public void setAnombreant1(String anombreant1) { this.anombreant1 = anombreant1; }

    public String getAlocalidad1() { return alocalidad1; }

    public void setAlocalidad1(String alocalidad1) { this.alocalidad1 = alocalidad1; }

    public String getAgradoant1() { return agradoant1; }

    public void setAgradoant1(String agradoant1) { this.agradoant1 = agradoant1; }

    public String getAnombreant2() { return anombreant2; }

    public void setAnombreant2(String anombreant2) { this.anombreant2 = anombreant2; }

    public String getAlocalidad2() { return alocalidad2; }

    public void setAlocalidad2(String alocalidad2) { this.alocalidad2 = alocalidad2; }

    public String getAgradoant2() { return agradoant2; }

    public void setAgradoant2(String agradoant2) { this.agradoant2 = agradoant2; }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }

    //endregion
}
