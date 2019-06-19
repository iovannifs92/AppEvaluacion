package com.sistemas.evaluacion.entidades;

//region Diccionario
//ds.e82 as Consume_Alcohol,
//ds.e90_alcohol as Alcohol_Frecuencia,
//ds.e91_alcohol as Alcohol_Cantidad,
//ds.e92_alcohol as Alcohol_Ultima_Fecha,
//ds.e83 as Consume_Tabaco,
//ds.e90_tabaco as Marihuana_Frecuencia,
//ds.e91_tabaco as Marihuana_Cantidad,
//ds.e92_tabaco as Marihuana_Ultima_Fecha,
//ds.e84 as Consume_Marihuana,
//ds.e90_marihuana as Alcohol_Frecuencia,
//ds.e91_marihuana as Alcohol_Cantidad,
//ds.e92_marihuana as Alcohol_Ultima_Fecha,
//ds.e85 as Consume_Pastillas,
//ds.e90_pastillas as Pastillas_Frecuencia,
//ds.e91_pastillas as Pastillas_Cantidad,
//ds.e92_pastillas as Pastillas_Ultima_Fecha,
//ds.e86 as Consume_Solvente,
//ds.e90_solventes as Solventes_Frecuencia,
//ds.e91_solventes as Solventes_Cantidad,
//ds.e92_solventes as Solventes_Ultima_Fecha,
//ds.e87 as Consume_Cristal,
//ds.e90_cristal as Cristal_Frecuencia,
//ds.e91_cristal as Cristal_Cantidad,
//ds.e92_cristal as Cristal_Ultima_Fecha,
//ds.e88 as Consume_Cocaina,
//ds.e90_cocaina as Cocaina_Frecuencia,
//ds.e91_cocaina as Cocaina_Cantidad,
//ds.e92_cocaina as Cocaina_Ultima_Fecha,
//ds.e89 as Consume_Otro,
//ds.e90_otroConsumo as Otro_Frecuencia,
//ds.e91_otroConsumo as Otro_Cantidad,
//ds.e92_otroConsumo as Otro_Ultima_Fecha,
//ds.e93_otroConsumo as Nombre_Otro,
//ds.e94 as Tiene_Enfermedad,
//ds.e95 as Especifique_Enfermedad,
//endregion

public class datosSalud {
    int id;
    String e82, e90_alcohol, e91_alcohol, e92_alcohol, e83, e90_tabaco, e91_tabaco, e92_tabaco, e84,
            e90_marihuana, e91_marihuana, e92_marihuana, e85, e90_pastillas, e91_pastillas,
            e92_pastillas, e86, e90_solventes, e91_solventes, e92_solventes, e87, e90_cristal,
            e91_cristal, e92_cristal, e88, e90_cocaina, e91_cocaina, e92_cocaina, e89,
            e93_otroConsumo, e90_otroConsumo, e91_otroConsumo, e92_otroConsumo, e94, e95, Folio;

