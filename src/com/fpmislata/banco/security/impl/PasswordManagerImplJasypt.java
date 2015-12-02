package com.fpmislata.banco.security.impl;

import com.fpmislata.banco.security.PasswordManager;
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
