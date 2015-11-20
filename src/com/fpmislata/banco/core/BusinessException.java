package com.fpmislata.banco.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class BusinessException extends Exception {
    private List<BusinessMessage> businessMessages = new ArrayList<>();
    private String fieldName;
    private String mensaje;

    public BusinessException(String fieldName, String mensaje) {
        this.fieldName = fieldName;
        this.mensaje = mensaje;
    }

    public List<BusinessMessage> getBusinessMessages() {
        return businessMessages;
    }

    public void setBusinessMessages(List<BusinessMessage> businessMessages) {
        this.businessMessages = businessMessages;
    }

    public String getPropiedad() {
        return fieldName;
    }

    public void setPropiedad(String propiedad) {
        this.fieldName = propiedad;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
