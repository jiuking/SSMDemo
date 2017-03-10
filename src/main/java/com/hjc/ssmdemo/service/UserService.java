package com.hjc.ssmdemo.service;

import com.hjc.ssmdemo.persistence.entity.User;

import java.util.Set;

/**
 * Created by Bravowhale on 2017/3/10.
 */
public interface UserService {
    Set<String > findRoles(String username);
    Set<String> findPermissions(String username);
    User findByUsername(String username);
}
