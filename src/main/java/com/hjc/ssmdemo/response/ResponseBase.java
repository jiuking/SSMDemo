package com.hjc.ssmdemo.response;


import com.hjc.ssmdemo.common.ResponseStatusConstant;

import java.io.Serializable;

/**
 * JSON响应报文基础类
 * Created by Bravowhale on 2017/3/15.
 */
public class ResponseBase implements Serializable{
    private static final long serialVersionUID = 1161498959421698794L;
    //状态
    private ResponseStatusConstant responseStatusConstant;
    //消息
    private String message;

    public ResponseBase(){

    }

    public ResponseBase(ResponseStatusConstant responseStatusConstant , String message){
        this.responseStatusConstant = responseStatusConstant;
        this.message = message;
    }

    public ResponseStatusConstant getResponseStatusConstant() {
        return responseStatusConstant;
    }

    public void setResponseStatusConstant(ResponseStatusConstant responseStatusConstant) {
        this.responseStatusConstant = responseStatusConstant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
