package com.sistemas.evaluacion.entidades;

//region Diccionario
//da.pa as Sumatoria_Tabaco,
//da.pb as Sumatoria_Alchohol,
//da.pc as Sumatoria_Cannabis,
//da.pd as Sumatoria_Cocaína,
//da.pe as Sumatoria_Anfetaminas,
//da.pf as Sumatoria_Inhalantes,
//da.pg as Sumatoria_Pastillas,
//da.ph as Sumatoria_Alucinogenos,
//da.pi as Sumatoria_Opiaceos,
//da.pj as Sumatoria_Otros,
//da.jOtro as Otra_Sustancia,
//da.e8 as Consumido_Droga_Inyectada,
//endregion

public class datosASSIST {
    int id;
    String pa, pb, pc, pd, pe, pf, pg, ph, pi, pj, jOtro, e8, Folio;

    //region Constructor
    public datosASSIST(int id, String pa, String pb, String pc, String pd, String pe, String pf, String pg,
                       String ph, String pi, String pj, String jOtro, String e8, String folio){
        this.id = id;
        this.pa = pa;
        this.pb = pb;
        this.pc = pc;
        this.pd = pd;
        this.pe = pe;
        this.pf = pf;
        this.pg = pg;
        this.ph = ph;
        this.pi = pi;
        this.pj = pj;
        this.jOtro = jOtro;
        this.e8 = e8;
        Folio = folio;
    }
    //endregion

    //region Get Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getJOtro() {
        return jOtro;
    }

    public void setJOtro(String e70) {
        this.jOtro = jOtro;
    }

    public String getE8() {
        return e8;
    }

    public void setE8(String e8) {
        this.e8 = e8;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    //endregion
}
