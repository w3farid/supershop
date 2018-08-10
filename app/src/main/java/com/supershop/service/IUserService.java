package com.supershop.service;

import android.content.Context;

import com.supershop.model.User;

public interface IUserService extends ICommonService<User> {
    boolean isLogin(User user, Context context);
}
