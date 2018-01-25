package com.hp.po;

public class User {

    private int userId;
    private String userName;
    private String password;
    private String realName;
    private String sex;
    private String tel;
    private String idCard;
    private String address;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", realName=" + realName
                + ", sex=" + sex + ", tel=" + tel + ", idCard=" + idCard + ", address=" + address + "]";
    }

    
    
}
