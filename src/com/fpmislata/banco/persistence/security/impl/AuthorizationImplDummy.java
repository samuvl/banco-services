package com.fpmislata.banco.persistence.security.impl;

import com.fpmislata.banco.business.domain.Rol;
import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.persistence.security.Authorization;

/**
 *
 * @author Samuel Lao Usuario puede ser Null
 */
public class AuthorizationImplDummy implements Authorization {

    @Override
    public boolean isAuthorizedURL(Usuario usuario, String url, String metodo) {
        /*usuario.getRol().equals(Rol.Administrador*/
        boolean isAuthorized;
        
        if (url.equalsIgnoreCase("/banco-api/api/login")) {
            isAuthorized = true;
        } else {
            if (usuario != null) {
                isAuthorized = true;
            } else {
                isAuthorized = false;
            }
        }
        return isAuthorized;
    }

}
