package com.websocket.demo.websocket_demo.controller.v6;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/13 4:29
 */

/**
 * 用户模型
 */
public class User {

    private String username;

    private String pwd;

    public User(){}

    public User(String username, String pwd){
        super();
        this.username = username;
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
