package com.hjc.ssmdemo.service.impl;

import com.hjc.ssmdemo.persistence.dao.TUserMapper;
import com.hjc.ssmdemo.persistence.entity.TUser;
import com.hjc.ssmdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Bravowhale on 2017/3/9.
 */
@Service("iuserService")
public class IUserServiceImpl implements IUserService{

    @Autowired
    private TUserMapper userDao;

    public TUser getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }
}
