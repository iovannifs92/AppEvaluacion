package com.sistemas.evaluacion.entidades;

public class datosCarpetaInvestigacion {

    //region Variables Globales
    int id;
    String Carpeta,Folio, e111, e112, e113, e114, e115, e116, e117, e118, e119, e120, e121, e122, e123, e124, e125, e126;
    //endregion

    //region Constructor

    public datosCarpetaInvestigacion(int id, String e111, String e112, String e113, String e114, String e115, String e116, String e117,
                                     String e118, String e119, String e120, String e121, String e122, String e123, String e124, String e125,
                                     String e126, String carpeta, String folio) {
        this.id = id;
        this.e111 = e111;
        this.e112 = e112;
        this.e113 = e113;
        this.e114 = e114;
        this.e115 = e115;
        this.e116 = e116;
        this.e117 = e117;
        this.e118 = e118;
        this.e119 = e119;
        this.e120 = e120;
        this.e121 = e121;
        this.e122 = e122;
        this.e123 = e123;
        this.e124 = e124;
        this.e125 = e125;
        this.e126 = e126;
        Carpeta = carpeta;
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

    public String getE111() {
        return e111;
    }

    public void setE111(String e111) {
        this.e111 = e111;
    }

    public String getE112() {
        return e112;
    }

    public void setE112(String e112) {
        this.e112 = e112;
    }

    public String getE113() {
        return e113;
    }

    public void setE113(String e113) {
        this.e113 = e113;
    }

    public String getE114() {
        return e114;
    }

    public void setE114(String e114) {
        this.e114 = e114;
    }

    public String getE115() {
        return e115;
    }

    public void setE115(String e115) {
        this.e115 = e115;
    }

    public String getE116() {
        return e116;
    }

    public void setE116(String e116) {
        this.e116 = e116;
    }

    public String getE117() {
        return e117;
    }

    public void setE117(String e117) {
        this.e117 = e117;
    }

    public String getE118() {
        return e118;
    }

    public void setE118(String e118) {
        this.e118 = e118;
    }

    public String getE119() {
        return e119;
    }

    public void setE119(String e119) {
        this.e119 = e119;
    }

    public String getE120() {
        return e120;
    }

    public void setE120(String e120) {
        this.e120 = e120;
    }

    public String getE121() {
        return e121;
    }

    public void setE121(String e121) {
        this.e121 = e121;
    }

    public String getE122() {
        return e122;
    }

    public void setE122(String e122) {
        this.e122 = e122;
    }

    public String getE123() {
        return e123;
    }

    public void setE123(String e123) {
        this.e123 = e123;
    }

    public String getE124() {
        return e124;
    }

    public void setE124(String e124) {
        this.e124 = e124;
    }

    public String getE125() {
        return e125;
    }

    public void setE125(String e125) {
        this.e125 = e125;
    }

    public String getE126() {
        return e126;
    }

    public void setE126(String e126) {
        this.e126 = e126;
    }

    public String getCarpeta() {
        return Carpeta;
    }

    public void setCarpeta(String carpeta) {
        Carpeta = carpeta;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    //endregion
}

