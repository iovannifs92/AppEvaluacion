package com.sistemas.evaluacion.entidades;

public class datosActividadesExtraescolaresA {
    int id;
    String arealiza,aactividad,alocalidad,acontacto,atelefono,afolio;

    public datosActividadesExtraescolaresA(int id, String arealiza, String aactividad,
                                           String alocalidad, String acontacto, String atelefono, String afolio) {
        this.id = id;
        this.arealiza = arealiza;
        this.aactividad = aactividad;
        this.alocalidad = alocalidad;
        this.acontacto = acontacto;
        this.atelefono = atelefono;
        this.afolio = afolio;
    }
//region get-set
    public int getId() { return id; }

    public void setId(int id) { this.id = id;  }

    public String getArealiza() { return arealiza; }

    public void setArealiza(String arealiza) { this.arealiza = arealiza; }

    public String getAactividad() { return aactividad; }

    public void setAactividad(String aactividad) { this.aactividad = aactividad; }

    public String getAlocalidad() { return alocalidad; }

    public void setAlocalidad(String alocalidad) { this.alocalidad = alocalidad; }

    public String getAcontacto() { return acontacto; }

    public void setAcontacto(String acontacto) { this.acontacto = acontacto; }

    public String getAtelefono() { return atelefono; }

    public void setAtelefono(String atelefono) { this.atelefono = atelefono; }

    public String getAfolio() { return afolio; }

    public void setAfolio(String afolio) { this.afolio = afolio; }

    //endregion
}