package com.sistemas.evaluacion.entidades;

public class datosFichaFamiliarA {
    int id;
    String acalle, anumero, acolonia, acp,  amunicipio, aestado, apais,
    atemporalidad, adomiciliof, alocalidad1,atemporalidadant1, alocalidad2, atemporalidadant2, alocalidad3, atemporalidadant3,afolio;

    public datosFichaFamiliarA(int id, String acalle, String anumero, String acolonia, String acp, String amunicipio,
                              String aestado, String apais, String atemporalidad, String adomiciliof, String alocalidad1,
                              String atemporalidadant1, String alocalidad2,String atemporalidadant2, String afolio,
                               String alocalidad23,String atemporalidadant3) {
        this.id = id;
        this.acalle = acalle;
        this.anumero = anumero;
        this.acolonia = acolonia;
        this.acp = acp;
        this.amunicipio = amunicipio;
        this.aestado = aestado;
        this.apais = apais;
        this.atemporalidad = atemporalidad;
        this.adomiciliof = adomiciliof;
        this.alocalidad1 = alocalidad1;
        this.atemporalidadant1 = atemporalidadant1;
        this.alocalidad2 = alocalidad2;
        this.atemporalidadant2 = atemporalidadant2;
        this.alocalidad3 = alocalidad3;
        this.atemporalidadant3 = atemporalidadant3;
        this.afolio= afolio;
    }
//region get-set
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getAcalle() { return acalle; }

    public void setAcalle(String acalle) { this.acalle = acalle; }

    public String getAnumero() { return anumero; }

    public void setAnumero(String anumero) { this.anumero = anumero; }

    public String getAcolonia() { return acolonia; }

    public void setAcolonia(String acolonia) { this.acolonia = acolonia; }

    public String getAcp() { return acp; }

    public void setAcp(String acp) { this.acp = acp; }

    public String getAmunicipio() { return amunicipio; }

    public void setAmunicipio(String amunicipio) { this.amunicipio = amunicipio; }

    public String getAestado() { return aestado; }

    public void setAestado(String aestado) { this.aestado = aestado; }

    public String getApais() { return apais; }

    public void setApais(String apais) { this.apais = apais; }

    public String getAtemporalidad() { return atemporalidad; }

    public void setAtemporalidad(String atemporalidad) { this.atemporalidad = atemporalidad; }

    public String getAdomiciliof() { return adomiciliof; }

    public void setAdomiciliof(String adomiciliof) { this.adomiciliof = adomiciliof; }

    public String getAlocalidad1() { return alocalidad1; }

    public void setAlocalidad1(String alocalidad) { this.alocalidad1 = alocalidad; }

    public String getAtemporalidadant1() { return atemporalidadant1; }

    public void setAtemporalidadant1(String atemporalidadant) { this.atemporalidadant1 = atemporalidadant; }

    public String getAlocalidad2() { return alocalidad2; }

    public void setAlocalidad2(String alocalidad2) { this.alocalidad2 = alocalidad2; }

    public String getAtemporalidadant2() { return atemporalidadant2; }

    public void setAtemporalidadant2(String atemporalidadant2) { this.atemporalidadant2 = atemporalidadant2; }

    public String getAlocalidad3() { return alocalidad3; }

    public void setAlocalidad3(String alocalidad3) { this.alocalidad3 = alocalidad3; }

    public String getAtemporalidadant3() { return atemporalidadant3; }

    public void setAtemporalidadant3(String atemporalidadant3) { this.atemporalidadant3 = atemporalidadant3; }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }

    //endregion
}
