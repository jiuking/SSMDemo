package com.hjc.ssmdemo.persistence.entity;

/**
 * Created by Bravowhale on 2017/3/10.
 */
public class SUser {
    private String username;
    private String password;
    private SRole sRole;
    public SUser(){

    }
    public SUser(String username,String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SRole getsRole() {
        return sRole;
    }

    public void setsRole(SRole sRole) {
        this.sRole = sRole;
    }
}
