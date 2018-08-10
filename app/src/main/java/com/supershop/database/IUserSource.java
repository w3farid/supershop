package com.supershop.database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.supershop.model.User;

import java.util.List;

import io.reactivex.Flowable;

public interface IUserSource {
    Flowable<User> getUserById(long userid);
    Flowable<List<User>> getAllUsers();
    void inserUser(User...users);
    void updateUser(User...users);
    void deleteUser(User user);
    void deleteAllUsers();
}
