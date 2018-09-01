package com.supershop.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "products")
public class Product implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long id;

    @ColumnInfo(name = "product_name")
    private String productName;

    @ColumnInfo(name = "men")
    private String men;

    @ColumnInfo(name = "women")
    private String women;

    @ColumnInfo(name = "female")
    private String female;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] productImage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMen() {
        return men;
    }

    public void setMen(String men) {
        this.men = men;
    }

    public String getWomen() {
        return women;
    }

    public void setWomen(String women) {
        this.women = women;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }
}
