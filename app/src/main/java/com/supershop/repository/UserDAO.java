package com.supershop.repository;

import com.supershop.database.IUserSource;
import com.supershop.model.User;

import java.util.List;

import io.reactivex.Flowable;

public class UserDAO implements IUserSource {
    private IUserSource mLocalDataSource;
    private static UserDAO mInstance;

    public UserDAO(IUserSource mLocalDataSource){
        this.mLocalDataSource = mLocalDataSource;
    }

    public static UserDAO getmInstance(IUserSource mLocalDataSource){
        if (mInstance == null){
            mInstance = new UserDAO(mLocalDataSource);
        }
        return mInstance;
    }

    @Override
    public Flowable<User> getUserById(long userid) {
        return mLocalDataSource.getUserById(userid);
    }

    @Override
    public Flowable<List<User>> getAllUsers() {
        return mLocalDataSource.getAllUsers();
    }

    @Override
    public void inserUser(User... users) {
        mLocalDataSource.inserUser(users);
    }

    @Override
    public void updateUser(User... users) {
        mLocalDataSource.updateUser(users);
    }

    @Override
    public void deleteUser(User user) {
        mLocalDataSource.deleteUser(user);
    }

    @Override
    public void deleteAllUsers() {
        mLocalDataSource.deleteAllUsers();
    }
}
