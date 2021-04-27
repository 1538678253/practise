package com.bjpowernode.entity;

public class Users {
    private Integer UserId;
    private String UserName,password,sex,eamil;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public Users() {
    }

    public Users(Integer userId, String userName, String password, String sex, String eamil) {
        UserId = userId;
        UserName = userName;
        this.password = password;
        this.sex = sex;
        this.eamil = eamil;
    }
}
