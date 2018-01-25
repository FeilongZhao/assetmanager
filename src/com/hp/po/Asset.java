package com.hp.po;

import java.util.Date;

public class Asset {

    private int bankId;
    private String cardNum;
    private double cardMoney;
    private Date cardDate;
    private int userId;
    public int getBankId() {
        return bankId;
    }
    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
    public String getCardNum() {
        return cardNum;
    }
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
    public double getCardMoney() {
        return cardMoney;
    }
    public void setCardMoney(double cardMoney) {
        this.cardMoney = cardMoney;
    }
    public Date getCardDate() {
        return cardDate;
    }
    public void setCardDate(Date cardDate) {
        this.cardDate = cardDate;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "Asset [bankId=" + bankId + ", cardNum=" + cardNum + ", cardMoney=" + cardMoney + ", cardDate="
                + cardDate + ", userId=" + userId + "]";
    }
    
}
