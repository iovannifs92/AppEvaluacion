package com.sistemas.evaluacion.entidades;

public class datosInformacionCasoA {
    int id;
    String acarpeta,aexpedinte, afechadis, aotrafuente, acualfuente, adelito, aotro,adelitomencionado_145,adelitomencionado_164,
            ainternamieto,ahechosalegados,afolio;

    public datosInformacionCasoA(int id, String acarpeta,String aexpedinte, String afechadis, String aotrafuente, String acualfuente, String adelito,String aotro,
                                 String adelitomencionado_145, String adelitomencionado_164, String ainternamieto, String ahechosalegados,
                                 String afolio) {
        this.id = id;
        this.acarpeta = acarpeta;
        this.aexpedinte = aexpedinte;
        this.afechadis = afechadis;
        this.aotrafuente = aotrafuente;
        this.acualfuente = acualfuente;
        this.adelito = adelito;
        this.aotro = aotro;

        this.adelitomencionado_145 = adelitomencionado_145;

        this.adelitomencionado_164 = adelitomencionado_164;
        this.ainternamieto = ainternamieto;
        this.ahechosalegados = ahechosalegados;
        this.afolio = afolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcarpeta() { return acarpeta; }

    public void setAcarpeta(String acarpeta) { this.acarpeta = acarpeta; }

    public String getAexpedinte() {
        return aexpedinte;
    }

    public void setAexpedinte(String aexpedinte) {
        this.aexpedinte = aexpedinte;
    }

    public String getAfechadis() {
        return afechadis;
    }

    public void setAfechadis(String afechadis) {
        this.afechadis = afechadis;
    }

    public String getAotrafuente() {
        return aotrafuente;
    }

    public void setAotrafuente(String aotrafuente) {
        this.aotrafuente = aotrafuente;
    }

    public String getAcualfuente() {
        return acualfuente;
    }

    public void setAcualfuente(String acualfuente) {
        this.acualfuente = acualfuente;
    }

    public String getAdelito() {
        return adelito;
    }

    public void setAdelito(String adelito) {
        this.adelito = adelito;
    }

    public String getAotro() { return aotro; }

    public void setAotro(String aotro) { this.aotro = aotro; }

    public String getAdelitomencionado_145() {
        return adelitomencionado_145;
    }

    public void setAdelitomencionado_145(String adelitomencionado_145) { this.adelitomencionado_145 = adelitomencionado_145; }

    public String getAdelitomencionado_164() {
        return adelitomencionado_164;
    }

    public void setAdelitomencionado_164(String adelitomencionado_164) { this.adelitomencionado_164 = adelitomencionado_164; }

    public String getAinternamieto() {
        return ainternamieto;
    }

    public void setAinternamieto(String ainternamieto) {
        this.ainternamieto = ainternamieto;
    }

    public String getAhechosalegados() {
        return ahechosalegados;
    }

    public void setAhechosalegados(String ahechosalegados) { this.ahechosalegados = ahechosalegados; }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }
}
