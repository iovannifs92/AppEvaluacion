package com.sistemas.evaluacion.entidades;

public class datosGenerales {

    //region Variables Globales
    int id;
    String nombre, alias, fNacimiento, edad, lNacimiento, sexo, folio, fEntrevista, duracionE, entrevistador, observacionesF, tipo;
    //endregion

    //region Constructor
    public datosGenerales(int id, String nombre, String alias, String fNacimiento,
                          String edad, String lNacimiento, String sexo, String folio,
                          String fEntrevista, String duracionE, String entrevistador,
                          String observacionesF, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.alias = alias;
        this.fNacimiento = fNacimiento;
        this.edad = edad;
        this.lNacimiento = lNacimiento;
        this.sexo = sexo;
        this.folio = folio;
        this.fEntrevista = fEntrevista;
        this.duracionE = duracionE;
        this.entrevistador = entrevistador;
        this.observacionesF = observacionesF;
        this.tipo = tipo;
    }
    //endregion

    //region Getter y Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getlNacimiento() {
        return lNacimiento;
    }

    public void setlNacimiento(String lNacimiento) {
        this.lNacimiento = lNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getfEntrevista() {
        return fEntrevista;
    }

    public void setfEntrevista(String fEntrevista) {
        this.fEntrevista = fEntrevista;
    }

    public String getDuracionE() {
        return duracionE;
    }

    public void setDuracionE(String duracionE) {
        this.duracionE = duracionE;
    }

    public String getEntrevistador() {
        return entrevistador;
    }

    public void setEntrevistador(String entrevistador) {
        this.entrevistador = entrevistador;
    }

    public String getObservacionesF() {
        return observacionesF;
    }

    public void setObservacionesF(String observacionesF) {
        this.observacionesF = observacionesF;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    //endregion

}
