package com.sistemas.evaluacion.entidades;

//region Diccionario
//dh.e32 as Personas_Vive_Actualmente,
//dh.e33 as Nombre1,
//dh.e34 as Parentesco,
//dh.e35 as Edad,
//dh.e36 as Ocupación,
//dh.e37 as Tiempo_Habita,
//dh.e33_1 as Nombre2,
//dh.e34_1 as Parentesco2,
//dh.e35_1 as Edad2,
//dh.e36_1 as Ocupación2,
//dh.e37_1 as Tiempo_Habita2,
//dh.e33_2 as Nombre3,
//dh.e34_2 as Parentesco3,
//dh.e35_2 as Edad3,
//dh.e36_2 as Ocupación3,
//dh.e37_2 as Tiempo_Habita3,
//dh.e33_3 as Nombre4,
//dh.e34_3 as Parentesco4,
//dh.e35_3 as Edad4,
//dh.e36_3 as Ocupación4,
//dh.e37_3 as Tiempo_Habita4,
//dh.e38 as Observaciones,
//dh.e32_2 as Tiene_Dependientes_Económicos,
//dh.e32_3 as Cantidad_Dependientes_Económicos,
//dh.e32_4 as Dependientes_Económicos_Dentro_Estado,
//dh.e32_5 as Ubicación_Dependientes_Económicos,
//dh.e32_6 as Relaciones_Dependientes_Económicos,
//dh.e32_7 as Otra_Relación_Dependientes_Económicos,
//endregion

public class datosHabitantes {
    int id;
    String e32, e33, e34, e35, e36, e37, e33_1, e34_1, e35_1, e36_1, e37_1, e33_2, e34_2, e35_2,
            e36_2, e37_2, e33_3, e34_3, e35_3, e36_3, e37_3, e38, e32_2, e32_3, e32_4, e32_5, e32_6, e32_7, Folio;

    //region Constructor
    public datosHabitantes(int id, String e32, String e33, String e34, String e35, String e36,
                           String e37, String e33_1, String e34_1, String e35_1, String e36_1,
                           String e37_1, String e33_2, String e34_2, String e35_2, String e36_2,
                           String e37_2, String e33_3, String e34_3, String e35_3, String e36_3,
                           String e37_3, String e38, String e32_2, String e32_3, String e32_4,
                           String e32_5, String e32_6, String e32_7, String folio){
        this.id = id;
        this.e32 = e32;
        this.e33 = e33;
        this.e34 = e34;
        this.e35 = e35;
        this.e36 = e36;
        this.e37 = e37;
        this.e33_1 = e33_1;
        this.e34_1 = e34_1;
        this.e35_1 = e35_1;
        this.e36_1 = e36_1;
        this.e37_1 = e37_1;
        this.e33_2 = e33_2;
        this.e34_2 = e34_2;
        this.e35_2 = e35_2;
        this.e36_2 = e36_2;
        this.e37_2 = e37_2;
        this.e33_3 = e33_3;
        this.e34_3 = e34_3;
        this.e35_3 = e35_3;
        this.e36_3 = e36_3;
        this.e37_3 = e37_3;
        this.e38 = e38;
        this.e32_2 = e32_2;
        this.e32_3 = e32_3;
        this.e32_4 = e32_4;
        this.e32_5 = e32_5;
        this.e32_6 = e32_6;
        this.e32_7 = e32_7;
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

    public String getE32() {
        return e32;
    }

    public void setE32(String e32) {
        this.e32 = e32;
    }

    public String getE33() {
        return e33;
    }

    public void setE33(String e33) {
        this.e33 = e33;
    }

    public String getE34() {
        return e34;
    }

    public void setE34(String e34) {
        this.e34 = e34;
    }

    public String getE35() {
        return e35;
    }

    public void setE35(String e35) {
        this.e35 = e35;
    }

    public String getE36() {
        return e36;
    }

    public void setE36(String e36) {
        this.e36 = e36;
    }

    public String getE37() {
        return e37;
    }

    public void setE37(String e37) {
        this.e37 = e37;
    }

    public String getE33_1() {
        return e33_1;
    }

    public void setE33_1(String e33_1) {
        this.e33_1 = e33_1;
    }

    public String getE34_1() {
        return e34_1;
    }

    public void setE34_1(String e34_1) {
        this.e34_1 = e34_1;
    }

    public String getE35_1() {
        return e35_1;
    }

    public void setE35_1(String e35_1) {
        this.e35_1 = e35_1;
    }

    public String getE36_1() {
        return e36_1;
    }

    public void setE36_1(String e36_1) {
        this.e36_1 = e36_1;
    }

    public String getE37_1() {
        return e37_1;
    }

    public void setE37_1(String e37_1) {
        this.e37_1 = e37_1;
    }

    public String getE33_2() {
        return e33_2;
    }

    public void setE33_2(String e33_2) {
        this.e33_2 = e33_2;
    }

    public String getE34_2() {
        return e34_2;
    }

    public void setE34_2(String e34_2) {
        this.e34_2 = e34_2;
    }

    public String getE35_2() {
        return e35_2;
    }

    public void setE35_2(String e35_2) {
        this.e35_2 = e35_2;
    }

    public String getE36_2() {
        return e36_2;
    }

    public void setE36_2(String e36_2) {
        this.e36_2 = e36_2;
    }

    public String getE37_2() {
        return e37_2;
    }

    public void setE37_2(String e37_2) {
        this.e37_2 = e37_2;
    }

    public String getE33_3() {
        return e33_3;
    }

    public void setE33_3(String e33_3) {
        this.e33_3 = e33_3;
    }

    public String getE34_3() {
        return e34_3;
    }

    public void setE34_3(String e34_3) {
        this.e34_3 = e34_3;
    }

    public String getE35_3() {
        return e35_3;
    }

    public void setE35_3(String e35_3) {
        this.e35_3 = e35_3;
    }

    public String getE36_3() {
        return e36_3;
    }

    public void setE36_3(String e36_3) {
        this.e36_3 = e36_3;
    }

    public String getE37_3() {
        return e37_3;
    }

    public void setE37_3(String e37_3) {
        this.e37_3 = e37_3;
    }

    public String getE38() {
        return e38;
    }

    public void setE38(String e38) {
        this.e38 = e38;
    }

    public String getE32_2() {
        return e32_2;
    }

    public void setE32_2(String e32_2) {
        this.e32_2 = e32_2;
    }

    public String getE32_3() {
        return e32_3;
    }

    public void setE32_3(String e32_3) {
        this.e32_3 = e32_3;
    }

    public String getE32_4() {
        return e32_4;
    }

    public void setE32_4(String e32_4) {
        this.e32_4 = e32_4;
    }

    public String getE32_5() {
        return e32_5;
    }

    public void setE32_5(String e32_5) {
        this.e32_5 = e32_5;
    }

    public String getE32_6() {
        return e32_6;
    }

    public void setE32_6(String e32_6) {
        this.e32_6 = e32_6;
    }

    public String getE32_7() {
        return e32_7;
    }

    public void setE32_7(String e32_7) {
        this.e32_7 = e32_7;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    //endregion
}
