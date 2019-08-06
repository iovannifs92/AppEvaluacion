package com.sistemas.evaluacion.entidades;

public class datosGenerales {

    //region Variables Globales
    int id;
    String nombre, alias, fNacimiento, edad, lNacimiento, sexo, folio, fEntrevista, duracionE, entrevistador, observacionesF, tipo, assist,
            tieneVerificacion, tieneEvaluacion, tieneDomicilioS, otrosHabitantes, entrevistado, antecedentePenal, delito, otroDelito, carpetaInvestigacion;
    //endregion

    //region Constructor
    public datosGenerales(int id, String nombre, String alias, String fNacimiento,
                          String edad, String lNacimiento, String sexo, String folio,
                          String fEntrevista, String duracionE, String entrevistador,
                          String observacionesF, String tipo, String assist, String tieneVerificacion, String tieneEvaluacion, String tieneDomicilioS,
                          String otrosHabitantes, String entrevistado, String antecedentePenal,
                          String delito, String otroDelito, String carpetaInvestigacion) {
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
        this.assist = assist;
        this.tieneVerificacion = tieneVerificacion;
        this.tieneEvaluacion = tieneEvaluacion;
        this.tieneDomicilioS = tieneDomicilioS;
        this.otrosHabitantes = otrosHabitantes;
        this.entrevistado = entrevistado;
        this.antecedentePenal = antecedentePenal;
        this.delito = delito;
        this.otroDelito = otroDelito;
        this.carpetaInvestigacion=carpetaInvestigacion;
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

    public String getASSIST() {
        return assist;
    }

    public void setASSIST(String assist) {
        this.assist = assist;
    }

    public String getTieneVerificacion() {
        return tieneVerificacion;
    }

    public void setTieneVerificacion(String tieneVerificacion) {
        this.tieneVerificacion = tieneVerificacion;
    }

    public String getTieneEvaluacion() {
        return tieneEvaluacion;
    }

    public void setTieneEvaluacion(String tieneEvaluacion) {
        this.tieneEvaluacion = tieneEvaluacion;
    }

    public String getTieneDomicilioS() {
        return tieneDomicilioS;
    }

    public void setTieneDomicilioS(String tieneDomicilioS) {
        this.tieneDomicilioS = tieneDomicilioS;
    }

    public String getOtrosHabitantes() {
        return otrosHabitantes;
    }

    public void setOtrosHabitantes(String otrosHabitantes) {
        this.otrosHabitantes = otrosHabitantes;
    }

    public String getEntrevistado() {
        return entrevistado;
    }

    public void setEntrevistado(String entrevistado) {
        this.entrevistado = entrevistado;
    }

    public String getAntecedentePenal() {
        return antecedentePenal;
    }

    public void setAntecedentePenal(String antecedentePenal) {
        this.antecedentePenal = antecedentePenal;
    }

    public String getDelito() {
        return delito;
    }

    public void setDelito(String delito) {
        this.delito = delito;
    }

    public String getOtroDelito() {
        return otroDelito;
    }

    public void setOtroDelito(String otroDelito) {
        this.otroDelito = otroDelito;
    }

    public String getCarpetaInvestigacion() {
        return carpetaInvestigacion;
    }

    public void setCarpetaInvestigacion(String carpetaInvestigacion) {
        this.carpetaInvestigacion = carpetaInvestigacion;
    }

    //endregion

}
