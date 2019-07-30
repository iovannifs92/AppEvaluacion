package com.sistemas.evaluacion.entidades;

//region Diccionario
//dae.e60 as Ha_Viajado_Fuera,
//dae.e61 as País,
//dae.e62 as Estado,
//dae.e63 as Ciudad,
//dae.e64 as Fecha_Ingreso,
//dae.e64_1 as Tiempo_Regreso,
//dae.e65 as Fecha_Salida,
//dae.e65_1 as Tiempo_Fuera,
//dae.e66 as Tiene_Familiares_Extranjeros,
//dae.e67 as eNombre1,
//dae.e68 as extRelación1,
//dae.e69 as extPaís1,
//dae.e70 as extEstado1,
//dae.e71 as extCiudad1,
//dae.e72 as extFrequencia_Contacto1,
//dae.e67_1 as extNombre2,
//dae.e68_1 as extRelación2,
//dae.e69_1 as extPaís2,
//dae.e70_1 as extEstado2,
//dae.e71_1 as extCiudad2,
//dae.e72_1 as extFrequencia_Contacto2,
//dae.e73 as Tiene_Familiares_Estados,
//dae.e74 as estNombre1,
//dae.e75 as estRelación1,
//dae.e76 as estEstado1,
//dae.e77 as estCiudad1,
//dae.e78 as estFrequencia_Contacto1,
//dae.e74_1 as estNombre2,
//dae.e75_1 as estRelación2,
//dae.e76_1 as estEstado2,
//dae.e77_1 as estCiudad2,
//dae.e78_1 as estFrequencia_Contacto2,
//dae.e79 as Tiene_Pasaporte,
//dae.e80 as Tiene_VISA,
//dae.e81 as Observaciones,
//endregion

public class datosAbandonoEstado {
    int id;
    String e60, e61, e62, e63, e64, e64_1, e65, e65_1, e66, e67, e68, e69, e70, e71, e72, e67_1, e68_1, e69_1,
            e70_1, e71_1, e72_1, e73, e74, e75, e76, e77, e78, e74_1, e75_1, e76_1, e77_1, e78_1,
            e79, e80, e81, Folio;

