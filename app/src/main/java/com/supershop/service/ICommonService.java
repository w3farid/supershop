package com.supershop.service;

import android.content.Context;

import java.util.List;

public interface ICommonService<T> {
    void insertData(Context mContext, T t);
    void updateData(Context mContext, T t);
    void deleteById(Context mContext, T t);
    T getById(Context mContext, T t);
    List<T> getAll(Context mContext);
}
