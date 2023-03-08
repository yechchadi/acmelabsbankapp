package com.acmelabs.SpringAPI.api.model;

import com.acmelabs.SpringAPI.util.UniqueId;

import java.util.Date;

public class Transaction {


    private String transactionID;
    private int amount;
    private Date date;
    private String accountID_ext;

    public Transaction(int amount, String accountID_ext) {
        this.transactionID = UniqueId.generate(15);
        this.amount = amount;
        this.accountID_ext = accountID_ext;
        this.date = new Date();
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccountID_ext() {
        return accountID_ext;
    }

    public void setAccountID_ext(String accountID_ext) {
        this.accountID_ext = accountID_ext;
    }
}
