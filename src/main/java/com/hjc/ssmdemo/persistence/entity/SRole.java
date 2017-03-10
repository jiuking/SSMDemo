package com.hjc.ssmdemo.persistence.entity;

/**
 * Created by Bravowhale on 2017/3/10.
 */
public class SRole {
    private String rolename;
    public SRole(){

    }
    public SRole(String rolename){
        this.rolename = rolename;
    }
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
