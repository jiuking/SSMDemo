package com.hjc.ssmdemo.common;

/**
 * Created by Bravowhale on 2017/3/15.
 */
public enum ResponseStatusConstant {
    SUCCESS("S"),FAILURE("F");
    private String code;
    ResponseStatusConstant(String code){
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
