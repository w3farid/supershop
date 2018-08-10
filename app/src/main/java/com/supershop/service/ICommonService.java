package com.supershop.service;

import java.util.List;

public interface ICommonService<T> {
    void insertData(T t);
    void updateData(T t);
    void deleteById(Long id);
    T getById(Long id);
    List<T> getAll();
}
