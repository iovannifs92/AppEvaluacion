package com.sistemas.evaluacion.entidades;

public class DatosEntrevistador {
    //region Variables Globales
    int id;
    String codigo, nombre;
    //endregion

    //region Constructor

    public DatosEntrevistador(int id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    //endregion

    //region Get Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String clave) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //endregion
}
