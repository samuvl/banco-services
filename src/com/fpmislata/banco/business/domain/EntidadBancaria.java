package com.fpmislata.banco.business.domain;

import java.sql.Date;

/**
 *
 * @author alumno
 */
public class EntidadBancaria {

    public int idEntidadBancaria;
    public String nombre;
    public int codigoEntidad;
    public Date fechaCreacion;
    public String direccion;
    public String cif;

    public EntidadBancaria() {
    }

    public EntidadBancaria(String nombre, int codigoEntidad) {
        this.nombre = nombre;
        this.codigoEntidad = codigoEntidad;
    }

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(int codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

}