    //region Constructor
    public datosSalud(int id, String e82, String e90_alcohol, String e91_alcohol,
                      String e92_alcohol, String e83, String e90_tabaco, String e91_tabaco,
                      String e92_tabaco, String e84, String e90_marihuana, String e91_marihuana,
                      String e92_marihuana, String e85, String e90_pastillas, String e91_pastillas,
                      String e92_pastillas, String e86, String e90_solventes, String e91_solventes,
                      String e92_solventes, String e87, String e90_cristal, String e91_cristal,
                      String e92_cristal, String e88, String e90_cocaina, String e91_cocaina,
                      String e92_cocaina, String e89, String e93_otroConsumo,
                      String e90_otroConsumo, String e91_otroConsumo, String e92_otroConsumo,
                      String e94, String e95, String folio){
        this.id = id;
        this.e82 = e82;
        this.e90_alcohol = e90_alcohol;
        this.e91_alcohol = e91_alcohol;
        this.e92_alcohol = e92_alcohol;
        this.e83 = e83;
        this.e90_tabaco = e90_tabaco;
        this.e91_tabaco = e91_tabaco;
        this.e92_tabaco = e92_tabaco;
        this.e84 = e84;
        this.e90_marihuana = e90_marihuana;
        this.e91_marihuana = e91_marihuana;
        this.e92_marihuana = e92_marihuana;
        this.e85 = e85;
        this.e90_pastillas = e90_pastillas;
        this.e91_pastillas = e91_pastillas;
        this.e92_pastillas = e92_pastillas;
        this.e86 = e86;
        this.e90_solventes = e90_solventes;
        this.e91_solventes = e91_solventes;
        this.e92_solventes = e92_solventes;
        this.e87 = e87;
        this.e90_cristal = e90_cristal;
        this.e91_cristal = e91_cristal;
        this.e92_cristal = e92_cristal;
        this.e88 = e88;
        this.e90_cocaina = e90_cocaina;
        this.e91_cocaina = e91_cocaina;
        this.e92_cocaina = e92_cocaina;
        this.e89 = e89;
        this.e93_otroConsumo = e93_otroConsumo;
        this.e90_otroConsumo = e90_otroConsumo;
        this.e91_otroConsumo = e91_otroConsumo;
        this.e92_otroConsumo = e92_otroConsumo;
        this.e94 = e94;
        this.e95 = e95;
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

    public String getE82() {
        return e82;
    }

    public void setE82(String e82) {
        this.e82 = e82;
    }

    public String getE90_alcohol() {
        return e90_alcohol;
    }

    public void setE90_alcohol(String e90_alcohol) {
        this.e90_alcohol = e90_alcohol;
    }

    public String getE91_alcohol() {
        return e91_alcohol;
    }

    public void setE91_alcohol(String e91_alcohol) {
        this.e91_alcohol = e91_alcohol;
    }

    public String getE92_alcohol() {
        return e92_alcohol;
    }

    public void setE92_alcohol(String e92_alcohol) {
        this.e92_alcohol = e92_alcohol;
    }

    public String getE83() {
        return e83;
    }

    public void setE83(String e83) {
        this.e83 = e83;
    }

    public String getE90_tabaco() {
        return e90_tabaco;
    }

    public void setE90_tabaco(String e90_tabaco) {
        this.e90_tabaco = e90_tabaco;
    }

    public String getE91_tabaco() {
        return e91_tabaco;
    }

    public void setE91_tabaco(String e91_tabaco) {
        this.e91_tabaco = e91_tabaco;
    }

    public String getE92_tabaco() {
        return e92_tabaco;
    }

    public void setE92_tabaco(String e92_tabaco) {
        this.e92_tabaco = e92_tabaco;
    }

    public String getE84() {
        return e84;
    }

    public void setE84(String e84) {
        this.e84 = e84;
    }

    public String getE90_marihuana() {
        return e90_marihuana;
    }

    public void setE90_marihuana(String e90_marihuana) {
        this.e90_marihuana = e90_marihuana;
    }

    public String getE91_marihuana() {
        return e91_marihuana;
    }

    public void setE91_marihuana(String e91_marihuana) {
        this.e91_marihuana = e91_marihuana;
    }

    public String getE92_marihuana() {
        return e92_marihuana;
    }

    public void setE92_marihuana(String e92_marihuana) {
        this.e92_marihuana = e92_marihuana;
    }

    public String getE85() {
        return e85;
    }

    public void setE85(String e85) {
        this.e85 = e85;
    }

    public String getE90_pastillas() {
        return e90_pastillas;
    }

    public void setE90_pastillas(String e90_pastillas) {
        this.e90_pastillas = e90_pastillas;
    }

    public String getE91_pastillas() {
        return e91_pastillas;
    }

    public void setE91_pastillas(String e91_pastillas) {
        this.e91_pastillas = e91_pastillas;
    }

    public String getE92_pastillas() {
        return e92_pastillas;
    }

    public void setE92_pastillas(String e92_pastillas) {
        this.e92_pastillas = e92_pastillas;
    }

    public String getE86() {
        return e86;
    }

    public void setE86(String e86) {
        this.e86 = e86;
    }

    public String getE90_solventes() {
        return e90_solventes;
    }

    public void setE90_solventes(String e90_solventes) {
        this.e90_solventes = e90_solventes;
    }

    public String getE91_solventes() {
        return e91_solventes;
    }

    public void setE91_solventes(String e91_solventes) {
        this.e91_solventes = e91_solventes;
    }

    public String getE92_solventes() {
        return e92_solventes;
    }

    public void setE92_solventes(String e92_solventes) {
        this.e92_solventes = e92_solventes;
    }

    public String getE87() {
        return e87;
    }

    public void setE87(String e87) {
        this.e87 = e87;
    }

    public String getE90_cristal() {
        return e90_cristal;
    }

    public void setE90_cristal(String e90_cristal) {
        this.e90_cristal = e90_cristal;
    }

    public String getE91_cristal() {
        return e91_cristal;
    }

    public void setE91_cristal(String e91_cristal) {
        this.e91_cristal = e91_cristal;
    }

    public String getE92_cristal() {
        return e92_cristal;
    }

    public void setE92_cristal(String e92_cristal) {
        this.e92_cristal = e92_cristal;
    }

    public String getE88() {
        return e88;
    }

    public void setE88(String e88) {
        this.e88 = e88;
    }

    public String getE90_cocaina() {
        return e90_cocaina;
    }

    public void setE90_cocaina(String e90_cocaina) {
        this.e90_cocaina = e90_cocaina;
    }

    public String getE91_cocaina() {
        return e91_cocaina;
    }

    public void setE91_cocaina(String e91_cocaina) {
        this.e91_cocaina = e91_cocaina;
    }

    public String getE92_cocaina() {
        return e92_cocaina;
    }

    public void setE92_cocaina(String e92_cocaina) {
        this.e92_cocaina = e92_cocaina;
    }

    public String getE89() {
        return e89;
    }

    public void setE89(String e89) {
        this.e89 = e89;
    }

    public String getE93_otroConsumo() {
        return e93_otroConsumo;
    }

    public void setE93_otroConsumo(String e93_otroConsumo) {
        this.e93_otroConsumo = e93_otroConsumo;
    }

    public String getE90_otroConsumo() {
        return e90_otroConsumo;
    }

    public void setE90_otroConsumo(String e90_otroConsumo) {
        this.e90_otroConsumo = e90_otroConsumo;
    }

    public String getE91_otroConsumo() {
        return e91_otroConsumo;
    }

    public void setE91_otroConsumo(String e91_otroConsumo) {
        this.e91_otroConsumo = e91_otroConsumo;
    }

    public String getE92_otroConsumo() {
        return e92_otroConsumo;
    }

    public void setE92_otroConsumo(String e92_otroConsumo) {
        this.e92_otroConsumo = e92_otroConsumo;
    }

    public String getE94() {
        return e94;
    }

    public void setE94(String e94) {
        this.e94 = e94;
    }

    public String getE95() {
        return e95;
    }

    public void setE95(String e95) {
        this.e95 = e95;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    //endregion
}
