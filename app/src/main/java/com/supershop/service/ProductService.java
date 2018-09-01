package com.supershop.service;

import android.content.Context;

import com.supershop.model.Product;
import com.supershop.repository.ProductDatabase;

import java.util.List;

public class ProductService implements IProductService {


    @Override
    public void insertData(Context mContext, Product product) {
        ProductDatabase.getInstance(mContext).productDAO().inserProduct(product);

    }

    @Override
    public void updateData(Context mContext, Product product) {

    }

    @Override
    public void deleteById(Context mContext, Product product) {

    }

    @Override
    public Product getById(Context mContext, Product product) {
        return null;
    }

    @Override
    public List<Product> getAll(Context mContext) {
        return ProductDatabase.getInstance(mContext).productDAO().getAllProduct();
    }
}
