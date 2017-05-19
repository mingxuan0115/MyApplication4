package com.example.zhangwenfang.myapplication;

/**
 * Created by zhangwenfang on 2017/5/7.
 */

public class LoginSuccessdEvent {
    private String msg;

    public LoginSuccessdEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
