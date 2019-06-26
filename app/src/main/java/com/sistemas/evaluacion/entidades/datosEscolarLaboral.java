package com.sistemas.evaluacion.entidades;

//region Diccionario
//Escolar
//del.e48 as Actualmente_Estudia,
//del.e49 as Nombre_Institucion,
//del.e50 as Ultimos_Estudios,
//Laboral
//del.e51 as Actualmente_Trabaja,
//del.e52 as Nombre_Trabajo,
//del.e53 as Dirección,
//del.e54 as Tipo_Trabajo,
//del.e55 as Horario,
//del.e56 as Fecha_Inicio,
//del.e57 as Dias_Laborales,
//del.e58 as Salario_Semanal,
//del.e59 as Como_Subsiste,
//endregion

public class datosEscolarLaboral {
    int id;
    String e48, e49, e50, e51, e52, e53, e54, e55, e57, e56, e58, e59, Folio;

    //region Constructor
    public datosEscolarLaboral(int id, String e48, String e49, String e50, String e51, String e52,
                               String e53, String e54, String e55, String e57, String e56,
                               String e58, String e59, String folio){
        this.id = id;
        this.e48 = e48;
        this.e49 = e49;
        this.e50 = e50;
        this.e51 = e51;
        this.e52 = e52;
        this.e53 = e53;
        this.e54 = e54;
        this.e55 = e55;
        this.e57 = e57;
        this.e56 = e56;
        this.e58 = e58;
        this.e59 = e59;
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

    public String getE48() {
        return e48;
    }

    public void setE48(String e48) {
        this.e48 = e48;
    }

    public String getE49() {
        return e49;
    }

    public void setE49(String e49) {
        this.e49 = e49;
    }

    public String getE50() {
        return e50;
    }

    public void setE50(String e50) {
        this.e50 = e50;
    }

    public String getE51() {
        return e51;
    }

    public void setE51(String e51) {
        this.e51 = e51;
    }

    public String getE52() {
        return e52;
    }

    public void setE52(String e52) {
        this.e52 = e52;
    }

    public String getE53() {
        return e53;
    }

    public void setE53(String e53) {
        this.e53 = e53;
    }

    public String getE54() {
        return e54;
    }

    public void setE54(String e54) {
        this.e54 = e54;
    }

    public String getE55() {
        return e55;
    }

    public void setE55(String e55) {
        this.e55 = e55;
    }

    public String getE57() {
        return e57;
    }

    public void setE57(String e57) {
        this.e57 = e57;
    }

    public String getE56() {
        return e56;
    }

    public void setE56(String e56) {
        this.e56 = e56;
    }

    public String getE58() {
        return e58;
    }

    public void setE58(String e58) {
        this.e58 = e58;
    }

    public String getE59() {
        return e59;
    }

    public void setE59(String e59) {
        this.e59 = e59;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    //endregion
}
