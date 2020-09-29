package com.sistemas.evaluacion.entidades;

public class datosGeneralesA {
    int id;
    String apaterno,amaterno,anombre,asexo,aedad,afechanac,acurp,aestado,amunicipio,alocalidad,
            anacionalidad,aespanol,atraductor,afolio,averificacion,acarpetainvestigacion;

    public datosGeneralesA(int id, String apaterno,String amaterno,String anombre, String asexo, String aedad, String afechanac, String acurp,
                           String aestado, String amunicipio, String alocalidad, String anacionalidad,
                           String aespanol, String atraductor, String afolio,String averificacion,String acarpetainvestigacion) {
        this.id = id;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.anombre = anombre;
        this.asexo = asexo;
        this.aedad = aedad;
        this.afechanac = afechanac;
        this.acurp = acurp;
        this.aestado = aestado;
        this.amunicipio = amunicipio;
        this.alocalidad = alocalidad;
        this.anacionalidad = anacionalidad;
        this.aespanol = aespanol;
        this.atraductor = atraductor;
        this.afolio = afolio;
        this.averificacion = averificacion;
        this.acarpetainvestigacion = acarpetainvestigacion;
    }
//region set-get
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getApaterno() { return apaterno; }

    public void setApaterno(String apaterno) { this.apaterno = apaterno; }

    public String getAmaterno() { return amaterno; }

    public void setAmaterno(String amaterno) { this.amaterno = amaterno; }

    public String getAnombre() { return anombre; }

    public void setAnombre(String anombre) { this.anombre = anombre; }

    public String getAsexo() { return asexo; }

    public void setAsexo(String asexo) { this.asexo = asexo; }

    public String getAedad() { return aedad; }

    public void setAedad(String aedad) { this.aedad = aedad; }

    public String getAfechanac() { return afechanac; }

    public void setAfechanac(String afechanac) { this.afechanac = afechanac; }

    public String getAcurp() { return acurp; }

    public void setAcurp(String acurp) { this.acurp = acurp; }

    public String getAestado() { return aestado; }

    public void setAestado(String aestado) { this.aestado = aestado; }

    public String getAmunicipio() { return amunicipio; }

    public void setAmunicipio(String amunicipio) { this.amunicipio = amunicipio; }

    public String getAlocalidad() { return alocalidad; }

    public void setAlocalidad(String alocalidad) { this.alocalidad = alocalidad; }

    public String getAnacionalidad() { return anacionalidad; }

    public void setAnacionalidad(String anacionalidad) { this.anacionalidad = anacionalidad; }

    public String getAespanol() { return aespanol; }

    public void setAespanol(String aespanol) { this.aespanol = aespanol; }

    public String getAtraductor() { return atraductor; }

    public void setAtraductor(String atraductor) { this.atraductor = atraductor; }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }

    public String getAverificacion() { return averificacion; }

    public void setAverificacion(String averificacion) {
        this.averificacion = averificacion;
    }

    public String getAcarpetainvestigacion() { return acarpetainvestigacion; }

    public void setAcarpetainvestigacion(String acarpetainvestigacion) { this.acarpetainvestigacion = acarpetainvestigacion; }

    //endregion
}
