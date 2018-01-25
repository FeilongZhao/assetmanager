package com.hp.po;

public class Bank {

    private int bankId;
    private String bankName;
    private String bankTel;
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
    public String getBankTel() {
        return bankTel;
    }
    public void setBankTel(String bankTel) {
        this.bankTel = bankTel;
    }
    @Override
    public String toString() {
        return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", bankTel=" + bankTel + "]";
    }
    
}
