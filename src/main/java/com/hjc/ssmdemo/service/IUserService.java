package com.hjc.ssmdemo.service;

import com.hjc.ssmdemo.persistence.entity.TUser;

/**
 * Created by Bravowhale on 2017/3/9.
 */
public interface IUserService {
    public TUser getUserById(int userId);
}
