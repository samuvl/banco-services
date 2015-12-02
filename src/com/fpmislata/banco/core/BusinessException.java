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
        BusinessMessage businessMessage = new BusinessMessage(fieldName, mensaje);
        this.businessMessages.add(businessMessage);
    }
    
    public BusinessException(List<BusinessMessage> businessMessages){
        this.businessMessages = businessMessages;
    }

    public List<BusinessMessage> getBusinessMessages() {
        return businessMessages;
    }

    public void setBusinessMessages(List<BusinessMessage> businessMessages) {
        this.businessMessages = businessMessages;
    }
    
    
}
