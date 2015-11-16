package com.fpmislata.banco.persistence.security;

/**
 *
 * @author alumno
 */
public interface PasswordManager {
    public String encrypt(String password);
    public boolean check(String password, String encyptedPassword);
}