    //region Constructor
    public datosAbandonoEstado(int id, String e60, String e61, String e62, String e63, String e64,String e64_1,
                               String e65, String e65_1, String e66, String e67, String e68, String e69,
                               String e70, String e71, String e72, String e67_1, String e68_1,
                               String e69_1, String e70_1, String e71_1, String e72_1, String e73,
                               String e74, String e75, String e76, String e77, String e78,
                               String e74_1, String e75_1, String e76_1, String e77_1, String e78_1,
                               String e79, String e80, String e81, String folio){
        this.id = id;
        this.e60 = e60;
        this.e61 = e61;
        this.e62 = e62;
        this.e63 = e63;
        this.e64 = e64;
        this.e64_1 = e64_1;
        this.e65 = e65;
        this.e65_1 = e65_1;
        this.e66 = e66;
        this.e67 = e67;
        this.e68 = e68;
        this.e69 = e69;
        this.e70 = e70;
        this.e71 = e71;
        this.e72 = e72;
        this.e67_1 = e67_1;
        this.e68_1 = e68_1;
        this.e69_1 = e69_1;
        this.e70_1 = e70_1;
        this.e71_1 = e71_1;
        this.e72_1 = e72_1;
        this.e73 = e73;
        this.e74 = e74;
        this.e75 = e75;
        this.e76 = e76;
        this.e77 = e77;
        this.e78 = e78;
        this.e74_1 = e74_1;
        this.e75_1 = e75_1;
        this.e76_1 = e76_1;
        this.e77_1 = e77_1;
        this.e78_1 = e78_1;
        this.e79 = e79;
        this.e80 = e80;
        this.e81 = e81;
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

    public String getE60() {
        return e60;
    }

    public void setE60(String e60) {
        this.e60 = e60;
    }

    public String getE61() {
        return e61;
    }

    public void setE61(String e61) {
        this.e61 = e61;
    }

    public String getE62() {
        return e62;
    }

    public void setE62(String e62) {
        this.e62 = e62;
    }

    public String getE63() {
        return e63;
    }

    public void setE63(String e63) {
        this.e63 = e63;
    }

    public String getE64() {
        return e64;
    }

    public void setE64(String e64) {
        this.e64 = e64;
    }

    public String getE64_1() {
        return e64_1;
    }

    public void setE64_1(String e64_1) {
        this.e64_1 = e64_1;
    }

    public String getE65() {
        return e65;
    }

    public void setE65(String e65) {
        this.e65 = e65;
    }

    public String getE65_1() {
        return e65_1;
    }

    public void setE65_1(String e65_1) {
        this.e65_1 = e65_1;
    }

    public String getE66() {
        return e66;
    }

    public void setE66(String e66) {
        this.e66 = e66;
    }

    public String getE67() {
        return e67;
    }

    public void setE67(String e67) {
        this.e67 = e67;
    }

    public String getE68() {
        return e68;
    }

    public void setE68(String e68) {
        this.e68 = e68;
    }

    public String getE69() {
        return e69;
    }

    public void setE69(String e69) {
        this.e69 = e69;
    }

    public String getE70() {
        return e70;
    }

    public void setE70(String e70) {
        this.e70 = e70;
    }

    public String getE71() {
        return e71;
    }

    public void setE71(String e71) {
        this.e71 = e71;
    }

    public String getE72() {
        return e72;
    }

    public void setE72(String e72) {
        this.e72 = e72;
    }

    public String getE67_1() {
        return e67_1;
    }

    public void setE67_1(String e67_1) {
        this.e67_1 = e67_1;
    }

    public String getE68_1() {
        return e68_1;
    }

    public void setE68_1(String e68_1) {
        this.e68_1 = e68_1;
    }

    public String getE69_1() {
        return e69_1;
    }

    public void setE69_1(String e69_1) {
        this.e69_1 = e69_1;
    }

    public String getE70_1() {
        return e70_1;
    }

    public void setE70_1(String e70_1) {
        this.e70_1 = e70_1;
    }

    public String getE71_1() {
        return e71_1;
    }

    public void setE71_1(String e71_1) {
        this.e71_1 = e71_1;
    }

    public String getE72_1() {
        return e72_1;
    }

    public void setE72_1(String e72_1) {
        this.e72_1 = e72_1;
    }

    public String getE73() {
        return e73;
    }

    public void setE73(String e73) {
        this.e73 = e73;
    }

    public String getE74() {
        return e74;
    }

    public void setE74(String e74) {
        this.e74 = e74;
    }

    public String getE75() {
        return e75;
    }

    public void setE75(String e75) {
        this.e75 = e75;
    }

    public String getE76() {
        return e76;
    }

    public void setE76(String e76) {
        this.e76 = e76;
    }

    public String getE77() {
        return e77;
    }

    public void setE77(String e77) {
        this.e77 = e77;
    }

    public String getE78() {
        return e78;
    }

    public void setE78(String e78) {
        this.e78 = e78;
    }

    public String getE74_1() {
        return e74_1;
    }

    public void setE74_1(String e74_1) {
        this.e74_1 = e74_1;
    }

    public String getE75_1() {
        return e75_1;
    }

    public void setE75_1(String e75_1) {
        this.e75_1 = e75_1;
    }

    public String getE76_1() {
        return e76_1;
    }

    public void setE76_1(String e76_1) {
        this.e76_1 = e76_1;
    }

    public String getE77_1() {
        return e77_1;
    }

    public void setE77_1(String e77_1) {
        this.e77_1 = e77_1;
    }

    public String getE78_1() {
        return e78_1;
    }

    public void setE78_1(String e78_1) {
        this.e78_1 = e78_1;
    }

    public String getE79() {
        return e79;
    }

    public void setE79(String e79) {
        this.e79 = e79;
    }

    public String getE80() {
        return e80;
    }

    public void setE80(String e80) {
        this.e80 = e80;
    }

    public String getE81() {
        return e81;
    }

    public void setE81(String e81) {
        this.e81 = e81;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    //endregion
}
