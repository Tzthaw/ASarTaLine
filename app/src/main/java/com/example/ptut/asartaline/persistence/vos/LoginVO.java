package com.example.ptut.asartaline.persistence.vos;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


public class LoginVO {
    private long userId;
    private String accessToken;
    private String name;
    private String email;
    private String phoneNo;
    private String facebookId;
    private String password;
    private String joinedDate;
    private String lastTimeUserApp;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getLastTimeUserApp() {
        return lastTimeUserApp;
    }

    public void setLastTimeUserApp(String lastTimeUserApp) {
        this.lastTimeUserApp = lastTimeUserApp;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "userId=" + userId +
                ", accessToken='" + accessToken + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", facebookId='" + facebookId + '\'' +
                ", password='" + password + '\'' +
                ", joinedDate='" + joinedDate + '\'' +
                ", lastTimeUserApp='" + lastTimeUserApp + '\'' +
                '}';
    }
}
