package com.follower.fizz.entity;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.sun.xml.internal.ws.developer.Serialization;

/**
 * Created by lin on 17-12-25.
 */
public enum AuthStatusMessage {

    LOGIN_USER_NOT_EXIST(false, "user not exist"),

    LOGIN_PASSWORD_ERROR(false, "password error"),

    LOGIN_SUCCESS(true, "login success"),

    REGISTER_USER_EXIST(false, "user exist"),

    REGISTER_SUCCESS(true, "success"),

    SESSEION_NOT_EXIST(false, "session not exist");

    private boolean isSuccess;

    private String statusMessage;

    private AuthStatusMessage(boolean isSuccess, String statusMessage) {
        this.isSuccess = isSuccess;
        this.statusMessage = statusMessage;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public String toString() {
        SerializeConfig config = new SerializeConfig();
        config.configEnumAsJavaBean(this.getClass());
        return JSON.toJSONString(this, config);
    }
}
