package com.supershop.repository;

import com.supershop.database.IUserSource;
import com.supershop.model.User;

import java.util.List;

import io.reactivex.Flowable;

public class UserDataSource implements IUserSource {
    private IUserDAO iUserDAO;
    private static UserDataSource mInstance;

    public UserDataSource(IUserDAO userDAO){
        this.iUserDAO = userDAO;
    }

    public static UserDataSource getmInstance(IUserDAO userDAO){
        if(userDAO ==  null){
            mInstance = new UserDataSource(userDAO);
        }
        return mInstance;
    }


    @Override
    public Flowable<User> getUserById(long userid) {
        return iUserDAO.getUserById(userid);
    }

    @Override
    public Flowable<List<User>> getAllUsers() {
        return iUserDAO.getAllUsers();
    }

    @Override
    public void inserUser(User... users) {
        iUserDAO.inserUser(users);
    }

    @Override
    public void updateUser(User... users) {
        iUserDAO.updateUser(users);
    }

    @Override
    public void deleteUser(User user) {
        iUserDAO.deleteUser(user);
    }

    @Override
    public void deleteAllUsers() {
        iUserDAO.deleteAllUsers();
    }
}
