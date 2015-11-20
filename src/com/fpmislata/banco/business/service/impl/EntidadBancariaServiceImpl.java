package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
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
    public EntidadBancaria insert(EntidadBancaria eb) {
        try {
            if (eb.codigoEntidad == 0) {
                throw new BusinessException("codigoEntidad", "El codigo de entidad Ha fallado.");
            }
        } catch (BusinessException ex) {
            throw new RuntimeException(ex);
        }

        return entidadBancariaDAO.insert(eb);

    }

    @Override
    public EntidadBancaria update(EntidadBancaria eb) {
        return entidadBancariaDAO.update(eb);
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
