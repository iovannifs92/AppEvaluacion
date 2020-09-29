package com.sistemas.evaluacion.entidades;

public class datosRevisionMedicaA {
    int id;
    String aembarazada,amadre,aenfermendad,acual,adiscapacidad,amedicamento,aentrevistador,afolio;

    public datosRevisionMedicaA(int id, String aembarazada, String amadre, String aenfermendad,
                                String acual, String adiscapacidad, String amedicamento, String aentrevistador, String afolio) {
        this.id = id;
        this.aembarazada = aembarazada;
        this.amadre = amadre;
        this.aenfermendad = aenfermendad;
        this.acual = acual;
        this.adiscapacidad = adiscapacidad;
        this.amedicamento = amedicamento;
        this.aentrevistador = aentrevistador;
        this.afolio = afolio;
    }
//region get-set
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getAembarazada() { return aembarazada; }

    public void setAembarazada(String aembarazada) { this.aembarazada = aembarazada; }

    public String getAmadre() { return amadre; }

    public void setAmadre(String amadre) { this.amadre = amadre; }

    public String getAenfermendad() { return aenfermendad; }

    public void setAenfermendad(String aenfermendad) { this.aenfermendad = aenfermendad; }

    public String getAcual() { return acual; }

    public void setAcual(String acual) { this.acual = acual; }

    public String getAdiscapacidad() { return adiscapacidad; }

    public void setAdiscapacidad(String adiscapacidad) { this.adiscapacidad = adiscapacidad; }

    public String getAmedicamento() { return amedicamento; }

    public void setAmedicamento(String amedicamento) { this.amedicamento = amedicamento; }

    public String getAentrevistador() { return aentrevistador; }

    public void setAentrevistador(String aentrevistador) { this.aentrevistador = aentrevistador; }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }

    //endregion
}
