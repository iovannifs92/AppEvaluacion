package com.sistemas.evaluacion.entidades;

public class datosObservacionesA {
    int id;
    String acampo,aobservacion,aoriginal,afolio;

    public datosObservacionesA(int id, String acampo, String aobservacion, String aoriginal, String afolio) {
        this.id = id;
        this.acampo = acampo;
        this.aobservacion = aobservacion;
        this.aoriginal = aoriginal;
        this.afolio = afolio;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getAcampo() { return acampo; }

    public void setAcampo(String acampo) { this.acampo = acampo; }

    public String getAobservacion() { return aobservacion; }

    public void setAobservacion(String aobservacion) { this.aobservacion = aobservacion; }

    public String getAoriginal() {
        return aoriginal;
    }

    public void setAoriginal(String aoriginal) {
        this.aoriginal = aoriginal;
    }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }
}

