package com.supershop.service;

import android.content.Context;

import com.supershop.model.User;

public interface IUserService extends ICommonService<User> {
    public boolean isLogin(User user, Context mContext);
}
