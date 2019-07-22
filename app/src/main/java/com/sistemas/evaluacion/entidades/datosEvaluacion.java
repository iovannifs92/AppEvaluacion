package com.sistemas.evaluacion.entidades;

public class datosEvaluacion {
    int id, arraigo, residenciaEdo, abandonoEdo, voluntadSometimiento, antecedentes, medidasNoPrivativas, escala;
    String Folio;

    public datosEvaluacion(int id, int arraigo, int residenciaEdo, int abandonoEdo, int voluntadSometimiento, int antecedentes,
                              int medidasNoPrivativas, int escala, String folio){
        this.id = id;;
        this.arraigo = arraigo;
        this.residenciaEdo = residenciaEdo;
        this.abandonoEdo = abandonoEdo;
        this.voluntadSometimiento = voluntadSometimiento;
        this.antecedentes = antecedentes;
        this.medidasNoPrivativas = medidasNoPrivativas;
        this.escala = escala;
        Folio = folio;
    }

    //region Get Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArraigo() {
        return arraigo;
    }

    public void setArraigo(int arraigo) {
        this.arraigo = arraigo;
    }

    public int getResidenciaEdo() {
        return residenciaEdo;
    }

    public void setResidenciaEdo(int residenciaEdo) {
        this.residenciaEdo = residenciaEdo;
    }

    public int getAbandonoEdo() {
        return abandonoEdo;
    }

    public void setAbandonoEdo(int abandonoEdo) {
        this.abandonoEdo = abandonoEdo;
    }

    public int getVoluntadSometimiento() {
        return voluntadSometimiento;
    }

    public void setVoluntadSometimiento(int voluntadSometimiento) {
        this.voluntadSometimiento = voluntadSometimiento;
    }

    public int getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(int antecedentes) {
        this.antecedentes = antecedentes;
    }

    public int getMedidasNoPrivativas() {
        return medidasNoPrivativas;
    }

    public void setMedidasNoPrivativas(int medidasNoPrivativas) {
        this.medidasNoPrivativas = medidasNoPrivativas;
    }

    public int getEscala() {
        return escala;
    }

    public void setEscala(int escala) {
        this.escala = escala;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    //endregion
}
