package com.ntt.common.general.domains.service;


import com.ntt.common.general.domains.data.ResponseBase;

import java.util.List;


public interface IEndPointService  < T, ID> {

    List<T> saveAll(List<T> entityList);

    T save(T entity);

    T update(T entity);

    T delete(ID id);

    T getById(ID id);

    List<T> getAll();

    ResponseBase toResponseBase(Object object);

    T dtoToEntity(Object object);

}
