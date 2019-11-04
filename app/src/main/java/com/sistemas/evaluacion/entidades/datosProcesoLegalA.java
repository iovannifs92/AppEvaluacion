package com.sistemas.evaluacion.entidades;

public class datosProcesoLegalA {

    int id;
    String ariesgocontinuo,aexpliquecontinuo,aamanazatestigo,aexpliqueamenaza,afolio;

    public datosProcesoLegalA(int id, String ariesgocontinuo, String aexpliquecontinuo, String aamanazatestigo,
                              String aexpliqueamenaza,String afolio) {
        this.id = id;
        this.ariesgocontinuo = ariesgocontinuo;
        this.aexpliquecontinuo = aexpliquecontinuo;
        this.aamanazatestigo = aamanazatestigo;
        this.aexpliqueamenaza = aexpliqueamenaza;
        this.afolio = afolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAriesgocontinuo() {
        return ariesgocontinuo;
    }

    public void setAriesgocontinuo(String ariesgocontinuo) { this.ariesgocontinuo = ariesgocontinuo; }

    public String getAexpliquecontinuo() {
        return aexpliquecontinuo;
    }

    public void setAexpliquecontinuo(String aexpliquecontinuo) { this.aexpliquecontinuo = aexpliquecontinuo; }

    public String getAamanazatestigo() {
        return aamanazatestigo;
    }

    public void setAamanazatestigo(String aamanazatestigo) { this.aamanazatestigo = aamanazatestigo; }

    public String getAexpliqueamenaza() {
        return aexpliqueamenaza;
    }

    public void setAexpliqueamenaza(String aexpliqueamenaza) { this.aexpliqueamenaza = aexpliqueamenaza; }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }
}
