package com.fpmislata.banco.business.domain;

/**
 *
 * @author alumno
 */
public class Usuario {

    private int idUsuario;
    private String nombre;
    private String encryptedPassword;
    private Rol rol;
    private String nick;

    public Usuario(String nombre, String encryptedPassword) {
        this.nombre = nombre;
        this.encryptedPassword = encryptedPassword;
    }

    public int getId() {
        return idUsuario;
    }

    public void setId(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

}
