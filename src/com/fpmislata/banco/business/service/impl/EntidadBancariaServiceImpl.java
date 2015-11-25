package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.core.BusinessMessage;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Samuel Lao
 */
public class EntidadBancariaServiceImpl implements EntidadBancariaService {

    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;

    @Override
    public EntidadBancaria get(int id) {
        return entidadBancariaDAO.get(id);
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) throws BusinessException {

        List<BusinessMessage> businessMessages = new ArrayList<>();

        if (entidadBancaria.codigoEntidad == 0) {
            BusinessMessage businessMessage = new BusinessMessage("codigoEntidad: ", "El codigo de entidad Ha fallado.");
            businessMessages.add(businessMessage);
        }

        if ((entidadBancaria.nombre == null)  || (entidadBancaria.nombre.trim().isEmpty())) {
            BusinessMessage businessMessage = new BusinessMessage("Nombre: ", "El nombre está vacio.");
            businessMessages.add(businessMessage);
        }

        if (businessMessages.size() > 0) {
            throw new BusinessException(businessMessages);
        }
        
        return entidadBancariaDAO.insert(entidadBancaria);
        
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        return entidadBancariaDAO.update(entidadBancaria);
    }

    @Override
    public boolean delete(int id) {
        return entidadBancariaDAO.delete(id);
    }

    @Override
    public List<EntidadBancaria> findAll() {
        List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findAll();
        return entidadesBancarias;
    }

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        List<EntidadBancaria> entidadesBancarias = entidadBancariaDAO.findByNombre(nombre);
        return entidadesBancarias;
    }

}
