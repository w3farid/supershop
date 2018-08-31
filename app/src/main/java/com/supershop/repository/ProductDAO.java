package com.supershop.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.supershop.model.Product;

import java.util.List;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM products WHERE id=:id")
    Product getProductById(long id);

    @Query("SELECT * FROM products")
    List<Product> getAllProduct();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserProduct(Product... products);

    @Update
    void updateProduct(Product... products);

    @Delete
    void deleteProduct(Product product);

    @Query("DELETE FROM products")
    void deleteAllUsers();

}