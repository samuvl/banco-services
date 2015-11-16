package com.fpmislata.banco.business.service;

import java.util.List;

/**
 *
 * @author Samuel Lao
 * @param <EB>
 */
public interface GenericService <EB> {
    
    EB get (int id);
    EB insert (EB eb);
    EB update (EB eb);
    boolean delete (int id);
    List<EB> findAll();
}
