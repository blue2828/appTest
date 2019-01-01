package com.example.liuyunhuan.apptest.entity;

public class User implements java.io.Serializable{
    private String username, pwd;

    public User(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public User() {
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
