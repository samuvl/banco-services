package com.fpmislata.banco.business.domain;

/**
 *
 * @author alumno
 */
public class Usuario {

    private String nombre;
    private String encryptedPassword;
    private Rol rol;

    public Usuario(String nombre, String encryptedPassword) {
        this.nombre = nombre;
        this.encryptedPassword = encryptedPassword;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return encryptedPassword;
    }

    public void setPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
