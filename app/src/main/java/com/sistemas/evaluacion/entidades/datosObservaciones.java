package com.sistemas.evaluacion.entidades;

public class datosObservacion {
    int id;
    String field, observation, Folio;

    public datosObservacion(int id, String field, String observation, String folio){
        this.id = id;;
        this.observation = observation;
        Folio = folio;
    }

    //region Get Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    //endregion
}
