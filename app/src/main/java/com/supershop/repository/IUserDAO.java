package com.supershop.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.supershop.model.User;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface IUserDAO {
    @Query("SELECT * FROM users WHERE id=:userid")
    Flowable<User> getUserById(long userid);

    @Query("SELECT * FROM users")
    Flowable<List<User>> getAllUsers();

    @Insert
    void inserUser(User...users);

    @Update
    void updateUser(User...users);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM users")
    void deleteAllUsers();

}