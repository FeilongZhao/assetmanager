package com.hp.po;

public class Asset1 {
    
    private String userName;
    private int bankId;
    private String bankName;
    private String cardNum;
    private double cardMoney;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getBankId() {
        return bankId;
    }
    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
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
    @Override
    public String toString() {
        return "Asset1 [userName=" + userName + ", bankId=" + bankId + ", bankName=" + bankName + ", cardNum=" + cardNum
                + ", cardMoney=" + cardMoney + "]";
    }

}
