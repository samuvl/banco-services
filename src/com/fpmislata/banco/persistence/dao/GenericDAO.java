package com.fpmislata.banco.persistence.dao;

import java.util.List;

/**
 *
 * @author alumno
 * @param <T>
 */
public interface GenericDAO <T>{
    
    T get (int id);
    T insert(T t);
    T update(T t);
    boolean delete (int id);
    List<T> findAll();
}
