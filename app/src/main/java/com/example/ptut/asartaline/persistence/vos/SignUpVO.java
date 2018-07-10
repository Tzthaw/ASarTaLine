package com.example.ptut.asartaline.persistence.vos;

public class SignUpVO  {
    private long signUpId;
    private String name;
    private String email;
    private String phoneNo;
    private String facebookId="https://www.facebook.com/Phyo.P.M";
    private String password;
    private String joinedDate="2017-05-04 01:02:35";
    private String lastTimeUseApp= "2017-05-04 01:02:35";

    public long getSignUpId() {
        return signUpId;
    }

    public void setSignUpId(long signUpId) {
        this.signUpId = signUpId;
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

    public String getLastTimeUseApp() {
        return lastTimeUseApp;
    }

    public void setLastTimeUseApp(String lastTimeUseApp) {
        this.lastTimeUseApp =lastTimeUseApp;
    }

    @Override
    public String toString() {
        return "{" +
                " name:'" + name + '\'' +
                ", email:'" + email + '\'' +
                ", phoneNo:'" + phoneNo + '\'' +
                ", facebookId:'" + facebookId + '\'' +
                ", password:'" + password + '\'' +
                ", joinedDate:'" + joinedDate + '\'' +
                ", lastTimeUseApp:'" + lastTimeUseApp + '\'' +
                '}';
    }
}
