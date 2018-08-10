package com.supershop.service;

import android.content.Context;
import android.text.TextUtils;

import com.supershop.database.IUserSource;
import com.supershop.model.User;
import com.supershop.utils.SaveSharedPreference;

import java.util.List;

public class UserService implements IUserService {

    @Override
    public void insertData(User user) {

    }

    @Override
    public void updateData(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        String a = "ab";
        return null;
    }

    @Override
    public boolean isLogin(User user, Context context) {
        boolean isLogin = validUsername(user.getUsername()) && validPassword(user.getPassword());

        if (isLogin){
            SaveSharedPreference.setLoggedIn(context, true);
            return isLogin;
        }else {
            SaveSharedPreference.setLoggedIn(context, false);
            return isLogin;
        }

    }

    private boolean validUsername(String username){
        boolean isValid = !TextUtils.isEmpty(username);
        return isValid;
    }

    private boolean validPassword(String password){
        boolean isValid = !TextUtils.isEmpty(password);
        return isValid;
    }

}
