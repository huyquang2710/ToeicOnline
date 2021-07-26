package com.web.core.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable, T> { //Serializable Doc ghi du lieu trong bo nho
    List<T> findAll();
    T update(T entity);
    void save(T entity);
    T findById(ID id);
    Object[] findyProperty(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit);
    Integer delete(List<ID> ids);
}
