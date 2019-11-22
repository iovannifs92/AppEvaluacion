package com.sistemas.evaluacion.entidades;

public class datosInvestigacionResultadoA {
    int id,apuntajeR1,apuntajeR2,apuntajeR3;
    String arecomendacion,acasos_excepcionalesA,acasos_excepcionalesB,acasos_excepcionalesC,afolio;

    public datosInvestigacionResultadoA(int id, int apuntajeR1, int apuntajeR2, int apuntajeR3,
                                        String arecomendacion, String acasos_excepcionalesA, String acasos_excepcionalesB,
                                        String acasos_excepcionalesC, String afolio) {
        this.id = id;
        this.apuntajeR1 = apuntajeR1;
        this.apuntajeR2 = apuntajeR2;
        this.apuntajeR3 = apuntajeR3;
        this.arecomendacion = arecomendacion;
        this.acasos_excepcionalesA = acasos_excepcionalesA;
        this.acasos_excepcionalesB = acasos_excepcionalesB;
        this.acasos_excepcionalesC = acasos_excepcionalesC;
        this.afolio = afolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApuntajeR1() {
        return apuntajeR1;
    }

    public void setApuntajeR1(int apuntajeR1) {
        this.apuntajeR1 = apuntajeR1;
    }

    public int getApuntajeR2() {
        return apuntajeR2;
    }

    public void setApuntajeR2(int apuntajeR2) {
        this.apuntajeR2 = apuntajeR2;
    }

    public int getApuntajeR3() {
        return apuntajeR3;
    }

    public void setApuntajeR3(int apuntajeR3) {
        this.apuntajeR3 = apuntajeR3;
    }

    public String getArecomendacion() {
        return arecomendacion;
    }

    public void setArecomendacion(String arecomendacion) {
        this.arecomendacion = arecomendacion;
    }

    public String getAcasos_excepcionalesA() {
        return acasos_excepcionalesA;
    }

    public void setAcasos_excepcionalesA(String acasos_excepcionalesA) {
        this.acasos_excepcionalesA = acasos_excepcionalesA;
    }

    public String getAcasos_excepcionalesB() {
        return acasos_excepcionalesB;
    }

    public void setAcasos_excepcionalesB(String acasos_excepcionalesB) {
        this.acasos_excepcionalesB = acasos_excepcionalesB;
    }

    public String getAcasos_excepcionalesC() {
        return acasos_excepcionalesC;
    }

    public void setAcasos_excepcionalesC(String acasos_excepcionalesC) {
        this.acasos_excepcionalesC = acasos_excepcionalesC;
    }

    public String getAfolio() {
        return afolio;
    }

    public void setAfolio(String afolio) {
        this.afolio = afolio;
    }
}


