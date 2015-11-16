package com.fpmislata.banco.persistence.security.impl;

import com.fpmislata.banco.persistence.security.PasswordManager;
import org.jasypt.util.password.BasicPasswordEncryptor;

/**
 *
 * @author Samuel Lao
 */

public class PasswordManagerImplJasypt implements PasswordManager {
    BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

    @Override
    public String encrypt(String password) {
        return passwordEncryptor.encryptPassword(password);
    }

    @Override
    public boolean check(String password, String encyptedPassword) {
        return passwordEncryptor.checkPassword(password, encyptedPassword);
    }

}
