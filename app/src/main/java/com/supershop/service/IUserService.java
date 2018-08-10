package com.supershop.service;

import com.supershop.model.User;

public interface IUserService extends ICommonService<User> {
    boolean isLogin();
}
