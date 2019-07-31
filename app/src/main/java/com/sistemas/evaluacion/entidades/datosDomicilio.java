package com.sistemas.evaluacion.entidades;

//region Diccionario
//dd.e7 as Calle,
//dd.e7_1 as Numero,
//dd.e8 as Colonia_Fraccionamiento,
//dd.e9 as Municipio,
//dd.e10 as Estado,
//dd.e11 as Tipo_Domicilo,
//dd.e12 as Descripción_Domicilio, dd.e13 as Tiempo_Radicando, dd.e14 as Horario_Localización, dd.e15 as Telefono_Casa, dd.e16 as Celular,
//dde32_1 as vive_Padres, dd.e17 as Nombre_Papá, dd.e18 as Domicilio_Papá, dd.e19 as Nombre_Mamá, dd.e20 as Domicilio_Mamá,
//dd.e21 as DomSecundario_Calle, dd.e22 as DomSecundario_Colonia_Fraccionamiento, dd.e23 as DomSecundario_Municipio,
//dd.e24 as DomSecundario_Estado, dd.e25 as DomSecundario_Tipo_Domicilio, dd.e26 DomSecundario_Descripción,
//dd.e27 as DomSecundario_Tiempo_Radicando, dd.e28 as DomSecundario_Horario_Localización, dd.e21_2 as Tiene_Propiedad, dd.e21_3 as Ubicación_Propiedad,
//dd.e29 as Estado_Civil, dd.e30 as Tiempo, dd.e31 as Hijos, dd.e106 as Latitud, dd.e107 as Longitud
//endregion

public class datosDomicilio {
    int id;
    String e7, e7_1, e8, e9, e10, e11, e12, e13, e14, e15, e16, e32_1, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e21_2, e21_3,
            e29, e30, e31, e106, e107, Folio;

    //region Constructor
    public datosDomicilio(int id, String e7, String e7_1, String e8, String e9, String e10, String e11, String e12, String e13, String e14, String e15, String e16,
                          String e32_1, String e17, String e18, String e19, String e20, String e21, String e22, String e23, String e24, String e25,
                          String e26, String e27, String e28, String e21_2, String e21_3, String e29, String e30, String e31, String e106, String e107, String folio) {
        this.id = id;
        this.e7 = e7;
        this.e7_1 = e7_1;
        this.e8 = e8;
        this.e9 = e9;
        this.e10 = e10;
        this.e11 = e11;
        this.e12 = e12;
        this.e13 = e13;
        this.e14 = e14;
        this.e15 = e15;
        this.e16 = e16;
        this.e32_1 = e32_1;
        this.e17 = e17;
        this.e18 = e18;
        this.e19 = e19;
        this.e20 = e20;
        this.e21 = e21;
        this.e22 = e22;
        this.e23 = e23;
        this.e24 = e24;
        this.e25 = e25;
        this.e26 = e26;
        this.e27 = e27;
        this.e28 = e28;
        this.e21_2 = e21_2;
        this.e21_3 = e21_3;
        this.e29 = e29;
        this.e30 = e30;
        this.e31 = e31;
        this.e106 = e106;
        this.e107 = e107;
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

    public String getE7() {
        return e7;
    }

    public void setE7(String e7) {
        this.e7 = e7;
    }

    public String getE7_1() {
        return e7_1;
    }

    public void setE7_1(String e7_1) {
        this.e7_1 = e7_1;
    }

    public String getE8() {
        return e8;
    }

    public void setE8(String e8) {
        this.e8 = e8;
    }

    public String getE9() {
        return e9;
    }

    public void setE9(String e9) {
        this.e9 = e9;
    }

    public String getE10() {
        return e10;
    }

    public void setE10(String e10) {
        this.e10 = e10;
    }

    public String getE11() {
        return e11;
    }

    public void setE11(String e11) {
        this.e11 = e11;
    }

    public String getE12() {
        return e12;
    }

    public void setE12(String e12) {
        this.e12 = e12;
    }

    public String getE13() {
        return e13;
    }

    public void setE13(String e13) {
        this.e13 = e13;
    }

    public String getE14() {
        return e14;
    }

    public void setE14(String e14) {
        this.e14 = e14;
    }

    public String getE15() {
        return e15;
    }

    public void setE15(String e15) {
        this.e15 = e15;
    }

    public String getE16() {
        return e16;
    }

    public void setE16(String e16) {
        this.e16 = e16;
    }

    public String getE32_1() {
        return e32_1;
    }

    public void setE32_1(String e32_1) {
        this.e32_1 = e32_1;
    }

    public String getE17() {
        return e17;
    }

    public void setE17(String e17) {
        this.e17 = e17;
    }

    public String getE18() {
        return e18;
    }

    public void setE18(String e18) {
        this.e18 = e18;
    }

    public String getE19() {
        return e19;
    }

    public void setE19(String e19) {
        this.e19 = e19;
    }

    public String getE20() {
        return e20;
    }

    public void setE20(String e20) {
        this.e20 = e20;
    }

    public String getE21() {
        return e21;
    }

    public void setE21(String e21) {
        this.e21 = e21;
    }

    public String getE22() {
        return e22;
    }

    public void setE22(String e22) {
        this.e22 = e22;
    }

    public String getE23() {
        return e23;
    }

    public void setE23(String e23) {
        this.e23 = e23;
    }

    public String getE24() {
        return e24;
    }

    public void setE24(String e24) {
        this.e24 = e24;
    }

    public String getE25() {
        return e25;
    }

    public void setE25(String e25) {
        this.e25 = e25;
    }

    public String getE26() {
        return e26;
    }

    public void setE26(String e26) {
        this.e26 = e26;
    }

    public String getE27() {
        return e27;
    }

    public void setE27(String e27) {
        this.e27 = e27;
    }

    public String getE28() {
        return e28;
    }

    public void setE28(String e28) {
        this.e28 = e28;
    }

    public String getE21_2() {
        return e21_2;
    }

    public void setE21_2(String e21_2) {
        this.e21_2 = e21_2;
    }

    public String getE21_3() {
        return e21_3;
    }

    public void setE21_3(String e21_3) {
        this.e21_3 = e21_3;
    }

    public String getE29() {
        return e29;
    }

    public void setE29(String e29) {
        this.e29 = e29;
    }

    public String getE30() {
        return e30;
    }

    public void setE30(String e30) {
        this.e30 = e30;
    }

    public String getE31() {
        return e31;
    }

    public void setE31(String e31) {
        this.e31 = e31;
    }

    public String getE106() {
        return e106;
    }

    public void setE106(String e106) {
        this.e106 = e106;
    }

    public String getE107() {
        return e107;
    }

    public void setE107(String e107) {
        this.e107 = e107;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    //endregion
}
