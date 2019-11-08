package com.sistemas.evaluacion.entidades;

public class datosEntrevistadorA {
    int id;
    String acausa, afecha, aevaluador, afolio;

    public datosEntrevistadorA(int id, String acausa, String afecha, String aevaluador, String afolio) {
        this.id=id;
        this.acausa=acausa;
        this.afecha=afecha;
        this.aevaluador=aevaluador;
        this.afolio=afolio;
    }
//region set-get
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }

    public String getAcausa() { return acausa; }

    public void setAcausa(String acausa) { this.acausa = acausa; }

    public String getAfecha() { return afecha; }

    public void setAfecha(String afecha) { this.afecha = afecha; }

    public String getAevaluador() { return aevaluador; }

    public void setAevaluador(String aevaluador) { this.aevaluador = aevaluador; }
    //endregion
}