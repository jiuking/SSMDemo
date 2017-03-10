package com.hjc.ssmdemo.service.impl;

import com.hjc.ssmdemo.persistence.dao.UserMapper;
import com.hjc.ssmdemo.persistence.entity.User;
import com.hjc.ssmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by Bravowhale on 2017/3/10.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    public Set<String> findRoles(String username) {
//        return userDao.findRoles(username);
        return null;
    }

    public Set<String> findPermissions(String username) {
//        return userDao.findPermissions(username);
        return null;
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
