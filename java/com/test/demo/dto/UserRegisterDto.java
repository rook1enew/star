package com.test.demo.dto;

public class UserRegisterDto {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobileNum;

    /**
     * 密码
     */
    private String pwd;


    /**
     * 用户昵称
     */
    private String nickName;


    /**
     * 用户职位
     */
    private String userPosition;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String uesrPosition) {
        this.userPosition = uesrPosition;
    }
}
