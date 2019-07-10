package com.sistemas.evaluacion.entidades;

public class datosVictima {
    //region Variables globales
    int id;
    String e101, e102, e103, e104, e105, Folio;
    //endregion

    //region Constructor

    public datosVictima(int id, String e101, String e102, String e103, String e104, String e105, String folio) {
        this.id = id;
        this.e101 = e101;
        this.e102 = e102;
        this.e103 = e103;
        this.e104 = e104;
        this.e105 = e105;
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

    public String getE101() {
        return e101;
    }

    public void setE101(String e101) {
        this.e101 = e101;
    }

    public String getE102() {
        return e102;
    }

    public void setE102(String e102) {
        this.e102 = e102;
    }

    public String getE103() {
        return e103;
    }

    public void setE103(String e103) {
        this.e103 = e103;
    }

    public String getE104() {
        return e104;
    }

    public void setE104(String e104) {
        this.e104 = e104;
    }

    public String getE105() {
        return e105;
    }

    public void setE105(String e105) {
        this.e105 = e105;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    //endregion
}
